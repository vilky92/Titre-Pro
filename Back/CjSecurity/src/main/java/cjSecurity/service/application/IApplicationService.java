package cjSecurity.service.application;

import java.util.List;

import cjSecurity.dto.ApplicationDTO;
import cjSecurity.dto.UserApplicationDTO;
import cjSecurity.model.application.Application;



public interface IApplicationService {

	Application createApplication(Application application);
	Application updateApplication(UserApplicationDTO application);
	List<Application> allApplication();
	ApplicationDTO getApplication(Long id);
	void removeApplication(Long id);
}
