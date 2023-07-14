package com.project.professor.allocation.repository;

import com.project.professor.allocation.entity.Course;
import com.project.professor.allocation.entity.Department;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
public class CourseRepositoryTest {

	@Autowired
	CourseRepository courseRepository;

	@Test
	void create() {
		Course cur1 = new Course();
		cur1.setName("Logica");
		cur1.setId(null);

		Course cur2 = courseRepository.save(cur1);
		System.out.println(cur2);

	}

	@Test
	void findAll() {

		List<Course> courses = courseRepository.findAll();
		System.out.println(courses);

	}

	@Test
	void findByid() {
		Long id = 2l;
		Optional<Course> courses = courseRepository.findById(id);
		Course cur = courses.orElse(null);
		System.out.println(cur);
	}

	@Test
	void update() {
		Long id = 2l;
		Course cur1 = new Course();
		cur1.setName("Backend");
		cur1.setId(id);

		Course cur2 = courseRepository.save(cur1);
		System.out.println(cur2);

	}

	@Test
	void deleteById() {
		long id = 4l;
		courseRepository.deleteById(id);
	}

	@Test
	void deleteAll() {
		courseRepository.deleteAllInBatch();
	}
}
