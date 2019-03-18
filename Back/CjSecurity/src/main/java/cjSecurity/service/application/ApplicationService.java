package cjSecurity.service.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cjSecurity.dto.ApplicationDTO;
import cjSecurity.dto.UserApplicationDTO;
import cjSecurity.model.application.Application;
import cjSecurity.model.user.User;
import cjSecurity.repository.activitySector.IActivitySectorRepository;
import cjSecurity.repository.application.IApplicationRepository;
import cjSecurity.repository.quotation.IQuotationRepository;
import cjSecurity.repository.role.IRoleRepository;
import cjSecurity.repository.user.IUserRepository;
import cjSecurity.service.user.UserService;
import lombok.extern.slf4j.Slf4j;

@Service
public class ApplicationService implements IApplicationService{
	
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
	public Application createApplication(Application application) {
		Application apply = new Application();
		apply.setActivitySector(application.getActivitySector());
		apply.setAddress(application.getAddress());
		apply.setCity(application.getCity());
		apply.setCoverLetter(application.getCoverLetter());
		apply.setNumberCard(application.getNumberCard());
		apply.setNumberPhone(application.getNumberPhone());
		apply.setUser(application.getUser());
		
		return applications.save(apply);
	}

	@Override
	public Application updateApplication(UserApplicationDTO application) {
		Application result = null;
		User john = users.findById(application.getUserId()).get();
		Application apply = john.getApplication();
		
		apply.setActivitySector(activitySector.findById(application.getSectorId()).get());

		
		if (application.getAddress() != null) {
			apply.setAddress(application.getAddress());
		}
		if (application.getCity() != null) {
			apply.setCity(application.getCity());
		}
		if (application.getCoverLetter() != null) {
			apply.setCoverLetter(application.getCoverLetter());
		}
		if (application.getNumberCard() != null) {
			apply.setNumberCard(application.getNumberCard());
		}
		if (application.getNumberPhone() != null) {
			apply.setNumberPhone(application.getNumberPhone());
		}
		result = applications.save(apply);
		return result;
	}

	@Override
	public List<Application> allApplication() {
		
		return applications.findAll();
	}

	@Override
	public ApplicationDTO getApplication(Long id) {
		User paul = users.findById(id).get();
		ApplicationDTO result = null;
		Application apply = applications.findById(paul.getApplication().getId()).get();
		ApplicationDTO app = new ApplicationDTO();
		app.setAddress(apply.getAddress());
		app.setCity(apply.getCity());
		app.setCoverLetter(apply.getCoverLetter());
		app.setNumberCard(apply.getNumberCard());
		app.setNumberPhone(apply.getNumberPhone());
		app.setSectorLabel(apply.getActivitySector().getLabel());
		result = app;
		return result;
	}

	@Override
	public void removeApplication(Long id) {
		User dilan = new User();
		dilan = users.findById(id).get();
		
		applications.delete(dilan.getApplication());
		
	}


}
