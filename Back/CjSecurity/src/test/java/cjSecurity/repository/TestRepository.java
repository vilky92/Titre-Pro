package cjSecurity.repository;


import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cjSecurity.model.activitySector.ActivitySector;
import cjSecurity.model.application.Application;
import cjSecurity.model.quotation.Quotation;
import cjSecurity.model.role.Role;
import cjSecurity.model.user.User;
import cjSecurity.repository.activitySector.IActivitySectorRepository;
import cjSecurity.repository.application.IApplicationRepository;
import cjSecurity.repository.quotation.IQuotationRepository;
import cjSecurity.repository.role.IRoleRepository;
import cjSecurity.repository.user.IUserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRepository {
	
	@Autowired
	private IActivitySectorRepository activitySector;
	
	@Autowired
	private IApplicationRepository applications;
	
	@Autowired
	private IQuotationRepository quotations;
	
	@Autowired
	private IRoleRepository roles;
	
	@Autowired
	private IUserRepository users;
	
	@Before
	public void deleteAll() {
		applications.deleteAll();
		quotations.deleteAll();
		users.deleteAll();
	}
	
	@Test
	public void createUser() {
		User mick = new User("one", "two", "three", "four", "five", null);
		users.save(mick);
		
		assertEquals(users.count(), 1);
	}
	
	@Test
	public void deleteUser() {
		User mick = new User();
		users.save(mick);
		users.delete(mick);
		
		assertEquals(users.count(), 0);
	}
	
	@Test
	public void createApplication() {
		Application apply = new Application();
		applications.save(apply);
		
		assertEquals(applications.count(), 1);
	}
	
	@Test
	public void deleteApplication() {
		Application apply = new Application();
		applications.save(apply);
		applications.delete(apply);
		
		assertEquals(applications.count(), 0);
	}
	
	@Test
	public void createQuotation() {
		Quotation quot = new Quotation();
		quotations.save(quot);
		
		assertEquals(quotations.count(), 1);
	}
	
	@Test
	public void deleteQuotation() {
		Quotation quot = new Quotation();
		quotations.save(quot);
		quotations.delete(quot);
		
		assertEquals(quotations.count(), 0);
	}
/*	
	@Test
	public void createActivitySector() {
		ActivitySector bodyguard = new ActivitySector("body guard");
		activitySector.save(bodyguard);
		
		assertEquals(activitySector.count(), 1);
	}
	
	@Test
	public void deleteActivitySector() {
		ActivitySector bodyguard = new ActivitySector();
		activitySector.save(bodyguard);
		activitySector.delete(bodyguard);
		
		assertEquals(activitySector.count(), 0);
	}
	*/	
	
	@Test
	public void UserDeleteApplication() {
		User mick = new User();
		users.save(mick);
		Application apply = new Application(null, null, null, null, null, mick, null);
		applications.save(apply);
		users.delete(mick);
		
		assertEquals(applications.count(), 0);
	}
	

	@Test
	public void UserPersistQuotation() {
		User mick = new User();
		users.save(mick);
		Quotation quot = new Quotation(null, null, 0, "", null, mick, null);
		quotations.save(quot);
		users.delete(mick);
		
		assertEquals(quotations.count(), 1);
	}
	
	@Test
	public void testRole() {
		User jack = new User("marrio", null, null, null, null, null);
		Set<Role> jackR = new HashSet<Role>();
		Role admin = roles.findById(2L).get();
		jackR.add(admin);
		jack.setRoles(jackR);
		
		users.save(jack);
	}
	
	@Test
	public void userById() {
		User jack = new User("marrio", null, null, null, null, null);
		Set<Role> jackR = new HashSet<Role>();
		Role admin = roles.findById(2L).get();
		jackR.add(admin);
		jack.setRoles(jackR);
		
		users.save(jack);
		
		User paul = users.findById(jack.getId()).get();
		paul.setLogin("john");
		users.save(paul);
		
		assertEquals(jack.getFirstName(), paul.getFirstName());
	}
	
	@Test
	public void userById2() {
		User jack = new User("marrio", null, null, null, null, null);
		Set<Role> jackR = new HashSet<Role>();
		Role admin = roles.findById(2L).get();
		jackR.add(admin);
		jack.setRoles(jackR);
		
		Long id = users.save(jack).getId();

		
		assertEquals(users.findById(id).get().getLogin(),"marrio");
	}
	
	@Test
	public void postApplication() {
		User jack = new User("marrio", null, null, null, null, null);
		Set<Role> jackR = new HashSet<Role>();
		Role admin = roles.findById(2L).get();
		jackR.add(admin);
		jack.setRoles(jackR);

		Application apply = new Application();
		Long id1 = 2L;
		
		ActivitySector  activity = null;
		activity = activitySector.findById(id1).get();
		

		
		apply.setActivitySector(activity);
		apply.setAddress("avenue");
		apply.setCity("Paris");
		apply.setCoverLetter("motivé");
		apply.setNumberCard("101010");
		apply.setNumberPhone("101010");
		apply.setUser(jack);
		

		jack.setApplication(apply);
		users.save(jack);
		applications.save(apply);
		
		assertEquals(applications.count(),1);
		
	}
	
	

}
