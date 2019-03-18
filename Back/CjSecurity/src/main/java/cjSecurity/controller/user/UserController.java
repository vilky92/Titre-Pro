package cjSecurity.controller.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cjSecurity.dto.JSONCredentialInfos;
import cjSecurity.model.user.User;
import cjSecurity.service.user.IUserService;

//@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RestController
@RequestMapping("/user")
@PreAuthorize("hasRole('ROLE_admin') or hasRole('ROLE_user')")
public class UserController {
	
	@Autowired
	IUserService users;
	
	//@PreAuthorize("hasRole('ROLE_admin') OR hasRole('ROLE_user')")
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getOne(@PathVariable long id) {
		User john = null;
			john = users.getUser(id);
		
		return new ResponseEntity<User>((john), HttpStatus.OK);
	}
	
	@GetMapping("/get/all")
	public ResponseEntity<?> getAll() {
		List <User> list = new ArrayList<User>();
		list = users.allUser();
		
		return new ResponseEntity<List<User>>((list), HttpStatus.ACCEPTED);
	}
	
	//Probleme ici a voir avec stefan
	@PutMapping("/put/{id}")
	public ResponseEntity<?> putUser(@PathVariable Long id, @RequestBody User user) {
		User john = null;
			john = users.updateUser(user);
		
		return new ResponseEntity<User>((john), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable long id) {
		users.removeUser(id);
		
		return new ResponseEntity<User>(HttpStatus.ACCEPTED);
	}
/*
	@GetMapping("/me")
	public ResponseEntity<?> me() {
		JSONCredentialInfos loginInfo = new JSONCredentialInfos();
		String login = SecurityContextHolder.getContext().getAuthentication().getName();
		loginInfo.setLogin(login);
		Set<String> roles = AuthorityUtils.authorityListToSet(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
		loginInfo.setRoles(roles);
		
		return new ResponseEntity<JSONCredentialInfos>(loginInfo,HttpStatus.OK);
	}*/
}
