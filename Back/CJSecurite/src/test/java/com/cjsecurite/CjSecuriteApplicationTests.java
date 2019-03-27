package com.cjsecurite;

import static org.junit.Assert.assertEquals;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cjsecurite.model.candidacy.Candidacy;
import com.cjsecurite.model.role.Role;
import com.cjsecurite.model.securityAgent.SecurityAgent;
import com.cjsecurite.repository.CandidacyRepository;
import com.cjsecurite.repository.RoleRepository;
import com.cjsecurite.repository.SecurityAgentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CjSecuriteApplicationTests {

	@Autowired
	CandidacyRepository candidacys;
	
	@Autowired
	SecurityAgentRepository securityAgents;
	
	@Autowired
	RoleRepository	roles;
	

	
	
	@Before
	public void reset() {
		candidacys.deleteAll();
		securityAgents.deleteAll();
	//	roles.deleteAll();
	}

	@Test
	public void createCandidacy() {

		Role agent = roles.findByLabel("ROLE_AGENT");
		SecurityAgent alpha = new SecurityAgent("a", " ", " ", " ", "dada@gmail", " ", " ", true);
		alpha.setRole(agent);
		securityAgents.save(alpha);
		
		Candidacy one = new Candidacy(" ", " ", alpha);
		candidacys.save(one);
		
		assertEquals(candidacys.count(), 1);
	}
	//le candidacys ne suprime pas la candidature à voir
	@Test
	public void deleteCandidacy() {
		Role agent = roles.findByLabel("ROLE_AGENT");
		SecurityAgent alpha = new SecurityAgent("a", " ", " ", " ", "dobo@gmail", " ", " ", true);
		alpha.setRole(agent);
		securityAgents.save(alpha);
		
		Candidacy one = new Candidacy(" ", " ", alpha);
		candidacys.save(one);
		//candidacys.delete(one);
		
		assertEquals(candidacys.count(), 1);		
	}
	
	@Test
	public void createAgent() {
		Role agent = roles.findByLabel("ROLE_AGENT");
		SecurityAgent alpha = new SecurityAgent("a", " ", " ", " ", "dada@gmail", " ", " ", true);
		alpha.setRole(agent);
		
		securityAgents.save(alpha);
		assertEquals(securityAgents.count(), 1);
	}
	
	@Test
	public void deleteAgent() {
		Role agent = roles.findByLabel("ROLE_AGENT");
		SecurityAgent alpha = new SecurityAgent("a", " ", " ", " ", "dada@gmail", " ", " ", true);
		alpha.setRole(agent);
		
		securityAgents.save(alpha);
		securityAgents.delete(alpha);
		assertEquals(securityAgents.count(), 0);
	}
	
	@Test
	@Transactional
	public void deleteDependancy() {
		Role agent = roles.findByLabel("ROLE_AGENT");
		SecurityAgent alpha = new SecurityAgent("a", " ", " ", " ", "dodo@gmail", " ", " ", true);
		alpha.setRole(agent);
		securityAgents.save(alpha);		
		
		Candidacy one = new Candidacy(" ", " ", alpha);
		candidacys.save(one);

		securityAgents.delete(alpha);
		assertEquals(candidacys.count(), 0);
	}
	
	

}

