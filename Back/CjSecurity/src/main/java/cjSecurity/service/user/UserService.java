package cjSecurity.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cjSecurity.model.role.Role;
import cjSecurity.model.user.User;
import cjSecurity.repository.activitySector.IActivitySectorRepository;
import cjSecurity.repository.application.IApplicationRepository;
import cjSecurity.repository.quotation.IQuotationRepository;
import cjSecurity.repository.role.IRoleRepository;
import cjSecurity.repository.user.IUserRepository;
import lombok.extern.slf4j.Slf4j;

@Service
public class UserService implements IUserService{

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
	
	
	@Override
	public User createUser(User user) {
		Role simple = roles.findById(1L).get();
		User mick = new User();
		mick.setFirstName(user.getFirstName());
		mick.setLastName(user.getLastName());
		mick.setLogin(user.getLogin());
		mick.setMail(user.getMail());
		mick.setPasswordHash(user.getPasswordHash());
		mick.addRole(simple);
	
		return users.save(mick);
	}

	@Override
	public User updateUser(User user) {
		User result = null;
		
		User mick = users.findById(user.getId()).get();
		if (user.getFirstName() != null) {
			mick.setFirstName(user.getFirstName());
		}
		if (user.getLastName() != null) {
			mick.setLastName(user.getLastName());
		}
		if (user.getLogin() != null) {
			mick.setLogin(user.getLogin());
		}
		if (user.getMail() != null) {
			mick.setMail(user.getMail());
		}
		if (user.getPasswordHash() != null) {
			mick.setPasswordHash(user.getPasswordHash());
		}
		
		result = users.save(mick);
		
		return result;
	}

	@Override
	public List<User> allUser() {
		
		return users.findAll();
	}

	@Override
	public User getUser(Long id) {
		User result = null;
		result = users.findById(id).get();
		
		return result;
	}

	@Override
	public void removeUser(Long id) {
		User mick = users.findById(id).get();
		users.delete(mick);
		
	}

}
