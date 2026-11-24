
package com.example.studentsystem.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.studentsystem.entity.Student;
import com.example.studentsystem.response.EntityResponse;
import com.example.studentsystem.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    // CREATE STUDENT
    @PostMapping("/create")
    public ResponseEntity<EntityResponse<Student>> createStudent(
            @RequestBody Student student) {

        Student savedStudent = studentService.createStudent(student);

        EntityResponse<Student> response = new EntityResponse<>(
                201,
                "Student Created Successfully",
                savedStudent,
                LocalDateTime.now()
        );

        return ResponseEntity.status(201).body(response);
    }

    // GET STUDENT BY ID
    @GetMapping("/getById/{id}")
    public ResponseEntity<EntityResponse<Student>> getByIdStudent(
            @PathVariable Integer id) {

        Student student = studentService.getByIdStudent(id);

        EntityResponse<Student> response = new EntityResponse<>(
                200,
                "Student Fetched Successfully",
                student,
                LocalDateTime.now()
        );

        return ResponseEntity.ok(response);
    }

    // GET ALL STUDENTS
    @GetMapping("/getAllStudents")
    public ResponseEntity<EntityResponse<List<Student>>> getAllStudent() {

        List<Student> students = studentService.getAllStudents();

        EntityResponse<List<Student>> response = new EntityResponse<>(
                200,
                "All Students Fetched Successfully",
                students,
                LocalDateTime.now()
        );

        return ResponseEntity.ok(response);
    }

    // DELETE STUDENT BY ID
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<EntityResponse<String>> deleteById(
            @PathVariable Integer id) {

        studentService.deleteById(id);

        EntityResponse<String> response = new EntityResponse<>(
                200,
                "Student Deleted Successfully",
                "Record Deleted",
                LocalDateTime.now()
        );

        return ResponseEntity.ok(response);
    }
}
