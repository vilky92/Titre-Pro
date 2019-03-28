package cjSecurity.security;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cjSecurity.model.user.User;
import cjSecurity.repository.user.IUserRepository;

@Component
public class Blacklist {
	
	@Autowired
	private IUserRepository users;
	
	private Set<String> disabled = new HashSet<String>();
	
	// a chaque demarrage de l'appli on appellera cette methode lit la liste des users disabled et les ajoute a la blacklist
	public void loadDisabledFromDB()
	{
		for(User u : users.findByActifFalseOrderByLoginAsc())
		{
			disabled.add(u.getLogin());
			
		}
	}
	
	public boolean userInList(String user)
	{
		return disabled.contains(user);
	}
	
	public void addUser(String user)
	{
		disabled.add(user);
	}
	
	public void removeUser(String user)
	{
		disabled.remove(user);
	}
	
	public void CleanBlackList()
	{
		disabled.clear();
	}


	public List<String> getDisabled() {
		return new ArrayList<String>(disabled);
	}


}
