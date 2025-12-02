package com.example.studentRaytings.services;

import com.example.studentRaytings.models.Student;
import com.example.studentRaytings.models.StudentScore;
import com.example.studentRaytings.repositories.StudentScoreRepository;
import com.example.studentRaytings.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    // Removed unused StudentRepository injection

    @Autowired
    private StudentScoreRepository studentScoreRepository;

    public Student registerUser(Student student) {
        if (userRepository.findByEmail(student.getEmail()).isPresent()) {
            throw new RuntimeException("Bu email artıq qeydiyyatdan keçib!");
        }
        // 1) İlk öncə istifadəçini (Student) bazaya saxlayırıq, beləliklə onun `id` sahəsi olacaq.
        Student savedStudent = userRepository.save(student);

        // 2) Daha sonra həmin Student-ə aid StudentScore obyektini yaradıb əlaqələndiririk.
        StudentScore newStudentScore = new StudentScore();
        newStudentScore.setStudent(savedStudent);
        newStudentScore.setGpaScore(0.0);
        newStudentScore.setProjectScore(0.0);
        newStudentScore.setActivityScore(0.0);
        newStudentScore.setExamScore(0.0);
        newStudentScore.setOverallScore(0.0);

        // StudentScore obyektini bazaya yazırıq (student_id sahəsi dolu olacaq)
        studentScoreRepository.save(newStudentScore);

        // 3) Qayıdışda saxlanmış Student obyektini qaytarırıq
        return savedStudent;
    }

    // Giriş (Login) məntiqi
    public Student loginUser(String email, String rawPassword) {
        // 1. Email-ə görə istifadəçi tapmaq
        Student studentProfile = userRepository.findByEmail(email).orElseThrow();

        // 2. Şifrəni yoxlamaq (Həqiqi layihədə HASH yoxlanılır)
        if (studentProfile.getPassword().equals(rawPassword)) {
            // Şifrələr uyğundur
            return studentProfile;
        } else {
            // Şifrə yanlışdır
            throw new RuntimeException("Email və ya şifrə yanlışdır!");
        }
    }
}
