package com.docker.crud.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.docker.crud.model.Student;

public interface StudentRepository extends JpaRepository<Student, BigInteger>{
	
}
