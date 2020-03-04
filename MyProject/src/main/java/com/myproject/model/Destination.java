package com.myproject.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "DESTINATION")
@NamedQueries(value = { 
        @NamedQuery(name = Destination.SEARCH_KEYWORD ,
        query = "SELECT d FROM Destination d WHERE d.countryName LIKE '%' || :keyword || '%'"
        + " OR d.cityName LIKE '%' || :keyword || '%'"
        ),
        @NamedQuery(name = Destination.JOIN_TABLES ,
        query = "SELECT d FROM Destination d INNER JOIN Travel t ON d.idDestination = t.destination.idDestination"
        )
})
public class Destination {

	public static final String SEARCH_KEYWORD = "findByKeyWord";
	public static final String JOIN_TABLES = "joinTables";

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_DESTINATION")
	private Long idDestination;
	
	@Column(name = "COUNTRY_NAME")
	private String countryName;
	
	@Column(name = "CITY_NAME")
	private String cityName;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "destination", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Travel> travels =  new ArrayList<Travel>();

	public Long getIdDestination() {
		return idDestination;
	}

	public void setIdDestination(Long idDestination) {
		this.idDestination = idDestination;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public List<Travel> getTravels() {
		return travels;
	}

	public void setTravels(List<Travel> travels) {
		this.travels = travels;
	}

	
}
