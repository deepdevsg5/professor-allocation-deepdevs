package com.project.professor.allocation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.professor.allocation.entity.Department;
import com.project.professor.allocation.entity.Professor;
import com.project.professor.allocation.repository.ProfessorRepository;

@Service
public class ProfessorService {
	private ProfessorRepository repo;
	private DepartmentService departmentService;

	public ProfessorService(ProfessorRepository repo, DepartmentService departmentService) {
		this.repo = repo;
		this.departmentService = departmentService;

	}

	public Professor create(Professor professor) {

		professor.setId(null);

		return saveInternal(professor);
	}

	public Professor update(Professor professor) {
		Long professorId = professor.getId();
		if (repo.existsById(professorId)) {

			return saveInternal(professor);
		} else {
			return null;
		}
	}

	public Professor findById(Long id) {

		Optional<Professor> findById = repo.findById(id);
		Professor professor = findById.orElse(null);
		return professor;
	}

	public List<Professor> findAll() {
		List<Professor> professorList = repo.findAll();
		return professorList;
	}

	public void deleteById(Long id) {
		if (repo.existsById(id)) {

			repo.deleteById(id);
		}
	}
	
	public void deleteAll() {
		repo.deleteAllInBatch();
		
	}
	
	private Professor saveInternal(Professor professor) {
		if (professor.getCpf().isBlank() || professor.getCpf().isEmpty()) {
			throw new RuntimeException("Cpf não pode esta em branco");
		}else {
			Professor savedProfessor = repo.save(professor);
			
			Long departamentId = savedProfessor.getDepartment().getId();
			Department department = departmentService.findById(departamentId);
			savedProfessor.setDepartment(department);
			
			return savedProfessor;
		}
	}

}
