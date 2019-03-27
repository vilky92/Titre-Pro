package com.cjsecurite.model.role;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Role{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	private LocalDateTime creationDate = LocalDateTime.now();
	
	@NotNull
	@Column(unique=true)
	private String label;
	
	protected Role() {
	}

	public Role(@NotNull String label) {
		super();
		this.label = label;
	}

	public long getId() {
		return id;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}


	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	

}
