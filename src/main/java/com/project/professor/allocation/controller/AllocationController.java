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
import org.springframework.web.bind.annotation.RestController;
import com.project.professor.allocation.entity.Allocation;
import com.project.professor.allocation.service.AllocationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Allocation Management Controller")
@RestController
@RequestMapping(path = "/allocations")
public class AllocationController {

	private AllocationService allocationService;

	public AllocationController(AllocationService allocationService) {
		this.allocationService = allocationService;
	}
	
	@Operation(summary = "Search Allocation By ID")
	@GetMapping(path = "/{allocation_id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Allocation> findById(@PathVariable(name = "allocation_id") Long id) {

		Allocation allocation = allocationService.findById(id);
		if (allocation == null) {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		} else {

			return new ResponseEntity<>(allocation, HttpStatus.OK);

		}

	}
	@Operation(summary = "Show All Allocations Registred")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Allocation>> findAll() {

		List<Allocation> allocations = allocationService.findAll();
		return new ResponseEntity<List<Allocation>>(allocations, HttpStatus.OK);

	}
	
	@Operation(summary = "Register Allocation")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Allocation> create(@RequestBody Allocation alloc) {

		try {

			Allocation allocation = allocationService.create(alloc);

			return new ResponseEntity<Allocation>(allocation, HttpStatus.CREATED);

		} catch (Exception e) {

			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}

	}
	
	@Operation(summary = " Update Allocation ")
	@PutMapping(path = "/{allocation_id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Allocation> update(@PathVariable(name = "allocation_id") Long id,
			@RequestBody Allocation allocation) {
		try {
			allocation.setId(id);
			allocation = allocationService.udpate(allocation);

			if (allocation == null) {
				return new ResponseEntity<Allocation>(HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<Allocation>(allocation, HttpStatus.OK);
			}

		} catch (Exception e) {

			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}

	}
	
	@ApiResponses({
	    @ApiResponse(responseCode = "204", description = "Allocation deleted successfully"),
	})
	@Operation(summary = " Delete Allocation By ID")
	@DeleteMapping(path = "/{professor_id}")
	public ResponseEntity<Void> deleteById(@PathVariable(name = "professor_id") Long id) {
		allocationService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@ApiResponses({
	    @ApiResponse(responseCode = "204", description = "all Allocations deleted successfully"),
	})
	@Operation(summary = " Delete All Allocations Registred ")
	@DeleteMapping
	public ResponseEntity<Void> deleteAll() {
		allocationService.deleteAll();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
