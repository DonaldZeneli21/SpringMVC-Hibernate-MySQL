package com.myproject.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "RESERVATION")

@NamedQueries(value = { 
        @NamedQuery(name = Reservation.CANCELED_RESERVATION ,
        query = "SELECT r FROM Reservation r WHERE r.flagCancelled = true "
        )})
public class Reservation {

	public static final String CANCELED_RESERVATION = "getCanceledDestination";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_RESERVATION")
	private Long idReservation;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name = "RESERVATION_DATE")
	private Date reservationDate;
	
	@Column(name = "FLAG_CANCELLED")
	private boolean flagCancelled;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name = "CANCEL_DATE")
	private Date cancelDate;
	
	@ManyToOne
	@JoinColumn(name = "ID_TRAVEL")
	private Travel travel;
	
	@ManyToOne
	@JoinColumn(name = "ID_TOURIST")
	private Tourist tourist;
	
	@ManyToOne
	@JoinColumn(name = "ID_ACCOMODATION")
	private Accomodation accomodation;

	public Long getIdReservation() {
		return idReservation;
	}

	public void setIdReservation(Long idReservation) {
		this.idReservation = idReservation;
	}

	public Date getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}

	public boolean isFlagCancelled() {
		return flagCancelled;
	}

	public void setFlagCancelled(boolean flagCancelled) {
		this.flagCancelled = flagCancelled;
	}

	public Date getCancelDate() {
		return cancelDate;
	}

	public void setCancelDate(Date cancelDate) {
		this.cancelDate = cancelDate;
	}

	public Travel getTravel() {
		return travel;
	}

	public void setTravel(Travel travel) {
		this.travel = travel;
	}

	public Tourist getTourist() {
		return tourist;
	}

	public void setTourist(Tourist tourist) {
		this.tourist = tourist;
	}

	public Accomodation getAccomodation() {
		return accomodation;
	}

	public void setAccomodation(Accomodation accomodation) {
		this.accomodation = accomodation;
	}
	
	
}
