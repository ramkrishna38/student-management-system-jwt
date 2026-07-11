package com.ram.springdemo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "Name is required")
	private String name;
	
	
	@Min(value=18,message="Age Should be greater than or equal to 18")
	private int age;
	
	@NotBlank(message="City is required")
	private String city;
	
	public Student() {
		
	}
	
	public Student(Integer id,String name, int age,String city, Address address,List<Course> courses,Department department ) {
		this.id=id;
		this.name=name;
		this.age=age;
		this.city=city;
		this.address=address;
		this.courses=courses;
		this.department=department;		
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id=id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age=age;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city=city;
	}
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="address_id")
	private Address address;

	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address=address;
	}
	
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name="student_id")
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="student_course",
				joinColumns=@JoinColumn(name="student_id"),
				inverseJoinColumns=@JoinColumn(name="course_id"))
	private List<Course> courses;
	
	public List<Course> getCourses() {
		return courses;
	}
	
	public void setCourses(List<Course> courses) {
		this.courses=courses;
	}
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="department_id")
	private Department department;
	
	public Department getDepartment() {
		return department;
		
	}
	
	public void setDepartment(Department department) {
		this.department=department;
	}
}
