package service;

import com.project.professor.allocation.entity.Allocation;
import com.project.professor.allocation.entity.Course;
import com.project.professor.allocation.entity.Professor;
import com.project.professor.allocation.repository.AllocationRepository;

public class AllocationService(AllocationRepository repo, ProfeService profService, CourseService,  courseService) {

    private AllocationService repo;
    private AllocationService(AllocationService repo){
    this.repo = repo;
    this.ProfeService = ProfessorService;
    this.CourseService = CourseService;        
    }

public Allocation findByid(Long id){

        Optional<Allocation> findByid = repo.findById(id);
        Allocation allocation = findByid.orElse(null);
        return Allocation;        

public List<Allocation> findAll(){

    List<Allocation> listaDeAllocations = repo.findAll();
    return listaDeAllocations;
    }

public Allocation create(Allocation allo) {

 

        allo.setId(null);

        return saveInternal(allo);

    }

 

    public Allocation udpate(Allocation allo) {

 

        Long alloId = allo.getId();

 

        if (repo.existsById(alloId)) {

            return saveInternal(allo);

        } else {

            return null;

        }

 

    }

 

    private Allocation saveInternal(Allocation allo) {

        if (allo.getHourStart().compareTo(allo.getHourEndTime())>0)
        {
         
            throw new RuntimeException();

        } else {

            Allocation alloc1 = repo.save(allo);

            Long profId = alloc1.getFessor().getId();

            Professor professor = profService.findById(profId);

            alloc1.setProfessor(professor);

 

        Long courseId = alloc1.getCurso().getId();

        Course course = courseService.findById(courseId);

        alloc1.setCurso(course);

 

        return alloc1;

        }

        

        

        

       

    }


    
}