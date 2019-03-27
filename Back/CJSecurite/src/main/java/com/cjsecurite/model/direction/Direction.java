package com.cjsecurite.model.direction;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

import com.cjsecurite.model.role.Role;
import com.cjsecurite.model.user.AbstractUser;



@Entity
public class Direction extends AbstractUser{
	
	

@NotEmpty
private String name;

@OneToOne
private Role role;

protected Direction() {
}

public Direction(@NotEmpty String login, @NotEmpty String password, @NotEmpty String email, @NotEmpty String name, boolean actif) {
	super();
	this.setLogin(login);
	this.setPassword(password);
	this.setEmail(email);
	this.setActif(actif);
	this.name = name;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Role getRole() {
	return role;
}

public void setRole(Role role) {
	this.role = role;
}










	
	
}
