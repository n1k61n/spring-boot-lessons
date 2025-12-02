  const QUIZ_API_URL = 'http://localhost:8080/api/quiz/questions'; // Sualları çəkən yeni API
    const SCORE_UPDATE_API_URL = 'http://localhost:8080/api/students'; // Nəticəni yeniləyən API

    const quizFormDiv = document.getElementById('quiz-form');
    const submitButton = document.getElementById('submit-button');
    const messageDiv = document.getElementById('message');
    const loadingDiv = document.getElementById('loading');

    const urlParams = new URLSearchParams(window.location.search);
    const studentId = urlParams.get('id');

    function isValidId(id) {
        return id !== null && id !== '' && id !== 'undefined' && !Number.isNaN(Number(id));
    }

    let fetchedQuestions = []; // Bazadan çəkilən sualları saxlamaq üçün

    if (!isValidId(studentId)) {
        loadingDiv.className = 'error message';
        loadingDiv.textContent = 'Xəta: Tələbə ID-si tapılmadı.';
        submitButton.style.display = 'none';
    } else {
        fetchQuizQuestions();
    }

    async function fetchQuizQuestions() {
        try {
            const response = await fetch(QUIZ_API_URL);
            if (!response.ok) {
                throw new Error('Sualları çəkərkən xəta: ' + response.statusText);
            }
            fetchedQuestions = await response.json();

            if (fetchedQuestions.length === 0) {
                 loadingDiv.className = 'error message';
                 loadingDiv.textContent = 'Xəta: Bazada heç bir sual tapılmadı. Data İnitializer-i yoxlayın.';
            } else {
                renderQuiz();
            }

        } catch (error) {
            loadingDiv.className = 'error message';
            loadingDiv.textContent = `Server xətası: Suallar yüklənmədi. (${error.message})`;
            console.error("Fetch Quiz Error:", error);
        }
    }

    function renderQuiz() {
        loadingDiv.style.display = 'none';
        submitButton.style.display = 'block';

        fetchedQuestions.forEach((item, index) => {
            const questionIndex = index + 1;
            const section = document.createElement('div');
            section.className = 'quiz-section';
            section.innerHTML = `<div class="question-text">${questionIndex}. ${item.questionText}</div>`;

            // Seçimlər massivini yaradırıq (A, B, C, D)
            const options = [
                { value: 'A', text: item.optionA },
                { value: 'B', text: item.optionB },
                { value: 'C', text: item.optionC },
                { value: 'D', text: item.optionD }
            ];

            options.forEach((option) => {
                const optionId = `q${questionIndex}o${option.value}`;
                section.innerHTML += `
                    <label for="${optionId}" class="option-label">
                        <input type="radio" id="${optionId}" name="question${questionIndex}" value="${option.value}" required>
                        ${option.value}) ${option.text}
                    </label>
                `;
            });
            quizFormDiv.appendChild(section);
        });
    }

    submitButton.addEventListener('click', calculateAndSubmitScore);

    async function calculateAndSubmitScore() {
        let correctAnswers = 0;
        const totalQuestions = fetchedQuestions.length;
        const scorePerQuestion = 100 / totalQuestions;

        // 1. Balı Hesabla
        fetchedQuestions.forEach((item, index) => {
            const questionName = `question${index + 1}`;
            const selectedOption = document.querySelector(`input[name="${questionName}"]:checked`);

            if (selectedOption && selectedOption.value === item.correctAnswer) {
                correctAnswers++;
            }
        });

        // 2. Ümumi balı 0-100 şkalasında tap
        const finalExamScore = correctAnswers * scorePerQuestion;

        messageDiv.className = 'info message';
        messageDiv.textContent = `Nəticəniz: ${correctAnswers}/${totalQuestions}. Ümumi Bal: ${finalExamScore.toFixed(2)}. Göndərilir...`;
        messageDiv.style.display = 'block';
        submitButton.disabled = true;

        // 3. Nəticəni Backend-ə Göndər
        if (!isValidId(studentId)) {
            messageDiv.className = 'error message';
            messageDiv.textContent = 'Xəta: Etibarlı tələbə ID-si yoxdur.';
            submitButton.disabled = false;
            return;
        }

        const endpoint = `${SCORE_UPDATE_API_URL}/${encodeURIComponent(studentId)}/exam-result`;

        try {
            // ... (Əvvəlki cavabdakı kimi PUT sorğusu)
            const response = await fetch(endpoint, {
                method: 'PUT',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ examScore: finalExamScore })
            });

            if (response.ok) {
                const result = await response.json();
                messageDiv.className = 'success message';
                messageDiv.innerHTML = `TƏBRİKLƏR! 🏆 İmtahan nəticəsi **${finalExamScore.toFixed(2)} bal** olaraq bazaya yazıldı. Yeni Reytinq Balınız: **${result.overallScore.toFixed(2)}**.`;

                 setTimeout(() => {
                     window.location.href = `student-profile.html?id=${encodeURIComponent(studentId)}`;
                 }, 3000);

            } else {
                const errorDetails = await response.text();
                messageDiv.className = 'error message';
                messageDiv.textContent = `Xəta: Nəticəni daxil edərkən xəta: ${errorDetails}`;
            }
        } catch (error) {
            messageDiv.className = 'error message';
            messageDiv.textContent = `Serverə qoşularkən xəta: Server işləkdirmi?`;
            console.error("Score Update Error:", error);
            submitButton.disabled = false;
        }
    }