package com.project.professor.allocation.repository;

import java.sql.Time;
import java.time.DayOfWeek;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import com.project.professor.allocation.entity.Allocation;
import com.project.professor.allocation.entity.Course;
import com.project.professor.allocation.entity.Professor;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
public class AllocationRepositoryTest {

	@Autowired
	AllocationRepository allocationRepository;

	@Test
	public void create() {
		Professor professor = new Professor();
		professor.setCpf("0123456");
		professor.setId(1l);
		professor.setNome("Carlos");

		Course course = new Course();
		course.setId(1l);
		course.setName("Ingles patrocinado");

		Allocation alloc1 = new Allocation();
		alloc1.setId(1l);
		alloc1.setDayOfWeek(DayOfWeek.FRIDAY);
		alloc1.setHourStart(Time.valueOf("14:00:00"));
		alloc1.setHourEndTime(Time.valueOf("16:00:00"));
		alloc1.setProfessor(professor);
		alloc1.setCourse(course);

		Allocation alloc2 = allocationRepository.save(alloc1);
		System.out.println(alloc2);
	}

	@Test
	public void update() {
		Professor professor = new Professor();
		professor.setCpf("0123456");
		professor.setId(1l);
		professor.setNome("Carlos");

		Course course = new Course();
		course.setId(1l);
		course.setName("Ingles patrocinado");

		Allocation alloc1 = new Allocation();
		alloc1.setId(1l);
		alloc1.setDayOfWeek(DayOfWeek.FRIDAY);
		alloc1.setHourStart(Time.valueOf("20:00:00"));
		alloc1.setHourEndTime(Time.valueOf("22:00:00"));
		alloc1.setProfessor(professor);
		alloc1.setCourse(course);

		Allocation alloc2 = allocationRepository.save(alloc1);
		System.out.println(alloc2);
	}

	@Test
	void findAll() {
		List<Allocation> testeFindAll = allocationRepository.findAll();

		System.out.println(testeFindAll);
	}

	@Test
	void findById() {
		Long id = 2l;
		Optional<Allocation> testeFindByIDAllocation = allocationRepository.findById(id);
		Allocation alloc = testeFindByIDAllocation.orElse(null);
		System.out.println(alloc);

	}

	@Test
	void deleteById() {
		long id = 1l;
		allocationRepository.deleteById(id);
	}

	@Test
	void deleteAll() {
		allocationRepository.deleteAllInBatch();
	}

}
