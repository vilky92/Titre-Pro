package com.cjsecurite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cjsecurite.exeption.CandidacyNotFoundException;
import com.cjsecurite.exeption.SecurityAgentNotFoundException;
import com.cjsecurite.model.candidacy.Candidacy;
import com.cjsecurite.model.securityAgent.SecurityAgent;
import com.cjsecurite.repository.CandidacyRepository;
import com.cjsecurite.repository.SecurityAgentRepository;

@CrossOrigin(value="*")
@RestController
@PreAuthorize("hasRole('ROLE_securityAgent')")
@RequestMapping("/securityAgent")
public class SecurityAgentController {
	
	@Autowired
	SecurityAgentRepository securityagentsRepository;
	
	@Autowired
	CandidacyRepository candidacyRepository;
	

	@GetMapping("/{id}")
	public SecurityAgent getAgent(@PathVariable long id) {
		return securityagentsRepository.findById(id)
				.orElseThrow(() -> new SecurityAgentNotFoundException(id));

	}

	@DeleteMapping("/{id}")
	public void deleteAgent(@PathVariable long id) {
		
		securityagentsRepository.deleteById(id);
		
	}

	@PutMapping()
	public SecurityAgent updateAgent( @RequestBody SecurityAgent agent) {
		
		return securityagentsRepository.save(agent);

		}

	@PostMapping()
	public SecurityAgent addAgent(@RequestBody SecurityAgent agent) {
		
		return securityagentsRepository.save(agent);
	}


	@GetMapping("/candidacy/{id}")
	public Candidacy getCandidacy(@PathVariable long id) {
		return candidacyRepository.findById(id)
				.orElseThrow(() -> new CandidacyNotFoundException(id));
	}

	@DeleteMapping("/candidacy/{id}")
	public void deleteCandidacy(@PathVariable long id) {
		candidacyRepository.deleteById(id);
		
	}

	@PutMapping("/candidacy")
	public Candidacy updateCandidacy(@RequestBody Candidacy quotation) {
		
		return candidacyRepository.save(quotation);
		
	}

	@PostMapping("/candidacy")
	public Candidacy addCandidacy(@RequestBody Candidacy quotation) {
		
		return candidacyRepository.save(quotation);
	}
}

