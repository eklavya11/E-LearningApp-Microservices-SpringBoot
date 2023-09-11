package com.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.course.entity.Student;



@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	Student findByUsername(String username);

	Student findByEmail(String email);

}
