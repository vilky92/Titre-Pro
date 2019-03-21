package cjSecurity.controller.application;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cjSecurity.dto.ApplicationDTO;
import cjSecurity.dto.UserApplicationDTO;
import cjSecurity.model.activitySector.ActivitySector;
import cjSecurity.model.application.Application;
import cjSecurity.model.user.User;
import cjSecurity.repository.activitySector.IActivitySectorRepository;
import cjSecurity.repository.user.IUserRepository;
import cjSecurity.service.application.IApplicationService;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("/apli")
@PreAuthorize("hasRole('ROLE_admin') or hasRole('ROLE_user')")
public class ApplicationController {
	
	@Autowired
	IApplicationService applications;
	
	@Autowired
	IUserRepository users;
	
	@Autowired
	IActivitySectorRepository sectors;
	
	//probleme ici aussi
	@PostMapping("/post")
	public ResponseEntity<?> createApplication(@RequestBody UserApplicationDTO applicationDTO) {

		
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
		return new ResponseEntity<Application>(applications.createApplication(apply),HttpStatus.OK);
	}
	
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getOne(@PathVariable long id) {
		// faire un try catch
		ApplicationDTO apply = null;
			apply = applications.getApplication(id);
			if (apply == null) {
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
		
		return new ResponseEntity<ApplicationDTO>((apply), HttpStatus.OK);
	}
	
	@GetMapping("/get/all")
	public ResponseEntity<?> getAll() {
		List <Application> list = new ArrayList<Application>();
		list = applications.allApplication();
		
		return new ResponseEntity<List<Application>>((list), HttpStatus.OK);
	}
	
	@PutMapping("/put")
	public ResponseEntity<?> putApplication(@RequestBody UserApplicationDTO application) {
		Application apply = null;
		apply = applications.updateApplication(application);
		
		return new ResponseEntity<Application>((apply), HttpStatus.OK);
	}
	
	//a réparer
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteApplication(@PathVariable long id) {
		try {
			applications.removeApplication(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ResponseEntity<Application>(HttpStatus.OK);
	}

}
