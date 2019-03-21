package cjSecurity.data;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import cjSecurity.model.activitySector.ActivitySector;
import cjSecurity.model.role.Role;
import cjSecurity.model.user.User;
import cjSecurity.repository.activitySector.IActivitySectorRepository;
import cjSecurity.repository.role.IRoleRepository;
import cjSecurity.repository.user.IUserRepository;



@Component
public class InitData implements CommandLineRunner{

	@Autowired
	private IUserRepository users;
	
	@Autowired
	private IRoleRepository roles;
	
	@Autowired
	private IActivitySectorRepository activitySector;
	
	@Autowired
	PasswordEncoder encoder;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		if(roles.count() == 0) {
			Role user = new Role("user");
			Role admin = new Role("admin");
			roles.saveAll(Arrays.asList(user, admin));
		}
	
		if (users.count() == 0) {		
				User jack = new User("admin", encoder.encode("root"), "admin@root", "john", "be", null);
				Set<Role> jackR = new HashSet<Role>();
				Role admin = roles.findById(2L).get();
				jackR.add(admin);
				jack.setRoles(jackR);
				
				users.save(jack);
		}
		
		if (activitySector.count() == 0) {
			ActivitySector bodyGuard = new ActivitySector("bodyGuard");
			ActivitySector fireSafety = new ActivitySector("fireSafety");
			ActivitySector dogMaster = new ActivitySector("dogMaster");
			ActivitySector simpleAgent = new ActivitySector("simpleAgent");
			
			activitySector.saveAll(Arrays.asList(bodyGuard, fireSafety, dogMaster, simpleAgent));
		}
		
	}

}