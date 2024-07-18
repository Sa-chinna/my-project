package com.lms.student_app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.lms.student_app.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
}
