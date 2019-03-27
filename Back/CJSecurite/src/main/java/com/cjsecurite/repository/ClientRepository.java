package com.cjsecurite.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cjsecurite.model.client.Client;

//DAO
public interface ClientRepository extends JpaRepository<Client, Long>{
	
}
