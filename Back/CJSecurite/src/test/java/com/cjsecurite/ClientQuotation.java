package com.cjsecurite;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cjsecurite.model.client.Client;
import com.cjsecurite.model.quotation.Quotation;
import com.cjsecurite.model.role.Role;
import com.cjsecurite.repository.ClientRepository;
import com.cjsecurite.repository.QuotationRepository;
import com.cjsecurite.repository.RoleRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientQuotation {

	@Autowired
	ClientRepository clients;
	
	@Autowired
	QuotationRepository quotations;
	
	@Autowired
	RoleRepository roles;
	
	@Before
	public void reset() {
		clients.deleteAll();
		quotations.deleteAll();		
	}

	@Test
	public void createQuotation() {

		Role client = roles.findByLabel("ROLE_CLIENT");
		Client alpha = new Client("a", " ", "dada@bobo", " ", " ", " ", null, true);
		alpha.setRole(client);
		clients.save(alpha);
		
		Date aujourdhui = new Date();
		Quotation one = new Quotation(aujourdhui, aujourdhui,2,"paris",alpha);
		quotations.save(one);
		
		assertEquals(quotations.count(), 1);
	}
	
	@Test
	public void deleteQuotation() {
		Role client = roles.findByLabel("ROLE_CLIENT");
		Client alpha = new Client("a", " ", "dada@bobo", " ", " ", " ", null, true);
		alpha.setRole(client);
		clients.save(alpha);
		
		Date aujourdhui = new Date();
		Quotation one = new Quotation(aujourdhui, aujourdhui,2,"paris",alpha);

		quotations.save(one);
		quotations.delete(one);

		assertEquals(quotations.count(), 0);
		
	}
	
	@Test
	public void createClient() {
		Role client = roles.findByLabel("ROLE_CLIENT");
		Client alpha = new Client("a", " ", "dada@bobo", " ", " ", " ", null, true);
		alpha.setRole(client);
		
		clients.save(alpha);
		assertEquals(clients.count(),1);
	}
	
	@Test
	public void deleteClient() {
		Role client = roles.findByLabel("ROLE_CLIENT");
		Client alpha = new Client("a", " ", "dada@bobo", " ", " ", " ", null, true);
		alpha.setRole(client);
		
		clients.save(alpha);
		clients.delete(alpha);
		assertEquals(clients.count(), 0);
	}
	
	@Test
	@Transactional
	public void deleteDependancy() {
		Role client = roles.findByLabel("ROLE_CLIENT");
		Client alpha = new Client("a", " ", "dada@bobo", " ", " ", " ", null, true);
		alpha.setRole(client);
		
		Date aujourdhui = new Date();
		Quotation one = new Quotation(aujourdhui, aujourdhui,2,"paris",alpha);
		
		Set<Quotation> two = new HashSet<Quotation>();
		two.add(one);
		
		clients.save(alpha);
		clients.delete(alpha);
		
		assertEquals(quotations.count(), 0);
				
	}

	@Transactional
	@Test
	public void Custom() {
		Role client = roles.findByLabel("ROLE_CLIENT");
		Client alpha = new Client("a", " ", "dada@bobo", " ", " ", " ", null, true);
		alpha.setRole(client);
		clients.save(alpha);
		
		Date aujourdhui = new Date();
		Quotation one = new Quotation(aujourdhui, aujourdhui,2,"paris", alpha);
		quotations.save(one);
		
		Quotation two = new Quotation(aujourdhui, aujourdhui,3,"New York", alpha);			
		quotations.save(two);
	
		Set<Quotation> liste = new HashSet<Quotation>();
		liste.add(one);
		liste.add(two);
		
		Set<Quotation> three =  quotations.findByClientId(alpha.getId());
		
		assertEquals(liste, three);	
	}
	
	@Test
	public void PostMan() {
		Role client = roles.findByLabel("ROLE_CLIENT");
		Client alpha = new Client("a", " ", "dada@bobo", " ", " ", " ", null, true);
		alpha.setRole(client);
		clients.save(alpha);
		
		Date aujourdhui = new Date();
		Quotation one = new Quotation(aujourdhui, aujourdhui,2,"paris", alpha);
		quotations.save(one);
		
		Quotation two = new Quotation(aujourdhui, aujourdhui,3,"New York", alpha);			
		quotations.save(two);
	
		Set<Quotation> liste = new HashSet<Quotation>();
		liste.add(one);
		liste.add(two);
	

	}
}
