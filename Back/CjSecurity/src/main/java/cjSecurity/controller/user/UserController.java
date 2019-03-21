package cjSecurity.controller.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cjSecurity.dto.ApplicationDTO;
import cjSecurity.model.user.User;
import cjSecurity.service.user.IUserService;

@CrossOrigin(value="*")
@RestController
@RequestMapping("/user")
@PreAuthorize("hasRole('ROLE_admin') or hasRole('ROLE_user')")
public class UserController {
	
	@Autowired
	IUserService users;
	

	@GetMapping("/get/{id}")
	public ResponseEntity<?> getOne(@PathVariable long id) {
		User john = null;
			john = users.getUser(id);
		
		return new ResponseEntity<User>((john), HttpStatus.OK);
	}
	
	//a réparé
	//@PreAuthorize("hasRole('ROLE_admin')")
	@GetMapping("/get/all")
	public ResponseEntity<?> getAll() {
		List <User> list = new ArrayList<User>();
		list = users.allUser();
		
		List <ApplicationDTO> listUser = new ArrayList<ApplicationDTO>();
		ApplicationDTO use = new ApplicationDTO();
		for (User u : list) {
			if( u.getApplication().getAddress() != null) {
			use.setAddress(u.getApplication().getAddress());
			}
			if(u.getApplication().getCity() !=null) {
			use.setCity(u.getApplication().getCity());
			}
			if(u.getApplication().getCoverLetter() != null) {
			use.setCoverLetter(u.getApplication().getCoverLetter());
			}
			if(u.getApplication().getNumberCard() != null) {
			use.setNumberCard(u.getApplication().getNumberCard());
			}
			if(u.getApplication().getNumberPhone() != null) {
			use.setNumberPhone(u.getApplication().getNumberPhone());
			}
			if (u.getApplication().getActivitySector().getLabel() != null) {
			use.setSectorLabel(u.getApplication().getActivitySector().getLabel());
			}
			use.setUserLabel(u.getLogin());
			listUser.add(use);
		}
		return new ResponseEntity<List<ApplicationDTO>>((listUser), HttpStatus.OK);
	}
	
	@PutMapping("/put/{id}")
	public ResponseEntity<?> putUser(@PathVariable Long id, @RequestBody User user) {
		User john = null;
			john = users.updateUser(user);
		
		return new ResponseEntity<User>((john), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable long id) {
		users.removeUser(id);
		
		return new ResponseEntity<User>(HttpStatus.OK);
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
