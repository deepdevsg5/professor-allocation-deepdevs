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
    	cur1.setName("fisica");
    	cur1.setId(null);
    	
    	Course cur2 = courseRepository.save(cur1);
    	System.out.println(cur2);
    	
    	
    }
	
}
