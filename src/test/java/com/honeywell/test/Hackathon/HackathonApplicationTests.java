package com.honeywell.test.Hackathon;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.honeywell.test.Hackathon.domains.Student;


@SpringBootTest
class HackathonApplicationTests {

	@Test
	void contextLoads() {
	}
	

    @Autowired
    StudentServiceImpl studentRepository;
   

    /**
     * Exercise CrudRepository methods.
     */
    @Test
    public void simpleStudentCrudExample() {
        studentRepository.save(new Student(2, 18, "Sachin"));
        studentRepository.save(new Student(3, 19, "Rahul"));
        studentRepository.save(new Student(4, 20, "Mahi"));
        

        studentRepository.findAll().forEach(System.out::println);

        //age up the students
        studentRepository.findAll().forEach(student -> {
            student.setAge(student.getAge() + 1);
            studentRepository.save(student);
        });

        studentRepository.deleteAll();
        studentRepository.findAll().forEach(System.out::println);

        studentRepository.findAll().forEach(System.out::println);
    }

}
