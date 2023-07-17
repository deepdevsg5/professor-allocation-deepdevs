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

import com.project.professor.allocation.entity.Department;
import com.project.professor.allocation.entity.Professor;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
public class ProfessorRepositoryTest {

	@Autowired
	ProfessorRepository professorRepository;

	@Test
	public void create() {

		Department dpt = new Department();
		dpt.setId(1l);
		dpt.setName("TesteProfessor");

		Professor professor = new Professor();
		professor.setId(null);
		professor.setName("Marcos");
		professor.setCpf("11111111113");
		professor.setDepartment(dpt);
		professor = professorRepository.save(professor);
		System.out.println(professor);
	}

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
	public void findByNameContaining() {
		String name = "Marcos";
		List<Professor> nameProfessor = professorRepository.findByNameContaining(name);
		System.out.println(nameProfessor);
	}

	@Test
	public void findByCpfEquals() {
		String cpfNumber = "11111111113";
		List<Professor> findCpf = professorRepository.findByCpfEquals(cpfNumber);
		System.out.println(findCpf);
	}

	@Test
	public void findByDepartmentId() {
		Long id = 1l;
		List<Professor> dptId = professorRepository.findByDepartmentId(id);
		System.out.println(dptId);
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