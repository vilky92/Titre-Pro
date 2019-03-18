package cjSecurity.model.role;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import cjSecurity.model.mother.Mother;
import cjSecurity.model.user.User;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Role extends Mother{
	
	@NotEmpty
	private String label;
	
	@JsonIgnore
	@ManyToMany(mappedBy="roles")
	private Set<User> users = new HashSet<User>();

	public Role(@NotEmpty String label) {
		this.label = label;
	}

	public Role() {
		super();
	}
	
	
	
	
}
