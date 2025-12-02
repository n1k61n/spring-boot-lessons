   const API_URL = 'http://localhost:8080/api/students';
    const form = document.getElementById('create-student-form');
    const messageDiv = document.getElementById('message');

    form.addEventListener('submit', async function(e) {
        e.preventDefault();

        const studentData = {
            name: document.getElementById('name').value,
            gpaScore: parseFloat(document.getElementById('gpaScore').value),
            projectScore: parseFloat(document.getElementById('projectScore').value),
            activityScore: parseFloat(document.getElementById('activityScore').value)
        };

        try {
            const response = await fetch(API_URL, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(studentData)
            });

            if (response.ok) {
                const result = await response.json();
                showMessage('success', `Tələbə **${result.name}** uğurla əlavə edildi. Ümumi Balı: **${result.overallScore.toFixed(2)}**.`);
                form.reset(); // Formu təmizlə
            } else {
                const errorText = await response.text();
                showMessage('error', `Məlumat göndərilərkən xəta: ${response.status} ${errorText}`);
            }
        } catch (error) {
            showMessage('error', `Serverə qoşularkən xəta baş verdi. Server işləkdirmi?`);
            console.error("Fetch Error:", error);
        }
    });

    function showMessage(type, text) {
        messageDiv.className = `message ${type}`;
        messageDiv.innerHTML = text;
        messageDiv.style.display = 'block';
    }