package git.domain;

import java.util.Date;

public class SearchFlightsInput {
	private String from;
	private String to;
	private boolean roundTrip;
	private Integer nroPassengers;
	
	public Integer getNroPassengers() {
		return nroPassengers;
	}
	public void setNroPassengers(Integer nroPassengers) {
		this.nroPassengers = nroPassengers;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public boolean isRoundTrip() {
		return roundTrip;
	}
	public void setRoundTrip(boolean roundTrip) {
		this.roundTrip = roundTrip;
	}
	public Date getDateFrom() {
		return dateFrom;
	}
	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}
	public Date getDateTo() {
		return dateTo;
	}
	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}
	private Date dateFrom;
	private Date dateTo;
	

}
