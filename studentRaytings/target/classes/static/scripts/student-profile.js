 const API_BASE_URL = 'http://localhost:8080/api/students';
    const contentDiv = document.getElementById('profile-content');
    const errorDiv = document.getElementById('error-message');
    const examButton = document.getElementById('exam-button');

    // URL-dən telebə ID-sini götürürük (Məsələn: student-profile.html?id=5)
    const urlParams = new URLSearchParams(window.location.search);
    const studentId = urlParams.get('id');

    function isValidId(id) {
        return id !== null && id !== '' && id !== 'undefined' && !Number.isNaN(Number(id));
    }

    if (!isValidId(studentId)) {
        contentDiv.innerHTML = '<div class="error">Xəta: Tələbə ID-si tapılmadı.</div>';
    } else {
        fetchStudentData(studentId);
    }

    function startExam() {
        const studentId = new URLSearchParams(window.location.search).get('id');
        if (!isValidId(studentId)) {
            errorDiv.innerHTML = '<div class="error">Xəta: Etibarlı tələbə ID-si tapılmadı, imtahana keçid mümkün deyil.</div>';
            return;
        }
        window.location.href = `/exam.html?id=${encodeURIComponent(studentId)}`;
    }

    async function fetchStudentData(id) {
        try {
            const response = await fetch(`${API_BASE_URL}/${id}`);

            if (response.ok) {
                const student = await response.json();
                renderProfile(student);
                examButton.style.display = 'block';
                examButton.onclick = () => {
                    // İmtahan nəticəsinin daxil edilməsi səhifəsinə yönləndirmə
                    const idToUse = isValidId(studentId) ? studentId : student.id;
                    window.location.href = `quiz.html?id=${encodeURIComponent(idToUse)}`;
                };
            } else if (response.status === 404) {
                contentDiv.innerHTML = `<div class="error">ID ${id} olan telebə bazada tapılmadı.</div>`;
            } else {
                throw new Error('Server xətası: ' + response.status);
            }
        } catch (error) {
            contentDiv.innerHTML = `<div class="error">Məlumat yüklənərkən xəta: ${error.message}</div>`;
            console.error("Fetch Error:", error);
        }
    }

    function renderProfile(student) {
        contentDiv.innerHTML = `
            <div class="info-group">
                <span class="info-label">ID:</span>
                <span class="info-value">${student.id}</span>
            </div>
            <div class="info-group">
                <span class="info-label">Ad, Soyad:</span>
                <span class="info-value">${student.name}</span>
            </div>
            <div class="info-group">
                <span class="info-label">Ümumi Reytinq Balı:</span>
                <span class="info-value">${student.overallScore.toFixed(2)}</span>
            </div>
            <div class="info-group">
                <span class="info-label">Akademik Bal (GPA):</span>
                <span class="info-value">${student.gpaScore}</span>
            </div>
            <div class="info-group">
                <span class="info-label">İmtahan Balı:</span>
                <span class="info-value">${student.examScore.toFixed(2)}</span>
            </div>
            `;
    }

