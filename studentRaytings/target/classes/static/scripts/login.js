  const LOGIN_API_URL = 'http://localhost:8080/api/auth/login';


    const form = document.getElementById('login-form');
    const messageDiv = document.getElementById('login-message');

    form.addEventListener('submit', async function(e) {
        e.preventDefault();

        messageDiv.style.display = 'block';
        messageDiv.textContent = 'Giriş yoxlanılır...';
        messageDiv.style.color = '#3498db';

        const loginData = {
            email: document.getElementById('email').value,
            password: document.getElementById('password').value
        };

        try {
            const response = await fetch(LOGIN_API_URL, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(loginData)
            });

            // login.html faylındakı JavaScript-in YENİLƏNMİŞ hissəsi

            if (response.ok) {
                // 1. Serverdən gələn JSON-u oxuyuruq
                const result = await response.json();
                console.log('login response', result);
                // 2. JSON-dan telebenin ID-sini və adını götürürük
                const studentId = result.studentId;
                const studentName = result.name;

                function isValidId(id) {
                    return id !== null && id !== '' && id !== 'undefined' && !Number.isNaN(Number(id));
                }

                // Prefer to validate ID before showing a success redirect message.
                if (!isValidId(studentId)) {
                    messageDiv.textContent = `Giriş uğurludur amma istifadəçi ID-si mövcud deyil.`;
                    messageDiv.style.color = 'orange';
                    return;
                }

                // Use a safe display name fallback and then redirect.
                const displayName = (studentName && studentName !== 'undefined') ? studentName : 'istifadəçi';
                messageDiv.textContent = `Giriş uğurludur, ${displayName}! Yönləndirilir...`;
                messageDiv.style.color = 'green';

                setTimeout(() => {
                    window.location.href = `student-profile.html?id=${encodeURIComponent(studentId)}`;
                }, 1000);

            } else {
                // ... Xəta hissəsi dəyişməz qalır ...
                const errorText = await response.text();
                messageDiv.textContent = `Giriş uğursuz oldu: ${errorText}`;
                messageDiv.style.color = 'red';
            }

        } catch (error) {
            messageDiv.textContent = 'Serverə qoşularkən xəta baş verdi. Zəhmət olmasa, Spring Boot tətbiqinizin işlək olduğundan əmin olun.';
            messageDiv.style.color = 'red';
            console.error("Login Fetch Error:", error);
        }
    });