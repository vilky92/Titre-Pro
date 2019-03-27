package com.cjsecurite;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cjsecurite.model.direction.Direction;
import com.cjsecurite.model.role.Role;
import com.cjsecurite.model.securityAgent.SecurityAgent;
import com.cjsecurite.repository.DirectionRepository;
import com.cjsecurite.repository.RoleRepository;
import com.cjsecurite.repository.SecurityAgentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminTest {
	@Autowired
	RoleRepository roles;
	
	@Autowired
	DirectionRepository directions;
	
	@Autowired
	SecurityAgentRepository securityAgents;
	
	@Before
	public void reset() {
		directions.deleteAll();
		securityAgents.deleteAll();
	}
	
	@Test
	public void createAdmin() {
		Role admin = roles.findByLabel("ROLE_ADMIN");
		Direction jeanne = new Direction("jeanne", " ", "dada@gmail", " ", true);
		jeanne.setRole(admin);
		directions.save(jeanne);
	}
	
	@Test
	public void createAgent() {
			Role admin = roles.findByLabel("ROLE_ADMIN");
			SecurityAgent alpha = new SecurityAgent("a", " ", " ", " ", "dada@gmail", " ", " ", true);
			alpha.setRole(admin);
			
		securityAgents.save(alpha);
		assertEquals(securityAgents.count(), 1);
	}

}
