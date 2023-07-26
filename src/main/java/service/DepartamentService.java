package service;

import java.util.Optional;

import com.project.professor.allocation.entity.Course;
import com.project.professor.allocation.entity.Department;

public class DepartamentService {
 
    private DepartamentService repo;
    private DepartamentService(DepartamentService repo){
    this.repo = repo;        
    }

    public Department findByid(Long id){

        Optional <Department> findByid = repo.findById(id);
        Department  department = findByid.orElse(null);
        return Department;

}
