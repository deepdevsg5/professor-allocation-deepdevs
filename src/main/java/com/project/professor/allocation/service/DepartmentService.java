package com.project.professor.allocation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.professor.allocation.entity.Department;
import com.project.professor.allocation.entity.Professor;
import com.project.professor.allocation.repository.DepartmentRepository;
import com.project.professor.allocation.repository.ProfessorRepository;

@Service
public class DepartmentService {

	private DepartmentRepository repo;

	public DepartmentService(DepartmentRepository repo) {
		this.repo = repo;
	}

	public Department create(Department department) {

		department.setId(null);

		return repo.save(department);
	}

	public Department update(Department department) {
		Long id = department.getId();

		if (repo.existsById(id)) {
			return repo.save(department);
		}
		return null;

	}

	public Department findById(Long id) {

		Optional<Department> dptfind = repo.findById(id);
		Department department = dptfind.orElse(null);

		return department;
	}

	public List<Department> findAll(String name) {
		List<Department> listDepartment = repo.findAll();
		return listDepartment;
	}

	public void deleteById(Long id) {
		if (repo.existsById(id)) {
			repo.deleteById(id);
		}
	}

	public void deleteAll() {
		repo.deleteAllInBatch();

	}
}
