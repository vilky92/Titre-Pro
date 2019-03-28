package cjSecurity.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserApplicationDTO {

	private String numberCard;
	
	private String numberPhone;
	
	private String coverLetter;
	
	private String address;
	
	private String city;
	
	private Long UserId;
	
	private long sectorId;

	public UserApplicationDTO() {
		super();
	}

	public UserApplicationDTO(String numberCard, String numberPhone, String coverLetter, String address, String city,
			Long userId, long sectorId) {
		super();
		this.numberCard = numberCard;
		this.numberPhone = numberPhone;
		this.coverLetter = coverLetter;
		this.address = address;
		this.city = city;
		UserId = userId;
		this.sectorId = sectorId;
	}


	
	
	
}
