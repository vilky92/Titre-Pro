package cjSecurity.model.quotation;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import cjSecurity.model.activitySector.ActivitySector;
import cjSecurity.model.mother.Mother;
import cjSecurity.model.user.User;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Quotation extends Mother{

	private LocalDateTime startDate;
	
	private LocalDateTime endDate;
	
	private int numberAgent;
	
	private String address;
	
	private String city;
	
	@ManyToOne
	private User user;
	
	@ManyToMany
	@JoinTable(name="ActivitySector_Quotation")
	private Set<ActivitySector> activitySector = new HashSet<ActivitySector>();
	
	
	
	public void addActivitySector(ActivitySector activitySector) {
		if (activitySector != null)
		this.activitySector.add(activitySector);
	}

	public void removeActivitySector(ActivitySector activitySector) {
	if (activitySector != null)
		this.activitySector.remove(activitySector);
	}

	public Quotation(LocalDateTime startDate, LocalDateTime endDate, int numberAgent, String address, String city,
			User user, Set<ActivitySector> activitySector) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.numberAgent = numberAgent;
		this.address = address;
		this.city = city;
		this.user = user;
		this.activitySector = activitySector;
	}

	public Quotation() {
		super();
	}
	
	
}
