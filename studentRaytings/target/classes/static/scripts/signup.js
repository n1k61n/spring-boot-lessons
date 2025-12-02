   const SIGNUP_API_URL = 'http://localhost:8080/api/auth/signup';
    const form = document.getElementById('signup-form');
    const messageDiv = document.getElementById('signup-message');

    form.addEventListener('submit', async function(e) {
        e.preventDefault();

        messageDiv.style.display = 'block';
        messageDiv.textContent = 'Qeydiyyat aparılır...';
        messageDiv.style.color = '#3498db'; // Gözləmə mesajı

        const userData = {
            name: document.getElementById('fullname').value,
            email: document.getElementById('email').value,
            password: document.getElementById('password').value
        };

        try {
            const response = await fetch(SIGNUP_API_URL, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(userData)
            });

            if (response.ok) {
                // Uğurlu qeydiyyat
                messageDiv.textContent = 'Qeydiyyat uğurla tamamlandı. İndi daxil ola bilərsiniz.';
                messageDiv.style.color = 'green';
                form.reset(); // Formu təmizlə

                // 2 saniyə sonra Giriş səhifəsinə yönləndirmə
                setTimeout(() => {
                    window.location.href = 'login.html';
                }, 2000);

            } else {
                // Xəta (məsələn, 400 Bad Request, çünki email artıq mövcuddur)
                const errorText = await response.text();
                messageDiv.textContent = `Qeydiyyat uğursuz oldu: ${errorText}`;
                messageDiv.style.color = 'red';
            }
        } catch (error) {
            messageDiv.textContent = 'Serverə qoşularkən xəta baş verdi. Zəhmət olmasa, yenidən cəhd edin.';
            messageDiv.style.color = 'red';
            console.error("Signup Fetch Error:", error);
        }
    });