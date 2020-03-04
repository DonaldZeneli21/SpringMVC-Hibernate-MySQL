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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "Tourist")
@Table(name = "TOURIST")
public class Tourist {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TOURIST")
	private Long idTourist;
	
	@Column(name = "TOURIST_NAME")
	private String touristName;
	
	@Column(name = "TOURIST_SURNAME")
	private String touristSurname;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name = "TOURIST_BITHDATE")
	private Date touristBirthdate;
	
	@Column(name = "TOURIST_EMAIL")
	private String touristEmail;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "tourist")
	@JsonIgnore
	private List<Reservation> reservations = new ArrayList<Reservation>();

	public Long getIdTourist() {
		return idTourist;
	}

	public void setIdTourist(Long idTourist) {
		this.idTourist = idTourist;
	}

	public String getTouristName() {
		return touristName;
	}

	public void setTouristName(String touristName) {
		this.touristName = touristName;
	}

	public String getTouristSurname() {
		return touristSurname;
	}

	public void setTouristSurname(String touristSurname) {
		this.touristSurname = touristSurname;
	}

	public Date getTouristBirthdate() {
		return touristBirthdate;
	}

	public void setTouristBirthdate(Date touristBirthdate) {
		this.touristBirthdate = touristBirthdate;
	}

	public String getTouristEmail() {
		return touristEmail;
	}

	public void setTouristEmail(String touristEmail) {
		this.touristEmail = touristEmail;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	
}
