package com.jonayed.StudentManagement.controller;


import com.jonayed.StudentManagement.dtos.StudentRequestDTOS;
import com.jonayed.StudentManagement.entity.Student;
import com.jonayed.StudentManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    StudentService studentService;
    @GetMapping("/all-student")
    public ResponseEntity<?> getAllStudent() {

       return studentService.getAllStudents();
    }

    @PostMapping("/student")
    public ResponseEntity<?> addStudent(@RequestBody StudentRequestDTOS student) {

        return studentService.addStudent(student);
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable int id) {

        return studentService.deleteStudents(id);
    }

}
