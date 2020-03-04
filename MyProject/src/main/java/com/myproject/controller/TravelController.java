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

import com.myproject.model.Travel;
import com.myproject.service.TravelService;

@RestController @CrossOrigin(origins = "http://localhost:4200")
public class TravelController {

	@Autowired
	private TravelService service;


	@GetMapping("/travel")
	public ResponseEntity<List<Travel>> listTravel() {
		
		List<Travel> travel = service.getTravel();
		
		return ResponseEntity.ok().body(travel);
	}


	@PostMapping("/addTravel")
	public ResponseEntity<?> save(@RequestBody Travel travel) {
		
		long id = service.insertTravel(travel);
		return ResponseEntity.ok().body("New Travel has been saved with ID:" + id);
	}

	@GetMapping("/travelById/{id}")
	public ResponseEntity<Travel> get(@PathVariable("id") long id) {
		
		Travel travel = service.getById(id);
		return ResponseEntity.ok().body(travel);
	}
	
	@PutMapping("/updateTravel/{id}")
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Travel travel) {
		
		service.updateTravel(id, travel);
	    return ResponseEntity.ok().body("Travel has been updated successfully.");
	}	
	
	@DeleteMapping("/deleteTravel/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
	      
		service.deleteTravel(id);
	    return ResponseEntity.ok().body("Travel has been deleted successfully.");
	}
}
