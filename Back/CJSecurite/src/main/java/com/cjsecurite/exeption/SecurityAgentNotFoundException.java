package com.cjsecurite.exeption;

public class SecurityAgentNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public SecurityAgentNotFoundException(Long id) {
		super("Could not find security agent " + id);
	}

}
