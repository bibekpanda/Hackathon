package com.honeywell.test.Hackathon.domains;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "STUDENT")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;

    @Column
    private Integer age;

    @Column
    private String name;
    
    
    public Student() {
    }

    public Student(Integer studentId, Integer age, String name) {
        this.studentId = studentId;
        this.age = age;
        this.name = name;
    }

   
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

    public Integer getStudentId() {
        return studentId;
    }

 
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	 public void setAge(Integer age) {
	        this.age = age;
	    }

	public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student{" + "studentId=" + studentId + ", " + ", name"  + name+
                ", age=" + age + "}\n";
    }

}
