package cjSecurity.model.application;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import cjSecurity.model.activitySector.ActivitySector;
import cjSecurity.model.mother.Mother;
import cjSecurity.model.user.User;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Application extends Mother{

	private String numberCard;
	
	private String numberPhone;
	
	private String coverLetter;
	
	private String address;
	
	private String city;
	
	@JsonIgnore
	@OneToOne(cascade=CascadeType.DETACH)
	private User user;
	
	@JsonIgnore
	@ManyToOne
	private ActivitySector activitySector;
	
	
	

	public Application(String numberCard, String numberPhone, String coverLetter, String address, String city,
			User user, ActivitySector activitySector) {
		super();
		this.numberCard = numberCard;
		this.numberPhone = numberPhone;
		this.coverLetter = coverLetter;
		this.address = address;
		this.city = city;
		this.user = user;
		this.activitySector = activitySector;
	}

	public Application() {
		super();
	}
	
	
	
}
