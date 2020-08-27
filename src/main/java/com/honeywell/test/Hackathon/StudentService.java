package com.honeywell.test.Hackathon;

import java.util.Optional;

import com.honeywell.test.Hackathon.domains.Student;

public interface StudentService {
	  Optional<Student> findById(Integer id);
	  void deleteById(Integer id);
		 
	    Student save(Student student);
	    
	    Iterable<Student> findAll();

	

}
