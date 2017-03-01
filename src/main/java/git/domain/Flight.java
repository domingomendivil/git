package git.domain;

import java.util.Date;

import javax.persistence.Table;

public class Flight {
	private String iataFrom;
	private String iataTo;
	private String airCraft;
	private String flight_number;
	private Date departsAt;
	private Date arrivesAt;
	private BookingInfo bookingInfo;
	public String getIataFrom() {
		return iataFrom;
	}
	public void setIataFrom(String iataFrom) {
		this.iataFrom = iataFrom;
	}
	public String getIataTo() {
		return iataTo;
	}
	public void setIataTo(String iataTo) {
		this.iataTo = iataTo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((iataFrom == null) ? 0 : iataFrom.hashCode());
		result = prime * result + ((iataTo == null) ? 0 : iataTo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flight other = (Flight) obj;
		if (iataFrom == null) {
			if (other.iataFrom != null)
				return false;
		} else if (!iataFrom.equals(other.iataFrom))
			return false;
		if (iataTo == null) {
			if (other.iataTo != null)
				return false;
		} else if (!iataTo.equals(other.iataTo))
			return false;
		return true;
	}

}
