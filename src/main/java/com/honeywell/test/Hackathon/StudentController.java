package com.honeywell.test.Hackathon;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.honeywell.test.Hackathon.domains.Student;

@RestController
@RequestMapping(value = "/student")
@Component
public class StudentController {
	
	@Autowired
	private StudentService studentservice;
	
	

	public StudentController(StudentService studentservice) {
		
		this.studentservice = studentservice;
	}



	  @CrossOrigin(origins = "http://localhost:8089")    
	    @GetMapping(value = "/{id}")
	    public StudentDTO findOne(@PathVariable Integer id) {
	        Student entity = studentservice.findById(id)
	            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	        return convertToDto(entity);
	    }
	 
	    @GetMapping("all")
	    public Collection<StudentDTO> findAll() {
	        Iterable<Student> students = this.studentservice.findAll();
	        List<StudentDTO> studentDtos = new ArrayList<>();
	        students.forEach(p -> studentDtos.add(convertToDto(p)));
	        return studentDtos;
	    }
	    
	    
		@PostMapping("{id}")
		public ResponseEntity<Object> CreatePost(@PathVariable int id,@RequestBody Student student1) throws Exception {
			Optional<Student> userOptional =  studentservice.findById(id);
		if (!userOptional.isPresent()) {
			throw new Exception("Id -");
		}
		//Student student = userOptional.get();
		studentservice.save(student1);
		
		URI location = ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("{/id}")
		.buildAndExpand(student1.getStudentId())
		.toUri();

		return ResponseEntity.created(location).build();
		}
		
		@PutMapping("{id}/posts")
		public ResponseEntity<Object> CreatePut(@PathVariable int id,@RequestBody Student student1) throws Exception {
			Optional<Student> userOptional =  studentservice.findById(id);
		if (!userOptional.isPresent()) {
			throw new Exception("Id -");
		}
		//Student student = userOptional.get();
		studentservice.save(student1);
		
		URI location = ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("{/id}")
		.buildAndExpand(student1.getStudentId())
		.toUri();

		return ResponseEntity.created(location).build();
		}
		
		@DeleteMapping("{id}")
		public void DeleteUsers(@PathVariable int id) {
			studentservice.deleteById(id);
			
			
		}

		
		
	 
	    protected StudentDTO convertToDto(Student entity) {
	    	StudentDTO dto = new StudentDTO(entity.getStudentId(), entity.getName());
	 
	        return dto;
	}
	
}
