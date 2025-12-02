package com.example.studentRaytings.controllers;

import com.example.studentRaytings.dtos.StudentRequest;
import com.example.studentRaytings.dtos.StudentResponse;
import com.example.studentRaytings.models.Student;
import com.example.studentRaytings.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService service;

    @GetMapping
    public List<StudentResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public StudentResponse getOne(@PathVariable Long id) {
        return service.getOne(id);
    }

    @PostMapping
    public StudentResponse create(@RequestBody StudentRequest dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public StudentResponse update(@PathVariable Long id,
                                  @RequestBody StudentRequest dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
