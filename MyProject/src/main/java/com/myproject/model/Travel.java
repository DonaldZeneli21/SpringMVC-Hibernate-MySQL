package com.myproject.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TRAVEL")
public class Travel {

	@Id
	@Column(name = "ID_TRAVEL")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTravel;

	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name = "DATE_FROM")
	private Date dateFrom;

	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name = "DATE_TO")
	private Date dateTo;

	@ManyToOne
	@JoinColumn(name = "ID_DESTINATION")
	private Destination destination;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "travel")
	@JsonIgnore
	private List<Reservation> reservations = new ArrayList<Reservation>();
	
	public Long getIdTravel() {
		return idTravel;
	}

	public void setIdTravel(Long idTravel) {
		this.idTravel = idTravel;
	}

	public Date getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateTo() {
		return dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	
}
