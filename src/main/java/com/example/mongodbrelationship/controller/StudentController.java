package com.example.mongodbrelationship.controller;

import com.example.mongodbrelationship.entity.Student;
import com.example.mongodbrelationship.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/students")
public class StudentController{

	private final StudentService studentService;

	@GetMapping
	public List<Student> fetchAllStudents(){
	
		return this.studentService.getAllStudents();
	}

}
