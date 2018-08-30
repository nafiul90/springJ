package com.example.springdemo.service;

import com.example.springdemo.model.Student;
import com.example.springdemo.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public Iterable<Student> getStudents(){
        return studentRepo.findAll();
    }

    public void save(Student student) {
        studentRepo.save(student);
    }
}
