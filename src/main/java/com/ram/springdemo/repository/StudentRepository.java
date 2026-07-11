package com.ram.springdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ram.springdemo.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	List<Student>findByName(String name);
	List<Student>findByCity(String city);
	List<Student>findByAgeGreaterThan(int age);
	List<Student>findByAgeLessThan(int age);
	List<Student>findByNameAndCity(String name, String city);
	List<Student>findByAgeBetween(int startAge,int endAge);
	List<Student>findByNameContaining(String name);
	List<Student>findByNameStartingWith(String prefix);
	List<Student>findByAgeOrderByNameAsc(int age);
	List<Student>findTop3ByOrderByAgeDesc();
	
	@Query("Select s from Student s")
	List<Student>getAllStudentData();
	
	@Query("Select s from Student s where s.name=:name")
	List<Student>getStudentByNameUsingQuery(@Param("name")String name);
	@Query("Select s from Student s where s.name=:name And s.city=:city")
		List<Student>getStudentByNameAndCityUsingQuery(@Param("name")String name ,@Param("city")String city);
	@Query("Select s from Student s where s.name Like %:name%")
	List<Student>searchStudentByName(@Param("name")String name);
	
	@Query(value="Select * from student",nativeQuery=true)
	List<Student>getAllStudentsNative();
	
	@Query(value="Select * from student where city=:city", nativeQuery=true)
	List<Student> getStudentByCityNative(@Param("city")String city);
	
	@Modifying
	@Transactional
	@Query("Update Student s set s.city=:city where s.id=:id")
	int updateStudentCity(@Param("id")Integer id,@Param("city")String city);
	
	@Modifying
	@Transactional
	@Query("Delete from Student s where s.id=:id")
	int deleteStudentID(@Param("id")Integer id);
	
	
}
