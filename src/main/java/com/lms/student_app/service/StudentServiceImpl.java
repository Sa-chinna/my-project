// StudentServiceImpl.java (Service implementation)

package com.lms.student_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.student_app.entity.Student;
import com.lms.student_app.repo.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	private final StudentRepository studentRepository;

	@Autowired
	public StudentServiceImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student getStudentById(Long id) {
		Optional<Student> optionalStudent = studentRepository.findById(id);
		return optionalStudent.orElse(null);
	}

	@Override
	public void addStudent(Student student) {
		studentRepository.save(student);
	}

	@Override
	public void updateStudent(Long id, Student updatedStudent) {
		Optional<Student> optionalStudent = studentRepository.findById(id);
		if (optionalStudent.isPresent()) {
			Student existingStudent = optionalStudent.get();
			existingStudent.setName(updatedStudent.getName());
			existingStudent.setAge(updatedStudent.getAge());
			studentRepository.save(existingStudent);
		}
	}

	@Override
	public void deleteStudent(Long id) {
		studentRepository.deleteById(id);
	}
}
