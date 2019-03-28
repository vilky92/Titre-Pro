package cjSecurity.service.user;

import java.util.List;

import cjSecurity.model.user.User;


public interface IUserService {

	User createUser(User user);
	User updateUser(User user);
	List<User> allUser();
	User getUser(Long id);
	void removeUser(Long id);

}
