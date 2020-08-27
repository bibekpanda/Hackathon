package com.honeywell.test.Hackathon.repos;

import org.springframework.data.repository.CrudRepository;

import com.honeywell.test.Hackathon.domains.Student;


public interface StudentRepository extends CrudRepository<Student, Integer>{

}
