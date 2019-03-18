package cjSecurity.controller.anonymous;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cjSecurity.dto.DTOLogin;
import cjSecurity.dto.JSONCredentialInfos;
import cjSecurity.dto.JWTResponse;
import cjSecurity.model.role.Role;
import cjSecurity.model.user.User;
import cjSecurity.repository.role.IRoleRepository;
import cjSecurity.repository.user.IUserRepository;
import cjSecurity.security.JWTService;
import cjSecurity.service.user.IUserService;


@CrossOrigin(origins = "*", allowCredentials = "true")
//@CrossOrigin(value="*")
@RestController
@RequestMapping("/ano")
public class AnonymousController {
	
	@Autowired
	private JWTService jwtService;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private IRoleRepository roles;
	
	@Autowired
	private IUserService users;
	
	@Autowired
	private IUserRepository usersR;
	
	
	@PostMapping("/post")
	public ResponseEntity<?> createUser(@RequestBody User user) {

		User john = new User();
		Set <Role> role = new HashSet<Role>();
		Role roleToAdd = roles.findByLabel("user");
		role.add(roleToAdd);

		john.setLogin(user.getLogin());
		john.setMail(user.getMail());
		john.setRoles(role);
		john.setPasswordHash(user.getPasswordHash());
		//john.setPasswordHash(encoder.encode(user.getPasswordHash()));
		john.setLastName(user.getLastName());
		john.setFirstName(user.getFirstName());

		return new ResponseEntity<User>(users.createUser(john),HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> connexion(@RequestBody DTOLogin login, HttpServletRequest request) throws Exception {
				
		if (!usersR.existsByLogin(login.getUsername())) {
			System.out.println(login.getUsername());
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Bad user");
		}

		User josh = usersR.findByLogin(login.getUsername());

		if (!josh.isActif()) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Disabled");
		}

		if (!encoder.matches(login.getPassword(), josh.getPasswordHash())) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Bad password");
		}
	
		List<String> roles = new ArrayList<String>();
		for (Role role : josh.getRoles()) {
			roles.add(role.getLabel());
		}


		String jwt = jwtService.createJWT(josh.getLogin(), roles);
		
		
		JWTResponse response = new JWTResponse();
		response.setJwt(jwt);
		response.setRoles(josh.getRoles());
		response.setId(josh.getId());
		return ResponseEntity.ok().body(response);

	}
	
	
	
}
