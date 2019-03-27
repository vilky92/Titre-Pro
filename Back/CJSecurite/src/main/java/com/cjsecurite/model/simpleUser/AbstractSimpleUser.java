package com.cjsecurite.model.simpleUser;


import javax.validation.constraints.NotEmpty;

import com.cjsecurite.model.user.AbstractUser;



public abstract class AbstractSimpleUser extends AbstractUser{
	
	@NotEmpty
	private String address;
	
	@NotEmpty
	private String phoneNumber;
	
	

	protected AbstractSimpleUser() {
	}
	
	

	public AbstractSimpleUser(@NotEmpty String address, @NotEmpty String phoneNumber) {
		super();
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	



	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
