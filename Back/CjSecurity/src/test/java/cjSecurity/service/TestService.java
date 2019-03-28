package cjSecurity.service;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cjSecurity.model.application.Application;
import cjSecurity.model.role.Role;
import cjSecurity.model.user.User;
import cjSecurity.repository.application.IApplicationRepository;
import cjSecurity.repository.role.IRoleRepository;
import cjSecurity.repository.user.IUserRepository;
import cjSecurity.service.application.IApplicationService;
import cjSecurity.service.user.IUserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestService {
	
	@Autowired
	private IRoleRepository roles;
	
	@Autowired
	private IUserRepository users;
	
	@Autowired
	private IApplicationRepository applications;

	@Autowired
	private IUserService userService;
	
	@Autowired
	private IApplicationService applicationService;
	
	@Before
	public void deleteAll() {
	//	users.deleteAll();
	}
	
	@Test
	public void createUser() {
		User doug = new User("one", "two", "three", "four", "five", null);
		Set<Role> role = new HashSet<Role>();
		Role simple = new Role("simple");
		role.add(simple);
		doug.setRoles(role);
		userService.createUser(doug);
		
		assertEquals(users.count(), 1);
	}
	
	@Test
	public void updateUser() {
		User doug = new User("one", "two", "three", "four", "five", null);
		Set<Role> role = new HashSet<Role>();
		Role simple = roles.findById(1L).get();
		role.add(simple);
		doug.setRoles(role);
		Long id = userService.createUser(doug).getId();
	
		
		
		User dougU = users.findById(id).get();
		dougU.setFirstName("mario");
		userService.updateUser(dougU);
		
		assertEquals(users.count(), 2);
	}
	
	@Test
	public void removeUser( ) {
		User doug = new User("one", "two", "three", "four", "five", null);
		Set<Role> role = new HashSet<Role>();
		Role simple = roles.findById(1L).get();
		role.add(simple);
		doug.setRoles(role);
		userService.createUser(doug);
		
		User dougU = users.findByLogin(doug.getLogin());
		userService.removeUser(dougU.getId());
		assertEquals(users.count(), 0);
	}
	

	@Test
	public void postApplication() {
		Application apply = new Application();
		Application application = new Application("", " ", null, null, null, null, null);
		apply.setActivitySector(application.getActivitySector());
		apply.setAddress(application.getAddress());
		apply.setCity(application.getCity());
		apply.setCoverLetter(application.getCoverLetter());
		apply.setNumberCard(application.getNumberCard());
		apply.setNumberPhone(application.getNumberPhone());
		apply.setUser(application.getUser());
		
		applicationService.createApplication(apply);
		
		assertEquals(applications.count(), 1);
	}
	
	
	@Test
	public void updateApplication() {
		Application application = new Application();
		Application result = null;
		Application apply = new Application();
		apply =  applications.findById(application.getId()).get();
		if(application.getActivitySector() != null) {
			apply.setActivitySector(application.getActivitySector());
		}
		if (application.getAddress() != null) {
			apply.setAddress(application.getAddress());
		}
		if (application.getCity() != null) {
			apply.setCity(application.getCity());
		}
		if (application.getCoverLetter() != null) {
			apply.setCoverLetter(application.getCoverLetter());
		}
		if (application.getNumberCard() != null) {
			apply.setNumberCard(application.getNumberCard());
		}
		if (application.getNumberPhone() != null) {
			apply.setNumberPhone(application.getNumberPhone());
		}
		result = applications.save(apply);
		
		assertEquals(applications.count(), 1);
	}
	
	@Test
	public void removeApplication() {
		User bob = new User();
		Application one = new Application();
		applications.save(one);
		bob.setApplication(one);

		
		applications.delete(one);
		
		assertEquals(applications.count(), 1);
	}
}
