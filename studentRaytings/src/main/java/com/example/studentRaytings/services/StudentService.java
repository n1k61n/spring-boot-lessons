package com.example.studentRaytings.services;


import com.example.studentRaytings.dtos.StudentRequest;
import com.example.studentRaytings.dtos.StudentResponse;
import com.example.studentRaytings.exceptions.NotFoundException;
import com.example.studentRaytings.mapper.StudentMapper;
import com.example.studentRaytings.models.Student;
import com.example.studentRaytings.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repo;
    private final StudentMapper mapper;

    public List<StudentResponse> getAll() {
        return repo.findAllByOrderByTotalScoreDesc()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    public StudentResponse getOne(Long id) {
        return mapper.toResponse(
                repo.findById(id)
                        .orElseThrow(() -> new NotFoundException("Student tapılmadı: " + id))
        );
    }

    public StudentResponse create(StudentRequest dto) {
        Student s = mapper.toEntity(dto);
        s.setTotalScore(calcScore(s));
        return mapper.toResponse(repo.save(s));
    }

    public StudentResponse update(Long id, StudentRequest dto) {
        Student s = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Student tapılmadı: " + id));

        s.setFullName(dto.getFullName());
        s.setGroupName(dto.getGroupName());
        s.setTotalExams(dto.getTotalExams());
        s.setCorrectAnswers(dto.getCorrectAnswers());
        s.setWrongAnswers(dto.getWrongAnswers());

        s.setTotalScore(calcScore(s));

        return mapper.toResponse(repo.save(s));
    }

    public void delete(Long id) {
        if (!repo.existsById(id))
            throw new NotFoundException("Student tapılmadı: " + id);
        repo.deleteById(id);
    }

    private int calcScore(Student s) {
        return s.getCorrectAnswers() * 4 - s.getWrongAnswers();
    }
}
