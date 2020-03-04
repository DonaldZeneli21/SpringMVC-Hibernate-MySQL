package com.myproject.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ACCOMODATION")
@NamedQueries(value = { 
        @NamedQuery(name = Accomodation.DESTINATION_BY_ACCOMODATION,
        query = "SELECT a FROM Accomodation a WHERE a.accomodationType LIKE '%' || :keyword || '%'"
        )
})
public class Accomodation {

	public static final String DESTINATION_BY_ACCOMODATION = "getDestByAccomodationType";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ACCOMODATION")
	private Long idAccomodation;
	
	@Column(name = "ACCOMODATION_TYPE")
	private String accomodationType;
	
	@Column(name = "ADDRESS")
	private String address;
	
	@Column(name = "ROOM_NUMBER")
	private Long roomNumber;
	
	@Column(name = "COST")
	private double cost;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "accomodation")
	@JsonIgnore
	private List<Reservation> reservations = new ArrayList<Reservation>();

	public Long getIdAccomodation() {
		return idAccomodation;
	}

	public void setIdAccomodation(Long idAccomodation) {
		this.idAccomodation = idAccomodation;
	}

	public String getAccomodationType() {
		return accomodationType;
	}

	public void setAccomodationType(String accomodationType) {
		this.accomodationType = accomodationType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Long roomNumber) {
		this.roomNumber = roomNumber;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	
}
