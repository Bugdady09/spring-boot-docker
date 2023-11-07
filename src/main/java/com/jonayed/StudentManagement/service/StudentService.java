package com.jonayed.StudentManagement.service;

import com.jonayed.StudentManagement.dtos.StudentRequestDTOS;
import com.jonayed.StudentManagement.entity.Student;
import com.jonayed.StudentManagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    public ResponseEntity<?> getAllStudents() {
        List<Student> allStudents = studentRepository.findAll();
        return new ResponseEntity<>(allStudents, HttpStatus.OK);
    }

    public ResponseEntity<?> addStudent(StudentRequestDTOS student) {
        Student savedData = new Student();
        savedData.setMarks(student.getMarks());
        savedData.setName(student.getName());
        savedData = studentRepository.save(savedData);
        return new ResponseEntity<>(savedData, HttpStatus.CREATED);
    }

    public ResponseEntity<?> deleteStudents(int id) {
        Optional<Student> data = studentRepository.findById(id);
        if (data.isEmpty()) {
            return new ResponseEntity<>("No data found to delete", HttpStatus.NOT_FOUND);
        }
        studentRepository.delete(data.get());
        return new ResponseEntity<>("Deleted successfully.", HttpStatus.OK);
    }

}
