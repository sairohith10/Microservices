package com.springex.microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springex.microservice.entity.Student;
import com.springex.microservice.entity.StudentResponse;
import com.springex.microservice.model.StudentDetails;
import com.springex.microservice.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@PostMapping("/savedetails")
	public Student saveStudentDetails(@RequestBody StudentDetails studentDetails) {
		
		return studentService.saveStudent(studentDetails);
	}
	
	
  @GetMapping("/getdetails")
  public List<Student> getStudentsDetails() {
	  
	  return studentService.allStudentDetails();
  }


// @GetMapping("/id/{id}")
// public StudentResponse getStudentDetailsById(@PathVariable long id) {
//	 return studentService.oneStudentDetail(id);
//	
// }
  
//  @GetMapping("/id/{id}")
//  public StudentResponse fullDetails(@PathVariable long id) {
//	  return studentService.getStudentwithAddress(id);
//  }
  
  
  
  @GetMapping("/id/{id}")
  public StudentResponse fullDetails(@PathVariable long id) {
	  return studentService.getStudentDetailsWithAddress(id);
  }
  
  
  
  
  
}
