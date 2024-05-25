package com.docker.crud.serviceImpl;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docker.crud.model.Student;
import com.docker.crud.repository.StudentRepository;
import com.docker.crud.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	StudentRepository studentRepository;
	
	@Override
	public Optional<Student> getStudent(BigInteger studentId) {
		return studentRepository.findById(studentId);
	}

	@Override
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student createStudent(Student student) {
		Student createdStudent 	= studentRepository.save(student);
		return (createdStudent != null) ? createdStudent : null;
	}

	@Override
	public Student updateStudent(BigInteger studentId, Student updatedStudent) {
		Optional<Student> student = studentRepository.findById(studentId);
		if(student.isPresent()) {
			return studentRepository.save(updatedStudent);
		}else
			return null;
	}

	@Override
	public String removeStudent(BigInteger studentId) {
		Student student = studentRepository.findById(studentId).orElse(null);
		if(student != null) {
			studentRepository.deleteById(studentId);
		    return "Recored Deleted.";
		}else {
			return "Recored not found.";
		}
	}
	
}





















