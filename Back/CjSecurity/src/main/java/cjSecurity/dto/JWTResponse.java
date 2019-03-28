package cjSecurity.dto;

import cjSecurity.model.role.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JWTResponse {

	private String jwt;
	
	private Role role;
	
	private long id;
	
}
