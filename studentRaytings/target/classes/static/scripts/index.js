// script.js

const apiUrl = "/api/students"; 
let editId = null;
let studentModal = null; 

document.addEventListener('DOMContentLoaded', () => {
    // Initialize Bootstrap Modal
    const modalElement = document.getElementById('studentModal');
    if (modalElement) {
        studentModal = new bootstrap.Modal(modalElement);
    }
    
    fetchStudents();
    setupScoreCalculation();
    setupDarkModeToggle();
});

// --- Core Functions ---

function computeScore(correct, wrong) {
    return (Number(correct) || 0) * 4 - (Number(wrong) || 0);
}

async function fetchStudents() {
    try {
        // Placeholder Student Data (API çağırışı simulyasiyası)
        const data = [
            { id: 1, fullName: "Əliyev Cavid", groupName: "Qrup A", totalExams: 5, correctAnswers: 80, wrongAnswers: 10, totalScore: 310 },
            { id: 2, fullName: "Həsənova Leyla", groupName: "Qrup B", totalExams: 6, correctAnswers: 95, wrongAnswers: 5, totalScore: 375 },
            { id: 3, fullName: "Məmmədov Tural", groupName: "Qrup A", totalExams: 4, correctAnswers: 60, wrongAnswers: 20, totalScore: 220 },
        ];
        
        // Sort by totalScore descending for leaderboard
        data.sort((a, b) => b.totalScore - a.totalScore);
        
        const tbody = document.querySelector("#studentsTable tbody");
        tbody.innerHTML = ""; 

        data.forEach((s, i) => {
            const rowClass = i === 0 ? 'table-warning' : ''; 
            tbody.innerHTML += `
                <tr class="${rowClass}">
                    <th scope="row">${i + 1}</th>
                    <td>${s.fullName}</td>
                    <td>${s.groupName}</td>
                    <td>${s.totalExams}</td>
                    <td>${s.correctAnswers}</td>
                    <td>${s.wrongAnswers}</td>
                    <td><b>${s.totalScore}</b></td>
                </tr>
            `;
        });
    } catch (error) {
        console.error("Error fetching students:", error);
    }
}

function setupScoreCalculation() {
    const correctInput = document.getElementById("correctAnswers");
    const wrongInput = document.getElementById("wrongAnswers");
    const scoreDisplay = document.getElementById("computedScore");

    if (correctInput && wrongInput && scoreDisplay) {
        const updateScore = () => {
            const c = correctInput.value;
            const w = wrongInput.value;
            scoreDisplay.innerText = computeScore(c, w);
        };

        correctInput.addEventListener("input", updateScore);
        wrongInput.addEventListener("input", updateScore);
    }
}

// --- Form/Modal Functions ---
// Qeyd: openEditForm funksiyası Actions sütunu silindiyi üçün aradan qaldırılıb.

function openCreateForm() {
    editId = null;
    document.getElementById("studentModalLabel").innerText = "Tələbə Yarat";
    document.getElementById("studentForm")?.reset(); 
    document.getElementById("computedScore").innerText = "0";
    studentModal?.show();
}

async function saveStudent() {
    const form = document.getElementById('studentForm');
    if (!form) return;

    if (!form.checkValidity()) {
        form.reportValidity();
        return;
    }

    const payload = {
        fullName: document.getElementById("fullName")?.value,
        groupName: document.getElementById("groupName")?.value,
        totalExams: Number(document.getElementById("totalExams")?.value),
        correctAnswers: Number(document.getElementById("correctAnswers")?.value),
        wrongAnswers: Number(document.getElementById("wrongAnswers")?.value),
        totalScore: computeScore(
            document.getElementById("correctAnswers")?.value,
            document.getElementById("wrongAnswers")?.value
        )
    };

    // Placeholder: Simulate API call
    let method = "POST";
    let url = apiUrl;
    
    console.log(`${method} ${url} with payload:`, payload);
    alert(`Yeni tələbə məlumatları əlavə edildi! (API çağırışı simulyasiya edildi)`);

    studentModal?.hide();
    fetchStudents(); 
}

// --- Dark Mode Functionality ---

function setupDarkModeToggle() {
    const toggleButton = document.getElementById('darkModeToggle');
    const htmlElement = document.documentElement; 
    
    if (!toggleButton) return;

    const prefersDark = window.matchMedia('(prefers-color-scheme: dark)').matches;
    let currentTheme = localStorage.getItem('theme') || (prefersDark ? 'dark' : 'light');

    const applyTheme = (theme) => {
        htmlElement.setAttribute('data-bs-theme', theme);
        // İkona dəyişiklik: günəş (light) və ya ay (dark)
        toggleButton.className = theme === 'dark' ? 'bi bi-moon-stars-fill dark-mode-toggle' : 'bi bi-sun dark-mode-toggle';
        localStorage.setItem('theme', theme);
    };

    applyTheme(currentTheme);

    toggleButton.addEventListener('click', () => {
        const newTheme = htmlElement.getAttribute('data-bs-theme') === 'dark' ? 'light' : 'dark';
        applyTheme(newTheme);
    });
}