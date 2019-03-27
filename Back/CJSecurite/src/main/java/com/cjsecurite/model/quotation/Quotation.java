package com.cjsecurite.model.quotation;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.cjsecurite.model.client.Client;



@Entity
public class Quotation{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
		
	private LocalDateTime creationDate = LocalDateTime.now();
		
	@NotNull
	private Date startDate;
	
	@NotNull
	private Date endDate;
	
	@NotNull
	private int numberOfAgent;
	
	@NotEmpty
	private String location;
	
	@ManyToOne
	private Client client;

	protected Quotation() {
		
	}

	

	public Quotation(@NotNull Date startDate, @NotNull Date endDate, @NotNull int numberOfAgent,
			@NotEmpty String location, Client client) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.numberOfAgent = numberOfAgent;
		this.location = location;
		this.client = client;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getNumberOfAgent() {
		return numberOfAgent;
	}

	public void setNumberOfAgent(int numberOfAgent) {
		this.numberOfAgent = numberOfAgent;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}



	public Client getClient() {
		return client;
	}



	public void setClient(Client client) {
		this.client = client;
	}



	public LocalDateTime getCreationDate() {
		return creationDate;
	}
	
	
}
