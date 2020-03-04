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

import com.myproject.model.Reservation;
import com.myproject.service.ReservationService;

@RestController @CrossOrigin(origins = "http://localhost:4200")
public class ReservationController {

	@Autowired
	private ReservationService service;


	@GetMapping("/reservation")
	public ResponseEntity<List<Reservation>> listReservation() {
		
		List<Reservation> reservation = service.getReservation();
		return ResponseEntity.ok().body(reservation);
	}

	@PostMapping("/addReservation")
	public ResponseEntity<?> save(@RequestBody Reservation reservation) {
		
		long id = service.insertReservation(reservation);
		return ResponseEntity.ok().body("New Reservation has been saved with ID:" + id);
	}
	
	@GetMapping("/reservationById/{id}")
	public ResponseEntity<Reservation> get(@PathVariable("id") long id) {
		
		Reservation reservation = service.getById(id);
		return ResponseEntity.ok().body(reservation);
	}
	
	@PutMapping("/updateReservation/{id}")
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Reservation reservation) {
		
		service.updateReservation(id, reservation);
	    return ResponseEntity.ok().body("Reservation has been updated successfully.");
	}	
	
	@DeleteMapping("/deleteReservation/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
	      
		service.deleteReservation(id);
	    return ResponseEntity.ok().body("Reservation has been deleted successfully.");
	}
	
	
	@GetMapping("/canceledReservation")
	public ResponseEntity<List<Reservation>> getCanceledReservation() {
		
		List<Reservation> cancReservation = service.getCanceledReservation();
		return ResponseEntity.ok().body(cancReservation);
	}
}
