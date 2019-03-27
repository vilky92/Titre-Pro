package com.cjsecurite.exeption;

public class CandidacyNotFoundException  extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public CandidacyNotFoundException(Long id) {
		super("Could not find Candidacy " + id);
	}

}