package com.example.studentRaytings.mapper;

import com.example.studentRaytings.models.Student;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-26T11:07:57+0400",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.9 (Eclipse Adoptium)"
)
@Component
public class StudentMapperImpl implements StudentMapper {

    @Override
    public StudentDTO toDto(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentDTO studentDTO = new StudentDTO();

        return studentDTO;
    }

    @Override
    public Student toEntity(StudentDTO studentDto) {
        if ( studentDto == null ) {
            return null;
        }

        Student student = new Student();

        return student;
    }

    @Override
    public List<StudentDTO> toDtoList(List<Student> students) {
        if ( students == null ) {
            return null;
        }

        List<StudentDTO> list = new ArrayList<StudentDTO>( students.size() );
        for ( Student student : students ) {
            list.add( toDto( student ) );
        }

        return list;
    }
}
