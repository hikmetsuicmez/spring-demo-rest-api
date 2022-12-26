package com.hikmetsuicmez.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hikmetsuicmez.entities.Student;
import com.hikmetsuicmez.service.StudentService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/students")
@AllArgsConstructor
public class StudentsController {
	
	private StudentService service;
	
	@GetMapping("/getAll")
	public List<Student> getAll() {
		List<Student> students = service.getAll();
		return students;
	}
	
	@PostMapping("/add")
	public ResponseEntity<Student> add(@RequestBody Student student) {
		Student resultStudent = service.add(student);
		return ResponseEntity.ok(resultStudent);
	}
	
	@GetMapping("getById/{id}")
	public ResponseEntity<Student> getById(@PathVariable("id") Integer id) {
		Student student = service.getById(id);
		return ResponseEntity.ok(student);
	}
	
	@PutMapping("edit/{id}") 
	public ResponseEntity<Student> update(@PathVariable("id") Integer id, Student student) {
		Student resultStudent = service.update(id,student);
		return ResponseEntity.ok(resultStudent);
	}
	
	
	@DeleteMapping("remove/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable("id") Integer id) {
		Boolean status = service.delete(id);
		return ResponseEntity.ok(status);
		
	}
	
	
	
	
}
