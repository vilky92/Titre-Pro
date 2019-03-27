package com.cjsecurite.repository;


import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cjsecurite.model.quotation.Quotation;

//DAO
public interface QuotationRepository extends JpaRepository<Quotation, Long>{
	Set<Quotation> findByClientId(long id);
}
