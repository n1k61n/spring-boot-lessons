  const API_BASE_URL = 'http://localhost:8080/api/students';
    const form = document.getElementById('exam-result-form');
    const messageDiv = document.getElementById('message');

    form.addEventListener('submit', async function(e) {
        e.preventDefault();

        const studentId = document.getElementById('studentId').value;
        const examScore = parseFloat(document.getElementById('examScore').value);

        function isValidId(id) {
            return id !== null && id !== '' && id !== 'undefined' && !Number.isNaN(Number(id));
        }

        if (!isValidId(studentId)) {
            showMessage('error', 'Xəta: Etibarlı tələbə ID-si daxil edilməyib.');
            return;
        }

        const resultData = {
            examScore: examScore
        };

        // PUT /api/students/{id}/exam-result endpointinə göndəririk
        const endpoint = `${API_BASE_URL}/${encodeURIComponent(studentId)}/exam-result`;

        try {
            const response = await fetch(endpoint, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(resultData)
            });

            if (response.ok) {
                const result = await response.json();
                showMessage('success', `ID ${studentId} olan tələbənin balı yeniləndi. Yeni Ümumi Bal: **${result.overallScore.toFixed(2)}**.`);
                form.reset();
            } else if (response.status === 404) {
                showMessage('error', `Xəta: Tələbə ID ${studentId} tapılmadı.`);
            } else {
                showMessage('error', `Nəticəni daxil edərkən xəta baş verdi: ${response.status}`);
            }
        } catch (error) {
            showMessage('error', `Serverə qoşularkən xəta: Server işləkdirmi?`);
            console.error("Exam Result Fetch Error:", error);
        }
    });

    function showMessage(type, text) {
        messageDiv.className = `message ${type}`;
        messageDiv.innerHTML = text;
        messageDiv.style.display = 'block';
    }