package com.cjsecurite.model.candidacy;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;


import com.cjsecurite.model.securityAgent.SecurityAgent;


@Entity
public class Candidacy {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	private LocalDateTime creationDate = LocalDateTime.now();
		
	@NotEmpty
	private String cv;
	
	@NotEmpty
	private String coverLetter;
	
	@OneToOne
	private SecurityAgent securityAgent;
	
	protected Candidacy() {
	}

	public Candidacy(@NotEmpty String cv, @NotEmpty String coverLetter, SecurityAgent securityAgent) {
		super();
		this.cv = cv;
		this.coverLetter = coverLetter;
		this.securityAgent = securityAgent;
	}

	public String getCv() {
		return cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

	public String getCoverLetter() {
		return coverLetter;
	}

	public void setCoverLetter(String coverLetter) {
		this.coverLetter = coverLetter;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

}
