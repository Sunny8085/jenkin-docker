package com.docker.crud.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import com.docker.crud.model.Student;

public interface StudentService {

	Optional<Student> getStudent(BigInteger studentId);

	List<Student> getStudents();

	Student createStudent(Student student);

	Student updateStudent(BigInteger studentId, Student updatedStudent);

	String removeStudent(BigInteger studentId);
	
}
