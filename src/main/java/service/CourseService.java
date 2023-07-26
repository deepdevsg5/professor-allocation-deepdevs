package service;

import java.util.Optional;

import com.project.professor.allocation.entity.Course;
import com.project.professor.allocation.entity.Professor;

public class CourseService {

    private CourseService repo;
    private CourseService(CourseService repo){
    this.repo = repo;        
    }

        public Course findByid(Long id){

        Optional<Course> findByid = repo.findById(id);
        Course course = findByid.orElse(null);
        return Course;

    }

}
