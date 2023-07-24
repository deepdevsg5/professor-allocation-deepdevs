package com.project.professor.allocation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.professor.allocation.entity.Course;
import com.project.professor.allocation.repository.CourseRepository;

@Service
public class CourseService {
	private CourseRepository repo;

	public CourseService(CourseRepository repo) {

		this.repo = repo;
	}

	public Course findById(Long id) {
		Optional<Course> findIdCourse = repo.findById(id);
		Course course = findIdCourse.orElse(null);
		return course;
	}

	public List<Course> findByName(String name) {
		return repo.findByNameContaining(name);
	}

	public List<Course> findAll() {
		List<Course> courses = repo.findAll();
		return courses;
	}

	public Course create(Course course) {
		course.setId(null);
		return saveInternal(course);
	}

	public Course update(Course course) {
		Long courseId = course.getId();

		if (repo.existsById(courseId)) {
			return saveInternal(course);
		} else {
			return null;
		}
	}

	public void deleteById(Long id) {
		repo.deleteById(id);
	}

	public void deleteAll() {
		repo.deleteAllInBatch();

	}

	private Course saveInternal(Course course) {
		Course savedCourse = repo.save(course);
		return savedCourse;
	}
}
