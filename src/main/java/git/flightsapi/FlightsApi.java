package git.flightsapi;

import git.domain.FlightsResult;
import git.domain.SearchFlightsInput;

public interface FlightsApi {
	
	public FlightsResult searchFlights(SearchFlightsInput searchFlights);
	
	public Airport airportAutoComplete(String searchAutocomplete);
	
	

}
