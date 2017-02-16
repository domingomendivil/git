package git.domain;

import java.util.List;

public class FlightsResult {
	
	private List<Flight> goingFlights;
	private List<Flight> returnFlights;
	public List<Flight> getGoingFlights() {
		return goingFlights;
	}
	public void setGoingFlights(List<Flight> goingFlights) {
		this.goingFlights = goingFlights;
	}
	public List<Flight> getReturnFlights() {
		return returnFlights;
	}
	public void setReturnFlights(List<Flight> returnFlights) {
		this.returnFlights = returnFlights;
	}

}
