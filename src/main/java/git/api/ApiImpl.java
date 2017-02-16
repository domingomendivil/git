package git.api;

import git.api.async.OnFlightsFound;
import git.api.async.OnPayment;
import git.dao.DAO;
import git.domain.FlightsResult;
import git.domain.User;
import git.email.EMail;
import git.security.SecurityValidator;

public class ApiImpl implements Api{
	
	private DAO dao;
	
	private EMail email;
	
	private SecurityValidator validator;
	
	

	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String signUp(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void resetPassword(String userId,String password, String repeatPassword)  {
		// TODO Auto-generated method stub
		throw new BusinessException();
		
	}

	@Override
	public void signOut(String username, String token) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFlightsFound(OnFlightsFound onFlights) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPayment(OnPayment onPayment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String signIn(String user, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String validateSocialLogin(int socialLogin, String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FlightsResult searchFlights(SearchFlightsInput input) {
		
		return null;
	}

}
