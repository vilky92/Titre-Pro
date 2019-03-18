package cjSecurity.dto;

import java.util.Set;

import cjSecurity.model.role.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JWTResponse {

	private String jwt;
	
	private Set<Role> roles;
	
	private long id;
	
}
