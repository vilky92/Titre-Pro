package com.cjsecurite.model.client;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

import com.cjsecurite.model.quotation.Quotation;
import com.cjsecurite.model.role.Role;
import com.cjsecurite.model.simpleUser.AbstractSimpleUser;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Client extends AbstractSimpleUser{
	
		
	@NotEmpty
	private String companyName;
	
	@JsonIgnore
	@OneToMany(mappedBy="client",cascade=CascadeType.REMOVE)
	private Set<Quotation> listQuotations = new HashSet<Quotation>();
	
	@OneToOne
	private Role role;
	
	protected Client() {};

	public Client(@NotEmpty String login, @NotEmpty String password, @NotEmpty String email, @NotEmpty String address, @NotEmpty String phoneNumber,
			@NotEmpty String companyName, Set<Quotation> listQuotations, boolean actif) {
		super();
		this.setLogin(login);
		this.setPassword(password);
		this.setEmail(email);
		this.setAddress(address);
		this.setPhoneNumber(phoneNumber);
		this.setActif(actif);
		this.companyName = companyName;
		this.listQuotations = listQuotations;
	}
	

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Set<Quotation> getListQuotations() {
		return listQuotations;
	}


	public void setListQuotations(Set<Quotation> listQuotations) {
		this.listQuotations = listQuotations;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	
}
