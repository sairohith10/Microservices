package com.springex.microservice.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.springex.microservice.entity.AddressResponse;
import com.springex.microservice.entity.Student;
import com.springex.microservice.entity.StudentResponse;
import com.springex.microservice.model.StudentDetails;
import com.springex.microservice.openfiegn.AddressFeignClient;
import com.springex.microservice.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired 
	AddressFeignClient addressFeignClient;
	
//	@Autowired
//	WebClient webClient;
	
//	@Autowired
//	RestTemplate restTemplate;
	
//	@Value("${address.service.url}")
//	String baseURL;
	


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
//
//	public StudentResponse oneStudentDetail(long id) {
//		Student student = studentRepository.findById(id).get();
//		
//		AddressResponse addressResponse = restTemplate.getForObject(baseURL+id,AddressResponse.class );
//		StudentResponse studentResponse = new StudentResponse();
//		
//		studentResponse.setId(student.getId());
//		studentResponse.setFirstName(student.getFirstName());
//		studentResponse.setLastName(student.getLastName());
//		studentResponse.setEmail(student.getEmailId());
//		studentResponse.setAddressResponse(addressResponse);
//		
//		return studentResponse;
//	}

	public StudentResponse getStudentDetailsWithAddress(long id) {
		Student student = studentRepository.findById(id).get();
		
	    StudentResponse studentResponse = new StudentResponse();
	    
	    
	    studentResponse.setId(student.getId());
    	studentResponse.setFirstName(student.getFirstName());
 		studentResponse.setLastName(student.getLastName());
		studentResponse.setEmail(student.getEmailId());
	    studentResponse.setAddressResponse(addressFeignClient.getAddressById(id));
	    
	    return studentResponse;
	}



//	public StudentResponse getStudentwithAddress(long id) {
//		
//		Student student = studentRepository.findById(id).get();		
//		AddressResponse addressResponse = webClient.get()
//                .uri("address/id/" +id)
//                .retrieve()
//                .bodyToMono(AddressResponse.class)
//                .block();
//		
//		StudentResponse studentResponse = new StudentResponse();
//		studentResponse.setId(student.getId());
//		studentResponse.setFirstName(student.getFirstName());
//		studentResponse.setLastName(student.getLastName());
//		studentResponse.setEmail(student.getEmailId());
//		studentResponse.setAddressResponse(addressResponse);
//		return studentResponse;
//	}

	
	
	
			          
}
