package cjSecurity.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DTOLogin {

	private String username;
	
	private String password;

	public DTOLogin(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	
}
