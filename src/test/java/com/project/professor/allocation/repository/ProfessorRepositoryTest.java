package com.project.professor.allocation.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import com.project.professor.allocation.entity.Professor;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
public class ProfessorRepositoryTest {

	@Autowired
	ProfessorRepository professorRepository;

	@Test
	public void findAll() {
		List<Professor> professors = professorRepository.findAll();
		System.out.println(professors);
	}

	@Test
	public void findById() {
		Long id = 1L;
		Optional<Professor> profs = professorRepository.findById(id);
		Professor prof = profs.orElse(null);
		System.out.println(prof);
	}

	@Test
	public void create() {

		Professor professor = new Professor();
		professor.setId(null);
		professor.setName("Professor Antônio");
		professor.setCpf("111.111.111-11");
		professor.setDepartment(null);
		professor = professorRepository.save(professor);
		System.out.println(professor);
	}

	@Test
	public void update() {
		Professor professor = new Professor();
		professor.setId(1L);
		professor.setName("Professor Henrique");
		professor.setCpf("999.999.999-99");
		professor.setDepartment(null);
		professor = professorRepository.save(professor);
		System.out.println(professor);
	}

	@Test
	public void deleteById() {
		Long id = 1L;
		professorRepository.deleteById(id);
	}

	@Test
	public void deleteAll() {
		professorRepository.deleteAllInBatch();
	}
}