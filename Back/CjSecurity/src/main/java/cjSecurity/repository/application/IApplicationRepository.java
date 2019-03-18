package cjSecurity.repository.application;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cjSecurity.model.application.Application;

public interface IApplicationRepository extends JpaRepository<Application, Long>{

	List<Application> findAll();


}
