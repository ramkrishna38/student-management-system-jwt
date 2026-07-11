package com.ram.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ram.springdemo.model.Student;
import com.ram.springdemo.service.StudentService;

import jakarta.validation.Valid;

@RestController
public class StudentController {
	
	@Autowired
	StudentService service;
	
	@PostMapping("/save")
	public Student saveStudent(@Valid@RequestBody Student student) {
		return service.saveStudent(student);
	}
	
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		return service.getAllStudents();
	}
	
	@GetMapping("/students/{id}")
	public Student getStudentById(@PathVariable Integer id) {
		return service.getStudentById(id);
	}
	
	@PutMapping("/students/{id}")
	public Student updateStudent(@PathVariable Integer id,
								@Valid @RequestBody Student student) {
		
		return service.updateStudent(id, student);
	}
	
	@DeleteMapping("/students/{id}")
	public String deleteStudent(@PathVariable Integer id) {
		
		return service.deleteStudent(id);
	}
	
	@GetMapping("/students/name/{name}")
	public List<Student> getStudentByName(@PathVariable String name) {
		return service.getStudentByName(name);
	}
	
	@GetMapping("/students/city/{city}")
	public List<Student> getStudentByCity(@PathVariable String city){
		return service.getStudentByCity(city);
	}
	
	@GetMapping("/students/agegreater/{age}")
	public List<Student>getStudentByAgeGreaterThan(@PathVariable int age){
		return service.getStudentByAgeGreaterThan(age);
	}
	
	@GetMapping("/students/ageless/{age}")
	public List<Student>getStudentByAgeLessThan(@PathVariable int age){
		return service.getStudentByAgeLessThan(age);
	}
	
	@GetMapping("/students/{name}/{city}")
	public List<Student>getStudentByNameAndCity(@PathVariable String name , @PathVariable String city){
		return service.getStudentByNameAndCity(name,city);
	}
	
	@GetMapping("/students/agebetween/{startAge}/{endAge}")
	public List<Student>getStudentByAgeBetween(@PathVariable int startAge, @PathVariable int endAge){
		return service.getStudentByAgeBetween(startAge, endAge);
	}
	
	@GetMapping("/students/namecontains/{name}")
	public List<Student>getStudentByNameContaining(@PathVariable String name){
		return service.getStudentByNameContaining(name);
	}
	
	@GetMapping("/students/namestarts/{prefix}")
	public List<Student>getStudentByNameStartingWith(@PathVariable String prefix){
		return service.getStudentByNameStartingWith(prefix);
	}
	
	@GetMapping("/students/ageorderby/{age}")
	public List<Student>getStudentByAgeOrderByNameAsc(@PathVariable int age){
		return service.getStudentByAgeOrderByNameAsc(age);
	}
	
	@GetMapping("/students/top3age")
	public List<Student>getStudentByTop3ByOrderByAgeDesc(){
		return service.getStudentByTop3ByOrderByAgeDesc();
	}
	
	@GetMapping("/students/query/all")
	public List<Student>getAllStudentData(){
		return service.getAllStudentData();
	}
	
	@GetMapping("/students/query/name/{name}")
	public List<Student>getStudentByNameUsingQuery(@PathVariable String name){
		return service.getStudentByNameUsingQuery(name);
	}
	
	@GetMapping("/students/query/{name}/{city}")
	public List<Student>getStudentByNameAndCityUsingQuery(@PathVariable String name, @PathVariable String city){
		return service.getStudentByNameAndCityUsingQuery(name, city);
	}
	
	@GetMapping("/students/query/search/{name}")
	public List<Student>searchStudentByName(@PathVariable String name){
		return service.searchStudentByName(name);
	}
	
	@GetMapping("/students/native/all")
	public List<Student>getAllStudentsNative(){
		return service.getAllStudentsNative();
	}
	
	@GetMapping("/students/native/city/{city}")
	public List<Student> getStudentByCityNative(@PathVariable String city){
		return service.getStudentByCityNative(city);
	}
	
	@GetMapping("/students/page")
	public Page<Student>getStudents(Pageable pageable){
		return service.getStudents(pageable);
	}
	
	@PutMapping("/students/updatecity/{id}/{city}")
	public String updatStudentCity(@PathVariable Integer id, @PathVariable String city) {
		return service.updateStudentCity(id, city);
	}
	
	
	@DeleteMapping("/students/deletestudentid/{id}")
	public String deleteStudentId(@PathVariable Integer id) {
		return service.deleteStudentId(id);
	}
	
}
	
//	@GetMapping("/student")
//	public String student() {
//		
//		return "Student API working";
//	}
//	
//	@GetMapping("/hello")
//	public String hello() {
//		return "Hello Ram";
//	}
//	
//	@PostMapping("/save")
//	public Student saveStudent(@RequestBody Student student) {
//		return student;
//	}
//	
//	public String saveStudent(@RequestParam String name,
//			@RequestParam int age,
//			@RequestParam String city) {
//		return "Welcome " +name +" of Age "+age +" from City "+city ;
//	}
//}
