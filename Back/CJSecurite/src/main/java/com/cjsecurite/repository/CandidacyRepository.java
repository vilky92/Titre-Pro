package com.cjsecurite.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cjsecurite.model.candidacy.Candidacy;

//DAO
public interface CandidacyRepository extends JpaRepository<Candidacy, Long>{

}
