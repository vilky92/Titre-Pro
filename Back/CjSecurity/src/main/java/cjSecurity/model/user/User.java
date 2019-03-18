package cjSecurity.model.user;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import cjSecurity.model.application.Application;
import cjSecurity.model.mother.Mother;
import cjSecurity.model.quotation.Quotation;
import cjSecurity.model.role.Role;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class User extends Mother{

	@Column(unique=true)
	private String login;
	
	private String passwordHash;
	
	private String mail;
	
	private String lastName;
	
	private String firstName;
	
	private boolean actif = true;
	
	@ManyToMany()
	@JoinTable(name="Role_Users")
	private Set<Role> roles = new HashSet<Role>();
	
	@OneToMany(mappedBy="user")
	private Set<Quotation> quotations = new HashSet<Quotation>();
	

	@OneToOne(mappedBy="user", cascade=CascadeType.ALL, orphanRemoval=true)
	@JoinColumn(name="id_application")
	private Application application;
	
	
	
	public void addRole(Role role) {
		if (role != null)
		this.roles.add(role);
	}

	public void removeRole(Role role) {
	if (role != null)
		this.roles.remove(role);
	}



	public User() {

	}

	public User(String login, String passwordHash, String mail, String lastName, String firstName,
			Set<Role> roles) {
		super();
		this.login = login;
		this.passwordHash = passwordHash;
		this.mail = mail;
		this.lastName = lastName;
		this.firstName = firstName;
		this.roles = roles;
	}

	
	
}
