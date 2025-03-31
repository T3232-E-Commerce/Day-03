package lk.ac.vau.fas.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.ac.vau.fas.model.Student;

@RestController
@RequestMapping("/app")
public class AppController {
	//Create student objects
	Student s1 = new Student("2020ICT91","Dilmy",24,"ICT",3.40);
	Student s2 = new Student("2020ICT01","Zhang Fang",22,"ICT",3.40);
	Student s3 = new Student("2020ICT02","Jiang Yiming",23,"ICT",3.40);
	Student s4 = new Student("2020ICT03","Jackson Wang",21,"ICT",3.40);
	
	List<Student> students = new ArrayList<Student>();
	
	@GetMapping("/msg")
	public String myMessage() {
		return "Hello Springboot";
	}
	
	@GetMapping("/name")
	public String name() {
		return "My name is Springboot"; 
	}
	
	@GetMapping("/age/{ag}")
	public String MyAge(@PathVariable("ag")int age) {
		return "My age is "+age;
	}
	
	//A Method to return a student 
	@GetMapping("/student")
	public Student getStudent() {
		return s1;
	}
	
	//return multiple students
	@GetMapping("/students")
	public List<Student> getStudents(){
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		return students;
	}
	
	//find a student from the list by regno
	@GetMapping("/student/{id}")
	public Student StudentDetails(@PathVariable("id") String regno) {
		for(Student student :students) {
			if(student.getRegno().equals(regno)) {
				return student;
			}
		}
		return null;
	}

	//find the students whose age is between 20 and 23
	@GetMapping("/students/age-between")
	public List<Student> getStudentsByAgeRang(){
		return students.stream()
				.filter(student -> student.getAge() >= 20 && student.getAge()<=23)
				.collect(Collectors.toList());
	}
	
	//CRUD Operations for students
	
	//Create - Add a new student
	@PostMapping("/students")
	public Student addStudent(@RequestBody Student student) {
		students.add(student);
		return student;
	}
	
	//Update
	
	 @PutMapping("/students/{id}")
	    public Student updateStudent(@PathVariable("id") String regno, @RequestBody Student updatedStudent) {
	        for (int i = 0; i < students.size(); i++) {
	            Student student = students.get(i);
	            if (student.getRegno().equals(regno)) {
	 
	                student.setName(updatedStudent.getName());
	                student.setAge(updatedStudent.getAge());
	                student.setCourse(updatedStudent.getCourse());
	                student.setGpa(updatedStudent.getGpa());
	                return student;
	            }
	        }
	        return null; 
	    }
	
	//Delete
	 
	 @DeleteMapping("/students/{id}")
	    public boolean deleteStudent(@PathVariable("id") String regno) {
	        return students.removeIf(student -> student.getRegno().equals(regno));
	    }
	
	
}
