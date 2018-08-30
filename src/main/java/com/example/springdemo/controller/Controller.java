package com.example.springdemo.controller;


import com.example.springdemo.model.Student;
import com.example.springdemo.repository.StudentRepo;
import com.example.springdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class Controller {

    private StudentService studentService;
    private StudentRepo studentRepo;

    public Controller(StudentService studentService,StudentRepo studentRepo) {
        this.studentService = studentService;
        this.studentRepo=studentRepo;
    }

    @RequestMapping("hello")
    @ResponseBody
    public String sayHello(){
        return "hello bangladesh";
    }

    @RequestMapping("hi/{name}")
    @ResponseBody
    public String sayHi(@PathVariable String name){
        return "hi"+name;
    }

    @PostMapping("addStudent")
    @ResponseBody
    public Student addStudent(@RequestBody Student student){
        studentService.save(student);

        return student;
    }

    //@RequestMapping(value = "updateStudent",method = RequestMethod.PUT)
    @PutMapping("updateStudent")
    @ResponseBody
    public Student updateStudent(@RequestBody Student student){
        studentRepo.save(student);

        return student;
    }

    @DeleteMapping("deleteStudent")
    @ResponseBody
    public Student deleteStudent(@RequestBody Student student){
        studentRepo.delete(student);
        return student;
    }

    @DeleteMapping("deleteStudentById/{id}")
    @ResponseBody
    public Student deleteStudentById(@PathVariable int id){
        Student student=studentRepo.findById(id).orElse(null);

        studentRepo.deleteById(id);

        return student;
    }

    @RequestMapping("students")
    @ResponseBody
    public Iterable<Student> getAllStudent(){
        return studentRepo.findAll();
    }


}
