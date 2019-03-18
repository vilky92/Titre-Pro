package cjSecurity.repository.quotation;

import org.springframework.data.jpa.repository.JpaRepository;

import cjSecurity.model.quotation.Quotation;

public interface IQuotationRepository extends JpaRepository<Quotation, Long>{

}
