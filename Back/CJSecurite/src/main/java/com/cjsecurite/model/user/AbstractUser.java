package com.cjsecurite.model.user;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.cjsecurite.model.role.Role;

@MappedSuperclass
public abstract class AbstractUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	private LocalDateTime creationDate = LocalDateTime.now();

	@NotEmpty
	private String login;
	
	@NotEmpty
	private String password;
	
	@Email
	@NotEmpty
	@Column(unique=true)
	private String email;
		
	private boolean actif;
	
	@OneToOne
	@JoinColumn(name="idRole")
	private Role role;

	public long getId() {
		return id;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}	

	

}