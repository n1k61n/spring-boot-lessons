package com.example.studentRaytings.repositories;



import com.example.studentRaytings.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Student, Long> {

    
    Optional<Student> findByEmail(String email);
    Optional<Student> findByGroupName(String groupName);

}