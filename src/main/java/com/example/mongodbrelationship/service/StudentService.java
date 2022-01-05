package com.example.mongodbrelationship.service;

import com.example.mongodbrelationship.entity.Student;
import com.example.mongodbrelationship.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class StudentService{

	private final StudentRepository studentRepository;
	
	public  List<Student> getAllStudents(){
	
		return studentRepository.findAll();
	}
}