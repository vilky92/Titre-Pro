package cjSecurity.controller;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import cjSecurity.dto.UserApplicationDTO;
import cjSecurity.model.activitySector.ActivitySector;
import cjSecurity.model.application.Application;
import cjSecurity.model.user.User;
import cjSecurity.repository.activitySector.IActivitySectorRepository;
import cjSecurity.repository.application.IApplicationRepository;
import cjSecurity.repository.role.IRoleRepository;
import cjSecurity.repository.user.IUserRepository;
import cjSecurity.service.application.IApplicationService;
import cjSecurity.service.user.IUserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestController {

	
	@Autowired
	private IUserRepository users;
	
	@Autowired
	private IApplicationRepository applications;

	@Autowired
	private IUserService userService;
	
	@Autowired
	private IApplicationService applicationService;
	
	@Autowired
	private IActivitySectorRepository sectors;
	
	@Before
	public void deleteAll() {
	//	users.deleteAll();
	//	applications.deleteAll();
	}
	
	@Test
	public void postApplication() {
		User bob = new User("bob", null, null, null, null, null);
		users.save(bob);
		UserApplicationDTO applicationDTO = new UserApplicationDTO("", " ", " ", " ", " ", 5L, 2L);
		User john = users.findById(applicationDTO.getUserId()).get();

		Application apply = new Application();
		Long id1 = applicationDTO.getSectorId();
		
		ActivitySector  activity = null;
		activity = sectors.findById(id1).get();
		

		
		apply.setActivitySector(activity);
		apply.setAddress(applicationDTO.getAddress());
		apply.setCity(applicationDTO.getCity());
		apply.setCoverLetter(applicationDTO.getCoverLetter());
		apply.setNumberCard(applicationDTO.getNumberCard());
		apply.setNumberPhone(applicationDTO.getNumberPhone());
		apply.setUser(john);
		

		john.setApplication(apply);
		applicationService.createApplication(apply);
		
		assertEquals(applications.count(), 1);
	}
	
	@Test
	public void userGetAll() {
		List<User> liste = new ArrayList<User>();
		liste= userService.allUser();
		
		assertEquals(liste.size(), 2);
	}
}
