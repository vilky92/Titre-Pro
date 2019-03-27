package com.cjsecurite.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cjsecurite.model.securityAgent.SecurityAgent;

//DAO
public interface SecurityAgentRepository extends JpaRepository<SecurityAgent, Long>{

}
