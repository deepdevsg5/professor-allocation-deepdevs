package com.project.professor.allocation.repository;

import java.util.List;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Repository;

import com.project.professor.allocation.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long>{

	
	 List<Course> findByNameContaining(String name);
}


