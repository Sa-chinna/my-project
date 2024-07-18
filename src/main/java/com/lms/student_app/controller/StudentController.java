package com.lms.student_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.student_app.entity.Student;
import com.lms.student_app.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	private final StudentService studentService;

	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	// http://localhost:8080/students
	@GetMapping
	public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

	 @GetMapping("/{id}")
	    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
	        Student student = studentService.getStudentById(id);
	        if (student == null) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	        }
	        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(student);
	    }

	@PostMapping
	public void addStudent(@RequestBody Student student) {
		studentService.addStudent(student);
	}

	@PutMapping("/{id}")
	public void updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
		studentService.updateStudent(id, updatedStudent);
	}

	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable Long id) {
		studentService.deleteStudent(id);
	}
}
