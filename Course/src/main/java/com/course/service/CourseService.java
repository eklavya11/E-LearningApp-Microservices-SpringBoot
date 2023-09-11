package com.course.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.entity.CourseEntity;
import com.course.entity.Student;
import com.course.exceptions.CourseNotFoundException;
import com.course.repository.CourseRepository;
import com.course.repository.StudentRepository;



@Service

public class CourseService {

	@Autowired

	private CourseRepository courseRepository;
	
    @Autowired
	
	private StudentRepository studentRepository;
	
	public CourseEntity insert(CourseEntity courseEntity) {

		return courseRepository.save(courseEntity);

	}
	
	public CourseEntity addCourseToStudentById(int id, CourseEntity course) throws CourseNotFoundException {
		Optional<Student> optStudent = this.studentRepository.findById(id);
		if (optStudent.isEmpty()) {
			throw new CourseNotFoundException("No student found for the id:" + id);
		}
		Student foundStudent = optStudent.get();
//		CourseEntity newCourse = this.courseRepository.save(course);
		List<CourseEntity> courseList =foundStudent.getCourses();
		courseList.add(course);
		foundStudent.setCourses(courseList);
		this.studentRepository.save(foundStudent);
		return course;
	}
	
	public CourseEntity deleteCourseFromStudentById(int id, CourseEntity course) throws CourseNotFoundException {
		Optional<Student> optStudent = this.studentRepository.findById(id);
		if (optStudent.isEmpty()) {
			throw new CourseNotFoundException("No student found for the id:" + id);
		}
		Student foundStudent = optStudent.get();
//		CourseEntity newCourse = this.courseRepository.save(course);
		List<CourseEntity> courseList =foundStudent.getCourses();
		courseList.remove(course);
		foundStudent.setCourses(courseList);
		this.studentRepository.save(foundStudent);
		return course;
	}
	
	public List<CourseEntity> getCoursesByStudent(int id)throws CourseNotFoundException{
		Optional<Student> optStudent = this.studentRepository.findById(id);
		if (optStudent.isEmpty()) {
			throw new CourseNotFoundException("No student found for the id:" + id);
		}
		Student foundStudent = optStudent.get();
		List<CourseEntity> courseList =foundStudent.getCourses();
		if(courseList==null) {
			throw new CourseNotFoundException("No courses found for the id:" + id);
		}
		return courseList;
	}

//	public void insert(CourseEntity courseEntity) {
//
//		courseRepository.save(courseEntity);
//
//	}

	public List<CourseEntity> findAllCourses() throws CourseNotFoundException {

		return courseRepository.findAll();

	}

	public Optional<Object> deletecourseById(int courseId) throws CourseNotFoundException {

// Check if the course with the given ID exists in the database

		if (!courseRepository.existsById(courseId)) {

			throw new CourseNotFoundException("Course not found with ID: " + courseId);

		}

		courseRepository.deleteById(courseId);

		return null;

	}

	public Optional<CourseEntity> getCourseById(int id) throws CourseNotFoundException {

		Optional<CourseEntity> optional = courseRepository.findById(id);

		return optional;

	}
	
	public CourseEntity updateCourse(CourseEntity course, int id) throws CourseNotFoundException {

		try {
			CourseEntity result = courseRepository.findById(id).get();
			if (result != null) {
				return courseRepository.save(course);
			}
		} catch (NoSuchElementException e) {
			throw new CourseNotFoundException("Course with this id: " + id + "not found!!!");
		}
		return null;



	}




//	public void postCourseEntity(CourseEntity courseDB) throws CourseNotFoundException {
//
//		courseRepository.save(courseDB);
//
//	}
//
	public Optional<CourseEntity> getCourseById1(int cid) {

		Optional<CourseEntity> optional = courseRepository.findById(cid);

		return optional;

	}

}
