package com.docker.crud.controller;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.docker.crud.model.Student;
import com.docker.crud.service.StudentService;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {
	@Autowired
	private StudentService studentService;
	@GetMapping("/{studentId}")
	public ResponseEntity<Student> getStudentById(@PathVariable BigInteger studentId) {
		System.out.println("Test jenkins v2");
		Optional<Student> student = studentService.getStudent(studentId);
		return student.map(s -> ResponseEntity.ok().body(s)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Student>> getAllStudent(){
		List<Student> students = studentService.getStudents();
		return (students != null) ? ResponseEntity.ok().body(students):ResponseEntity.notFound().build();
	}
	
	@PostMapping("/")
	public ResponseEntity<Student> createStudent(@RequestBody Student student){
		Student updatedRecored = studentService.createStudent(student);
		if(updatedRecored != null) 
			return ResponseEntity.status(HttpStatus.CREATED).body(updatedRecored);
		else 
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	@PutMapping("/{studentId}")
	public ResponseEntity<Student> updateStudent(@PathVariable BigInteger studentId,@RequestBody Student updatedStudent){
		Student student = studentService.updateStudent(studentId,updatedStudent);
		return ResponseEntity.status(HttpStatus.CREATED).body(student);
	}
	
	@DeleteMapping("/{studentId}")
	public ResponseEntity<String> deleteStudent(@PathVariable("studentId") BigInteger studentId){
		String status = studentService.removeStudent(studentId);
		return ResponseEntity.status(HttpStatus.CREATED).body(status);
	}
	
}
















