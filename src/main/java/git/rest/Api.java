package git.rest;

import git.domain.User;
import git.rest.async.OnFlightsFound;
import git.rest.async.OnPayment;

public interface Api {
	
	
	public User getUser(String username);
	
	public String signUp(User user);
	
	public void resetPassword(String userId,String password,String repeatPassword);
	
	public void signOut(String username,String token);
	
	public void onFlightsFound(OnFlightsFound onFlights);
	
	public void onPayment(OnPayment onPayment);
	
	
}
