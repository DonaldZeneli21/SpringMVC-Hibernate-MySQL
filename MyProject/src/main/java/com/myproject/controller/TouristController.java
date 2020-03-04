package com.myproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.model.Tourist;
import com.myproject.service.TouristService;

@RestController @CrossOrigin(origins = "http://localhost:4200")
public class TouristController {

	@Autowired
	private TouristService service;


	@GetMapping("/tourist")
	public ResponseEntity<List<Tourist>> listTourist() {
		
		List<Tourist> tourist = service.getTourist();
		return ResponseEntity.ok().body(tourist);
	}

	@PostMapping("/addTourist")
	public ResponseEntity<?> save(@RequestBody Tourist tourist) {
		
		long id = service.insertTourist(tourist);
		return ResponseEntity.ok().body("New Tourist has been saved with ID:" + id);
	}

	@GetMapping("/touristById/{id}")
	public ResponseEntity<Tourist> get(@PathVariable("id") long id) {
		
		Tourist tourist = service.getById(id);
		return ResponseEntity.ok().body(tourist);
	}
	
	@PutMapping("/updateTourist/{id}")
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Tourist tourist) {
		
		service.updateTourist(id, tourist);
	    return ResponseEntity.ok().body("Tourist has been updated successfully.");
	}	
	
	@DeleteMapping("/deleteTourist/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
	      
		service.deleteTourist(id);
	    return ResponseEntity.ok().body("Tourist has been deleted successfully.");
	}
}
