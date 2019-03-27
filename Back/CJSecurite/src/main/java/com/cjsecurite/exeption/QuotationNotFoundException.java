package com.cjsecurite.exeption;

public class QuotationNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public QuotationNotFoundException(Long id) {
		super("Could not find quotation " + id);
	}

}