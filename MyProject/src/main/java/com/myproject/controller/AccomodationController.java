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

import com.myproject.model.Accomodation;
import com.myproject.service.AccomodationService;

@RestController @CrossOrigin(origins = "http://localhost:4200")
public class AccomodationController {

	@Autowired
	private AccomodationService service;


	@GetMapping("/accomodation")
	public ResponseEntity<List<Accomodation>> listAccomodation() {
		List<Accomodation> accomodation = service.getAccomodation();
		return ResponseEntity.ok().body(accomodation);
	}

	@PostMapping("/addAccomodation")
	public ResponseEntity<?> save(@RequestBody Accomodation accomodation) {
		long id = service.insertAccomodation(accomodation);
		return ResponseEntity.ok().body("New Accomodation has been saved with ID:" + id);
	}
	
	@GetMapping("/accomodationById/{id}")
	public ResponseEntity<Accomodation> get(@PathVariable("id") long id) {
		
		Accomodation accomodation = service.getById(id);
		return ResponseEntity.ok().body(accomodation);
	}
	
	@PutMapping("/updateAccomodation/{id}")
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Accomodation accomodation) {
		
		service.updateAccomodation(id, accomodation);
	    return ResponseEntity.ok().body("Accomodation has been updated successfully.");
	}	
	
	@DeleteMapping("/deleteAccomodation/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
	      
		service.deleteAccomodation(id);
	    return ResponseEntity.ok().body("Accomodation has been deleted successfully.");
	}
	
	//Named queries and HQL
	@GetMapping("/accomodationByType")
	public ResponseEntity<List<Accomodation>> getHotelType() {
		
		List<Accomodation> accomodationList = service.getHotelType();
		return ResponseEntity.ok().body(accomodationList);
	}
	
	@GetMapping("/accomodationByKeyword/{keyword}")
	public ResponseEntity<List<Accomodation>> getHotelTypeByKey(@PathVariable("keyword") String keyword) {
		
		List<Accomodation> accomodationList = service.searchAccomodationByType(keyword);
		return ResponseEntity.ok().body(accomodationList);
	}
	
	
	@GetMapping("/accomodationByCriteriaQuery")
	public ResponseEntity<List<Accomodation>> accomodationByCriteriaQuery() {
		List<Accomodation> accomodation = service.getAccomByCriteriaQuery();
		return ResponseEntity.ok().body(accomodation);
	}
}
