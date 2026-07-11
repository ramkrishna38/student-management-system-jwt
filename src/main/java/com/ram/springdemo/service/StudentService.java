package com.ram.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ram.springdemo.exception.ResourceNotFoundException;
import com.ram.springdemo.model.Student;
import com.ram.springdemo.repository.StudentRepository;

@Service
public class StudentService {
	

@Autowired
StudentRepository repository;

public Student saveStudent(Student student) {
		
		return repository.save(student);
	}

public List<Student> getAllStudents(){
	return repository.findAll();
}

public Student getStudentById(Integer id)  {
	
	
	return repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Student not found"));
}

public List<Student> getStudentByName(String name) {
	return repository.findByName(name);
}

public List<Student> getStudentByCity(String city){
	return repository.findByCity(city);
}

public List<Student>getStudentByAgeGreaterThan(int age){
	return repository.findByAgeGreaterThan(age);
}

public List<Student>getStudentByAgeLessThan(int age){
	return repository.findByAgeLessThan(age);
}

public List<Student>getStudentByNameAndCity(String name,String city){
	return repository.findByNameAndCity(name, city);
}


public Student updateStudent(Integer id, Student student) {
	Student oldStudent = repository.findById(id).orElse(null);
	
	if(oldStudent!=null) {
		oldStudent.setName(student.getName());
		oldStudent.setAge(student.getAge());
		oldStudent.setCity(student.getCity());
		
		return repository.save(oldStudent);
	}
	return null;
}

public String deleteStudent(Integer id) {
	
	repository.deleteById(id);
	return "Student Deleted Successfully";
}


public List<Student>getStudentByAgeBetween(int startAge,int endAge){
	return repository.findByAgeBetween(startAge,endAge);
}

public List<Student>getStudentByNameContaining(String name){
	return repository.findByNameContaining(name);
}

public List<Student>getStudentByNameStartingWith(String prefix){
	return repository.findByNameStartingWith(prefix);
}

public List<Student>getStudentByAgeOrderByNameAsc(int age){
	return repository.findByAgeOrderByNameAsc(age);
}

public List<Student>getStudentByTop3ByOrderByAgeDesc(){
	return repository.findTop3ByOrderByAgeDesc();
}

public List<Student>getAllStudentData(){
	return repository.getAllStudentData();
}

public List<Student>getStudentByNameUsingQuery(String name){
	return repository.getStudentByNameUsingQuery(name);
}

public List<Student>getStudentByNameAndCityUsingQuery(String name, String city){
	return repository.getStudentByNameAndCityUsingQuery(name, city);
}

public List<Student>searchStudentByName(String name){
	return repository.searchStudentByName(name);
}

public List<Student>getAllStudentsNative(){
	return repository.getAllStudentsNative();
}

public List<Student>getStudentByCityNative(String city){
	return repository.getStudentByCityNative(city);
}

public Page<Student>getStudents(Pageable pageable){
	return repository.findAll(pageable);
}

public String updateStudentCity(Integer id, String city) {
	int result = repository.updateStudentCity(id,city);
	if(result>0)
		return "City Updated";
	
	return "Students Not Found";
}

public String deleteStudentId(Integer id) {
	int result = repository.deleteStudentID(id);
	if(result>0)
		return "Student Deleted";
	
	return "Student Not Found";
}

}
