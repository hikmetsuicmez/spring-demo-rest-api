package com.hikmetsuicmez.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hikmetsuicmez.entities.Student;
import com.hikmetsuicmez.repository.StudentRepository;
import com.hikmetsuicmez.service.StudentService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class StudentManager implements StudentService{

	StudentRepository studentRepository;
	
	
	@Override
	public List<Student> getAll() {
		List<Student> students = studentRepository.findAll();
		return students;
	}

	@Override
	public Student add(Student student) {
		Student resultUser = studentRepository.save(student);
		return resultUser;
	}

	@Override
	public Student getById(Integer id) {
		Optional<Student> student = studentRepository.findById(id);
		if (student.isPresent()) {
			return student.get();
		}
		return null;
	}

	@Override
	public Student update(Integer id, Student student) {
		Optional<Student> resultStudent = studentRepository.findById(id); 
		if (resultStudent.isPresent()) {
			resultStudent.get().setFirstName(student.getFirstName());
			resultStudent.get().setLastName(student.getLastName());
			resultStudent.get().setAge(student.getAge());
			return studentRepository.save(resultStudent.get());
		}
		return null;
	}

	@Override
	public Boolean delete(Integer id) {
		Optional<Student> student = studentRepository.findById(id);
		if (student.isPresent()) {
			studentRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
