package com.example.studentRaytings.mapper;


import com.example.studentRaytings.dtos.StudentResponse;
import com.example.studentRaytings.models.Student;
import org.mapstruct.Mapper;

import java.util.List;


// MapStruct-a bu interfeysə əsaslanaraq Spring Bean yaratmasını deyirik.
// Bu, əvvəlki xətanı (@Mapper bean tapılmadı) həll edəcək.
@Mapper(componentModel = "spring")
public interface StudentMapper {

    /**
     * Student Entity obyektini StudentDTO obyektinə çevirir.
     * Bu metod adətən GET əməliyyatlarında məlumat bazasından gələn məlumatı
     * kənar dünya (API) üçün hazırlamaq üçün istifadə olunur.
     */
    StudentDTO toDto(Student student);

    /**
     * StudentDTO obyektini Student Entity obyektinə çevirir.
     * Bu metod adətən POST/PUT əməliyyatlarında gələn məlumatı
     * məlumat bazasına yazmaq üçün hazırlamaq üçün istifadə olunur.
     */
    Student toEntity(StudentDTO studentDto);
    
    /**
     * Entity listini DTO listinə çevirir (İstəyə bağlı).
     */
    List<StudentDTO> toDtoList(List<Student> students);

    StudentResponse toResponse(Student student);

    // Əgər yalnız bir sahənin yenilənməsi lazımdırsa (PUT üçün faydalıdır):
    // @Mapping(target = "id", ignore = true) // ID-ni yeniləməyi qarşısını alır
    // void updateStudentFromDto(StudentDTO studentDto, @MappingTarget Student student);

}