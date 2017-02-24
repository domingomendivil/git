package git.api;

import java.util.List;

import git.api.async.OnFlightsFound;
import git.api.async.OnPayment;
import git.dao.DAO;
import git.domain.FlightsResult;
import git.domain.SearchFlightsInput;
import git.domain.User;
import git.email.EMail;
import git.flightsapi.Airport;
import git.flightsapi.FlightsApi;
import git.payments.PaymentApi;
import git.security.IdentityAccessManager;



//BE01000	- Password cannot be null
//BE01001	- Password and repetition are not the same
//BE01002	- Password does not meet policy
//BE01003	- Password cannot be the same, as the actual password
//BE01004	- Password does not meet policy
//BE01005	- Actual password is not correct


public class ApiImpl implements Api{
	
	private DAO dao;
	
	private EMail email;
	
	private FlightsApi flightsApi;
	
	private PaymentApi paymentApi;
	
	private IdentityAccessManager identityAccessManager;
	
	

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
	public void resetPassword(String user,String currentpassword,String password, String repeatPassword)  {
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

	@Override
	public List<Airport> searchAirportsAutoComplete(String term, String country, boolean includeAll) {
		// TODO Auto-generated method stub
		return null;
	}

}
