package com.cjsecurite.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cjsecurite.exeption.ClientNotFoundException;
import com.cjsecurite.exeption.QuotationNotFoundException;
import com.cjsecurite.model.client.Client;
import com.cjsecurite.model.quotation.Quotation;
import com.cjsecurite.repository.ClientRepository;
import com.cjsecurite.repository.QuotationRepository;

@RestController
@PreAuthorize("hasRole('ROLE_client')")
@RequestMapping("/client")
public class ClientServiceController {
	
	@Autowired
	ClientRepository clientRepository;
	
	@Autowired
	QuotationRepository quotationRepository;
	

	@GetMapping("/{id}")
	public Client getClient(@PathVariable long id) {
		return clientRepository.findById(id)
				.orElseThrow(() -> new ClientNotFoundException(id));

	}

	@DeleteMapping("/{id}")
	public void deleteClient(@PathVariable long id) {
		
		clientRepository.deleteById(id);
		
	}

	@PutMapping()
	public Client updateClient( @RequestBody Client client) {
		
		return clientRepository.save(client);

		}

	@PostMapping()
	public Client addClient(@RequestBody Client client) {
		
		return clientRepository.save(client);
	}

	@GetMapping("/quotation/list/{id}")
	public Set<Quotation> getAllQuotations(@PathVariable long id) {
		return quotationRepository.findByClientId(id);
		}
	

	@GetMapping("/quotation/{id}")
	public Quotation getQuotation(@PathVariable long id) {
		return quotationRepository.findById(id)
				.orElseThrow(() -> new QuotationNotFoundException(id));
	}

	@DeleteMapping("/quotation/{id}")
	public void deleteQuotation(@PathVariable long id) {
		quotationRepository.deleteById(id);
		
	}

	@PutMapping("/quotation")
	public Quotation updateQuotation(@RequestBody Quotation quotation) {
		
		return quotationRepository.save(quotation);
		
	}

	@PostMapping("/quotation")
	public Quotation addQuotation(@RequestBody Quotation quotation) {
		
		return quotationRepository.save(quotation);
	}
}

