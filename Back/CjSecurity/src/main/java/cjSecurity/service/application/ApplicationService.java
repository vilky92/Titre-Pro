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
import cjSecurity.repository.user.IUserRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ApplicationService implements IApplicationService {

	@Autowired
	private IActivitySectorRepository activitySector;

	@Autowired
	private IApplicationRepository applications;

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
	public void removeApplication(Long id) throws Exception {

		// existe t il un user d 'id id
		if (users.findById(id).isPresent()==false) throw new Exception("pas de user avec l id "+id);
			log.info("user ok avec id "+id );
			User user = users.findById(id).get();
			Long appid = user.getApplication().getId();

			if (applications.findById(appid).isPresent() == false) throw new Exception("pas de candidature pour "+user.getLogin());
			log.info("appli ok pour user avec id "+id );
				Application appli = applications.findById(appid).get();
				log.info("appli id = "+appli.getId());
				log.info("mon appli = "+user.getApplication());
				applications.deleteAll();
				applications.delete(appli);		
				log.info("appli id = "+appli.getId());
				log.info("mon appli = "+user.getApplication());
	}

}
