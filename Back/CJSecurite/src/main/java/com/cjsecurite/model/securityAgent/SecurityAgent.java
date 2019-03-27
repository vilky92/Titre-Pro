package com.cjsecurite.model.securityAgent;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

import com.cjsecurite.model.candidacy.Candidacy;
import com.cjsecurite.model.role.Role;
import com.cjsecurite.model.simpleUser.AbstractSimpleUser;


@Entity
public class SecurityAgent extends AbstractSimpleUser{
	
			
	@NotEmpty
	private String lastName;
	
	@NotEmpty
	private String firstName;
	
	
	@OneToOne(mappedBy="securityAgent", cascade=CascadeType.REMOVE, orphanRemoval=true)
	private Candidacy candidacy;
	
	@OneToOne
	private Role role;
		
	protected SecurityAgent() {
		
	}
	
	public SecurityAgent(@NotEmpty String login, @NotEmpty String password, @NotEmpty String lastName,
			@NotEmpty String firstName, @NotEmpty String email, @NotEmpty String address, @NotEmpty String phoneNumber ,boolean actif) {
		this.setLogin(login);
		this.setPassword(password);
		this.lastName = lastName;
		this.firstName = firstName;
		this.setEmail(email);
		this.setAddress(address);
		this.setPhoneNumber(phoneNumber);
		this.setActif(actif);
	}



	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public Candidacy getCandidacy() {
		return candidacy;
	}


	public void setCandidacy(Candidacy candidacy) {
		this.candidacy = candidacy;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	
	
	
}
