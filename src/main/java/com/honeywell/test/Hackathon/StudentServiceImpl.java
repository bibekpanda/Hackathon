package com.honeywell.test.Hackathon;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.honeywell.test.Hackathon.domains.Student;
import com.honeywell.test.Hackathon.repos.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	private StudentRepository studentrepo;
	

	public StudentServiceImpl(StudentRepository studentrepo) {
		this.studentrepo = studentrepo;
	}

	@Override
	public Optional<Student> findById(Integer id) {
		// TODO Auto-generated method stub
		return studentrepo.findById(id);
	}

	@Override
	public Student save(Student student) {
		// TODO Auto-generated method stub
		return studentrepo.save(student);
	}

	@Override
	public Iterable<Student> findAll() {
		// TODO Auto-generated method stub
		return studentrepo.findAll();
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		studentrepo.deleteById(id);
	}

	public void deleteAll() {
		// TODO Auto-generated method stub
		studentrepo.deleteAll();
		
	}

}
