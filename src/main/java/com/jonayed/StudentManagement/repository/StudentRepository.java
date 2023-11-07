package com.jonayed.StudentManagement.repository;

import com.jonayed.StudentManagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
