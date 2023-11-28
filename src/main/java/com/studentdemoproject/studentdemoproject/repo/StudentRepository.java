package com.studentdemoproject.studentdemoproject.repo;

import com.studentdemoproject.studentdemoproject.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
