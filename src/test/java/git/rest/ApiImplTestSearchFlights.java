package git.rest;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import git.api.ApiImpl;
import git.dao.DAO;
import git.dao.FlightsFilter;
import git.domain.Flight;
import git.domain.FlightsResult;
import git.domain.SearchFlightsInput;
import git.email.EMail;
import git.security.IdentityAccessManager;

public class ApiImplTestSearchFlights {
	
	
	private DAO dao;
	private EMail email;
	private IdentityAccessManager validator;
	
	private ApiImpl api;
	
	
	@Test(expected=IllegalArgumentException.class)
	public void testSearchFlights1(){
		SearchFlightsInput input = new SearchFlightsInput();
		api.searchFlights(input);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSearchFlights2() throws ParseException{
		SearchFlightsInput input = new SearchFlightsInput();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		input.setDateFrom(dateFormat.parse("2012-03-02"));
		input.setDateTo(dateFormat.parse("2012-03-01"));
		api.searchFlights(input);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSearchFlights3() throws ParseException{
		SearchFlightsInput input = new SearchFlightsInput();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		input.setDateFrom(dateFormat.parse("2012-03-01"));
		input.setDateTo(dateFormat.parse("2012-03-02"));
		api.searchFlights(input);
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void testSearchFlights4() throws ParseException{
		SearchFlightsInput input = new SearchFlightsInput();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		input.setDateFrom(dateFormat.parse("2012-03-01"));
		input.setDateTo(dateFormat.parse("2012-03-02"));
		input.setFrom("#$");
		api.searchFlights(input);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSearchFlights5() throws ParseException{
		SearchFlightsInput input = new SearchFlightsInput();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		input.setDateFrom(dateFormat.parse("2012-03-01"));
		input.setDateTo(dateFormat.parse("2012-03-02"));
		input.setFrom("MVD");
		input.setFrom("&%/");
		api.searchFlights(input);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSearchFlights6() throws ParseException{
		SearchFlightsInput input = new SearchFlightsInput();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		input.setDateFrom(dateFormat.parse("2012-03-01"));
		input.setDateTo(dateFormat.parse("2012-03-02"));
		input.setFrom("MVD");
		input.setFrom("JFK");
		api.searchFlights(input);
	}
	
	@Test
	public void testSearchFlights7() throws ParseException{
		SearchFlightsInput input = new SearchFlightsInput();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		input.setDateFrom(dateFormat.parse("2012-03-01"));
		input.setDateTo(dateFormat.parse("2012-03-02"));
		input.setFrom("MVD");
		input.setFrom("JFK");
		input.setNroPassengers(new Integer(2));
		FlightsFilter filter = new FlightsFilter();
		List<Object> flights = new ArrayList<Object>();
		Flight flight = new Flight();
		flights.add(flight);
		when(dao.getByFilter(filter)).thenReturn(flights);
		FlightsResult result = api.searchFlights(input);
		Assert.assertEquals(flight,result.getGoingFlights().get(0));
		verify(dao.getByFilter(filter));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSearchFlights8() throws ParseException{
		SearchFlightsInput input = new SearchFlightsInput();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		input.setDateFrom(dateFormat.parse("2012-03-01"));
		input.setDateTo(dateFormat.parse("2012-03-02"));
		input.setFrom("MVD");
		input.setFrom("JFK");
		input.setNroPassengers(new Integer(-2));
		FlightsFilter filter = new FlightsFilter();
		List<Object> flights = new ArrayList<Object>();
		Flight flight = new Flight();
		flights.add(flight);
		when(dao.getByFilter(filter)).thenReturn(flights);
		FlightsResult result = api.searchFlights(input);
		Assert.assertEquals(flight,result.getGoingFlights().get(0));
		verify(dao.getByFilter(filter));
	}
	
	@Test 
	public void testSearchFlights9() throws ParseException{
		SearchFlightsInput input = new SearchFlightsInput();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		input.setDateFrom(dateFormat.parse("2012-03-01"));
		input.setDateTo(dateFormat.parse("2012-03-02"));
		input.setFrom("MVD");
		input.setFrom("JFK");
		input.setNroPassengers(new Integer(1));
		input.setRoundTrip(false);
		FlightsFilter filter = new FlightsFilter();
		List<Object> flights = new ArrayList<Object>();
		Flight flight = new Flight();

		flights.add(flight);
		when(dao.getByFilter(filter)).thenReturn(flights);
		FlightsResult result = api.searchFlights(input);
		Assert.assertEquals(flight,result.getGoingFlights().get(0));
		Assert.assertEquals(0,result.getReturnFlights().size());
		verify(dao.getByFilter(filter));
	}
	
	@Test 
	public void testSearchFlights10() throws ParseException{
		SearchFlightsInput input = new SearchFlightsInput();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		input.setDateFrom(dateFormat.parse("2012-03-01"));
		input.setDateTo(dateFormat.parse("2012-03-02"));
		input.setFrom("MVD");
		input.setFrom("JFK");
		input.setNroPassengers(new Integer(1));
		input.setRoundTrip(false);
		FlightsFilter filter = new FlightsFilter();
		List<Object> flights = new ArrayList<Object>();
		Flight flight = new Flight();
		flight.setIataFrom("MVD");
		flight.setIataFrom("JFK");
		Flight returnFlight = new Flight();
		returnFlight.setIataFrom("JFK");
		returnFlight.setIataFrom("MVD");
		flights.add(flight);
		when(dao.getByFilter(filter)).thenReturn(flights);
		FlightsResult result = api.searchFlights(input);
		Assert.assertEquals(flight,result.getGoingFlights().get(0));
		Assert.assertEquals(returnFlight,result.getReturnFlights().get(0));
		verify(dao.getByFilter(filter));
	}

}
