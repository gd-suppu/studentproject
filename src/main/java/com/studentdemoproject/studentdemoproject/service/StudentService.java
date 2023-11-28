package com.studentdemoproject.studentdemoproject.service;

import com.studentdemoproject.studentdemoproject.model.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(Student student);
    Student updateStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentbyId(long studentId);

    void deleteStudent(long id);

}
