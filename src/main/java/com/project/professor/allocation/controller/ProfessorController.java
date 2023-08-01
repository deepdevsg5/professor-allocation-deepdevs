package com.project.professor.allocation.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.professor.allocation.entity.Professor;
import com.project.professor.allocation.service.ProfessorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Professor Management Controller")
@RestController
@RequestMapping(path = "/professors")
public class ProfessorController {

    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @Operation(summary = "Search All Professors")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Professor>> findAll(@RequestParam(required = false) String name) {
        List<Professor> professors = professorService.findAll(name);
        return ResponseEntity.ok(professors);
    }

    @Operation(summary = "Search Professor by ID")
    @GetMapping(path = "/{professor_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Professor> findById(@PathVariable(name = "professor_id") Long id) {
        Professor professor = professorService.findById(id);
        if (professor == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(professor, HttpStatus.OK);
        }
    }

    @Operation(summary = "Register Professor")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Professor> create(@RequestBody Professor professor) {
        try {
            Professor createdProfessor = professorService.create(professor);
            return new ResponseEntity<>(createdProfessor, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "Update Professor")
    @PutMapping(path = "/{professor_id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Professor updated successfully"),
        @ApiResponse(responseCode = "404", description = "Professor not found"),
        @ApiResponse(responseCode = "400", description = "Invalid request body")
    })
    public ResponseEntity<Professor> update(@PathVariable(name = "professor_id") Long id,
                                            @RequestBody Professor professor) {
        professor.setId(id);
        try {
            Professor updatedProfessor = professorService.update(professor);
            if (updatedProfessor == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(updatedProfessor, HttpStatus.OK);
            }
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Professor deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Professor not found")
    })
    @Operation(summary = "Delete Professor by ID")
    @DeleteMapping(path = "/{professor_id}")
    public ResponseEntity<Void> deleteById(@PathVariable(name = "professor_id") Long id) {
        if (professorService.findById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        professorService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "All Professors deleted successfully")
    })
    @Operation(summary = "Delete All Professors")
    @DeleteMapping
    public ResponseEntity<Void> deleteAll() {
        professorService.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
