package com.hikmetsuicmez.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hikmetsuicmez.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	
}
