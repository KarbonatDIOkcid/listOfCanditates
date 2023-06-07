package com.listofcanditates.listOfCanditates.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
public class Candidate {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String surname;
	private String initials;
	private LocalDate dateOfBirth;
	private String placeOfBirth;
	private Integer popularityIndex;
	private Integer votes = 0;  // Field initialized

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getInitials() {
		return initials;
	}

	public void setInitials(String initials) {
		this.initials = initials;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public Integer getPopularityIndex() {
		return popularityIndex;
	}

	public void setPopularityIndex(Integer popularityIndex) {
		this.popularityIndex = popularityIndex;
	}

	public Integer getVotes() {
		return votes;
	}

	public void setVotes(Integer votes) {
		this.votes = votes;
	}
}
