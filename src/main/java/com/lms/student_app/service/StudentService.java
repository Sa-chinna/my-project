package com.lms.student_app.service;

import java.util.List;

import com.lms.student_app.entity.Student;

public interface StudentService {
	
    List<Student> getAllStudents();

    Student getStudentById(Long id);

    void addStudent(Student student);

    void updateStudent(Long id, Student updatedStudent);

    void deleteStudent(Long id);
    
}
