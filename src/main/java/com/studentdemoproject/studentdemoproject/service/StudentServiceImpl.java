package com.studentdemoproject.studentdemoproject.service;

import com.studentdemoproject.studentdemoproject.exception.ResourceNotFoundException;
import com.studentdemoproject.studentdemoproject.model.Student;
import com.studentdemoproject.studentdemoproject.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student student) {
        Optional<Student> studentDb=this.studentRepository.findById(student.getId());
        if(studentDb.isPresent()){
            Student studentUpdate=studentDb.get();
            studentUpdate.setId(student.getId());
            studentUpdate.setName(student.getName());
            studentUpdate.setTestScore(student.getTestScore());
            studentRepository.save(studentUpdate);
            return studentUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + student.getId());
        }
    }

    @Override
    public List<Student> getAllStudents() {
        return this.studentRepository.findAll();
    }

    @Override
    public Student getStudentbyId(long studentId) {
        Optional<Student> studentDb=this.studentRepository.findById(studentId);
        if(studentDb.isPresent()){
            return studentDb.get();
        }
        else{
            throw new ResourceNotFoundException("Record not found with id : " + studentId);
        }
    }

    @Override
    public void deleteStudent(long studentId) {
        Optional < Student > studentDb = this.studentRepository.findById(studentId);

        if (studentDb.isPresent()) {
            this.studentRepository.delete(studentDb.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + studentId);
        }
    }
}
