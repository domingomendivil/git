package git.api;

import java.util.List;

import git.api.async.OnFlightsFound;
import git.api.async.OnPayment;
import git.domain.FlightsResult;
import git.domain.SearchFlightsInput;
import git.domain.User;
import git.flightsapi.Airport;


public interface Api {
	
	
	public User getUser(String username);
	
	public String signUp(User user);
	
	public void resetPassword(String userId,String currentPassword,String password,String repeatPassword);
	
	public void signOut(String username,String token);
	
	public void onFlightsFound(OnFlightsFound onFlights);
	
	public void onPayment(OnPayment onPayment);

	public String signIn(String user,String password);
	
	public String validateSocialLogin(int socialLogin,String token);

	public FlightsResult searchFlights(SearchFlightsInput input);

	public List<Airport> searchAirportsAutoComplete(String term, String country, boolean includeAll);


	
}
