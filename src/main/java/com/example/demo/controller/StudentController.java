package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/students")
public class StudentController {
    private StudentService studentService;
    @Autowired
    public StudentController( StudentService studentService) {
        this.studentService=studentService;
    }

    @GetMapping
    public List<Student> getAllStudents(){
        Student s = new Student(UUID.randomUUID(),"test name");
        return studentService.getAllStudents();
    }

    @PostMapping
    public String addStudent(@RequestBody Student student){
        studentService.addStudent(student);
        return "added";
    }

    @PutMapping
    public String updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
        return "updated";
    }
    @DeleteMapping(path="{id}")
    public String deleteStudent(@PathVariable("id") UUID id){
        studentService.deleteStudent(id);
        return "deleted";

    }


}
