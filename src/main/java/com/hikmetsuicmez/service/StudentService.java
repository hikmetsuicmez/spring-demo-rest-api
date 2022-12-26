package com.hikmetsuicmez.service;

import java.util.List;

import com.hikmetsuicmez.entities.Student;

public interface StudentService {
	List<Student> getAll();
	Student add(Student student);
	Student getById(Integer id);
	Student update(Integer id, Student student);
	Boolean delete(Integer id);
}
