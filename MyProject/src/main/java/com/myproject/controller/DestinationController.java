package com.myproject.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.model.Destination;
import com.myproject.service.DestinationService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DestinationController {

	@Autowired
	private DestinationService service;

	/* Get all the destinations */
	@GetMapping("/destination")
	public ResponseEntity<List<Destination>> listDestination() {
		
	
		List<Destination> destination = service.getDestination();
		return ResponseEntity.ok(destination);
	}

	/* add new destination */
	@PostMapping("/addDestination")
	public ResponseEntity<?> save(@RequestBody Destination destination) {

		long id = service.insertDestination(destination);
		return ResponseEntity.ok().body("New Destination has been saved with ID:" + id);
	}

	/* Get a single destination */
	@GetMapping("/destinationById/{id}")
	public ResponseEntity<Destination> get(@PathVariable("id") long id) {

		Destination destination = service.getById(id);
		return ResponseEntity.ok().body(destination);
	}

	/* Update destination country or city By id */
	@PutMapping("/updateDestination/{id}")
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Destination destination) {

		service.updateDestination(id, destination);
		return ResponseEntity.ok().body("Destination has been updated successfully.");
	}

	/* Delete a destination by id */
	@DeleteMapping("/deleteDestination/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id) {

		service.deleteDestination(id);
		return ResponseEntity.ok().body("Destination has been deleted successfully.");
	}

	
	
	/*
	 * test for named queries and HQL 
	 */
	
	 /* HQL */
	@GetMapping("/orderCountryNames")
	public ResponseEntity<List<Destination>> namesCountry() {

		List<Destination> destination = service.orderCountryNames();
		return ResponseEntity.ok().body(destination);
	}

	/* Named Query */
	@GetMapping("/search/{keyword}")
	public ResponseEntity<List<Destination>> get(@PathVariable("keyword") String keyword) {

		List<Destination> list = service.search(keyword);
		return ResponseEntity.ok().body(list);
	}

	/* Named Query */
	@GetMapping("/destTravel")
	public ResponseEntity<List<Destination>> getDestTravel() {

		List<Destination> list = service.destinationTravel();
		return ResponseEntity.ok().body(list);
	}

	/* Method for downloading an list as an excel file */
	@Transactional
	@GetMapping(value = "/download/destination.xlsx")
	public ResponseEntity<InputStreamResource> download() {

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment; filename=donald.xlsx");
		headers.setContentType(new MediaType("application", "vnd.openxmlformats-officedocument.spreadsheetml.sheet"));
		// headers.setContentLength(i);

		ByteArrayOutputStream fileOut = new ByteArrayOutputStream();
		ByteArrayInputStream in = null;

		List<Destination> destionationList = service.getDestination();
		if (destionationList != null && destionationList.size() > 0) {
			for (int j = 0; j < destionationList.size(); j++) {
				Destination d = new Destination();
				d.setCountryName(destionationList.get(j).getCountryName());
				d.setCityName(destionationList.get(j).getCityName());
				destionationList.add(d);
			}
		}

		in = ExcelDownload.destinationListToExcel(destionationList);
		if (in == null) {
			in = new ByteArrayInputStream(fileOut.toByteArray());
			return ResponseEntity.ok().headers(headers).body(new InputStreamResource(in));
		}
		return ResponseEntity.ok().headers(headers).body(new InputStreamResource(in));
	}
	
	    /* CriteriaQuery */
		@GetMapping("/getDestinationsPaged")
		public ResponseEntity<List<Destination>> getDestinationsPaged(
				@RequestParam(defaultValue = "0") Integer pageNo,
				@RequestParam(defaultValue = "10") Integer pageSize) {

			List<Destination> list = service.getPagedDestinations(pageNo, pageSize);
			return ResponseEntity.ok().body(list);
		}
	 
		/* Test */
		
}