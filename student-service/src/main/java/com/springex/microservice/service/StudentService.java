package com.springex.microservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springex.microservice.entity.Student;
import com.springex.microservice.model.StudentDetails;
import com.springex.microservice.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;

	public  Student saveStudent(StudentDetails studentDetails) {
		
		Student student = new Student();
		
		student.setFirstName(studentDetails.getFirstName());
		student.setLastName(studentDetails.getLastName());
		student.setEmailId(studentDetails.getEmailId());
		
		return studentRepository.save(student);
	}

	public List<Student> allStudentDetails() {
		return studentRepository.findAll();
	}

	public Optional<Student> oneStudentDetail(long id) {
		
		return studentRepository.findById(id);
			}

}
