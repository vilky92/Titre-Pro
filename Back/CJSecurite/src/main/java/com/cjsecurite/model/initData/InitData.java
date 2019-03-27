package com.cjsecurite.model.initData;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cjsecurite.model.role.Role;
import com.cjsecurite.repository.RoleRepository;

@Component
public class InitData implements CommandLineRunner{

	@Autowired
	private RoleRepository roles;
	
	@Override
	public void run(String... args) throws Exception {
		
		if(roles.count() == 0) {
			
			Role admin = new Role("ROLE_ADMIN");
			Role client = new Role("ROLE_CLIENT");
			Role securityAgent = new Role("ROLE_AGENT");
			
			roles.saveAll(Arrays.asList(admin, client, securityAgent));	
		}
		
	}

}
