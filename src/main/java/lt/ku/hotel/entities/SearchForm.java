package lt.ku.hotel.entities;



import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import lt.ku.hotel.validation.DateCompare;
import lt.ku.hotel.validation.DateConstraint;

@DateCompare(arrivalDate = "arrivalDate", departureDate = "departureDate")
public class SearchForm {
	
	@DateConstraint
	private String arrivalDate;
	
	@DateConstraint
	private String departureDate;
	
	@Range(min=1, message="Blogas svečių skaičius")
	@NotNull(message="Įveskite svečių skaičių")
	private Integer guestCount;
	
	public SearchForm() {}

	public SearchForm(String arrivalDate, String departureDate, Integer guestCount) {
		super();
		this.arrivalDate = arrivalDate;
		this.departureDate = departureDate;
		this.guestCount = guestCount;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public Integer getGuestCount() {
		return guestCount;
	}

	public void setGuestCount(Integer guestCount) {
		this.guestCount = guestCount;
	};
	
	
	
	
}
