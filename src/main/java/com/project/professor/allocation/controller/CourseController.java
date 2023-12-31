package com.project.professor.allocation.controller;

import com.project.professor.allocation.entity.Course;
import com.project.professor.allocation.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Course Management Controller")
@RestController
@RequestMapping(path = "/courses")
public class CourseController {

    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @Operation(summary = "Search Courses by Name")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Course>> findByName(@RequestParam(name = "name", required = false) String name) {
        List<Course> courses;
        if (name != null && !name.isEmpty()) {
            courses = courseService.findByName(name);
        } else {
            courses = courseService.findAll();
        }
        return new ResponseEntity<>(courses, HttpStatus.OK);
        
    }

    @Operation(summary = "Search Course by ID")
    @GetMapping(path = "/{course_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Course> findById(@PathVariable(name = "course_id") Long id) {
        Course course = courseService.findById(id);
        if (course == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(course, HttpStatus.OK);
        }
    }

    @Operation(summary = "Register Course")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Course> create(@RequestBody Course course) {
        Course createdCourse = courseService.create(course);
        return new ResponseEntity<>(createdCourse, HttpStatus.CREATED);
    }

    @Operation(summary = "Update Course")
    @PutMapping(path = "/{course_id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Course> update(@PathVariable(name = "course_id") Long id,
                                         @RequestBody Course course) {
        course.setId(id);
        Course updatedCourse = courseService.update(course);
        if (updatedCourse == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(updatedCourse, HttpStatus.OK);
        }
    }

    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Course deleted successfully")
    })
    @Operation(summary = "Delete Course by ID")
    @DeleteMapping(path = "/{course_id}")
    public ResponseEntity<Void> deleteById(@PathVariable(name = "course_id") Long id) {
        courseService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "All Courses deleted successfully")
    })
    @Operation(summary = "Delete All Courses")
    @DeleteMapping
    public ResponseEntity<Void> deleteAll() {
        courseService.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
