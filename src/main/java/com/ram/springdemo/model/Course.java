package com.ram.springdemo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="course")
public class Course {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String courseName;
	
	private String duration;
	
	public Course() {
		
	}
	
	public Course(Integer id, String courseName,String duration) {
		this.id=id;
		this.courseName=courseName;
		this.duration=duration;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id=id;
	}
	
	public String getcourseName() {
		return courseName;
	}
	
	public void setcourseName(String courseName ) {
		this.courseName=courseName;
	}
	
	public String getDuration() {
		return duration;
	}
	
	public void setDuration(String duration) {
		this.duration=duration;
	}
	
	@JsonIgnore
	@ManyToMany(mappedBy="courses")
	private List<Student>students;
	
	public List<Student> getStudents(){
		return students;
	}
	
	public void stStudents(List<Student> students) {
		this.students=students;
	}
	
}
