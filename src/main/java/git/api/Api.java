package git.api;

import git.api.async.OnFlightsFound;
import git.api.async.OnPayment;
import git.domain.FlightsResult;
import git.domain.User;


public interface Api {
	
	
	public User getUser(String username);
	
	public String signUp(User user);
	
	public void resetPassword(String userId,String password,String repeatPassword);
	
	public void signOut(String username,String token);
	
	public void onFlightsFound(OnFlightsFound onFlights);
	
	public void onPayment(OnPayment onPayment);

	public String signIn(String user,String password);
	
	public String validateSocialLogin(int socialLogin,String token);

	public FlightsResult searchFlights(SearchFlightsInput input);
	
}
