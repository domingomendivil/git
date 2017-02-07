package git.rest;

import git.dao.DAO;
import git.domain.User;
import git.email.EMail;
import git.rest.async.OnFlightsFound;
import git.rest.async.OnPayment;

public class ApiImpl implements Api{
	
	private DAO dao;
	
	private EMail email;
	
	

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

}
