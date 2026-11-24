package com.example.studentsystem.service;

import java.util.List;

import com.example.studentsystem.entity.Student;

public interface StudentService {

	Student createStudent(Student student);
	Student getByIdStudent(Integer id);
	List<Student> getAllStudents();
	String deleteById(Integer id);
	
}
