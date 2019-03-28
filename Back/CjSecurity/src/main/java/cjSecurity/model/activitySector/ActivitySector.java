package cjSecurity.model.activitySector;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import cjSecurity.model.application.Application;
import cjSecurity.model.mother.Mother;
import cjSecurity.model.quotation.Quotation;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class ActivitySector extends Mother{

	private String label;
	
	@OneToMany(mappedBy="activitySector")
	private Set<Application> applications = new HashSet<Application>();
	
	@ManyToMany(mappedBy="activitySector")
	private Set<Quotation> quotations = new HashSet<Quotation>();

	public ActivitySector(String label) {
		this.label = label;
	}

	public ActivitySector() {

	}
	
	
}
