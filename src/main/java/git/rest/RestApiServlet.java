package git.rest;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

import org.glassfish.jersey.media.sse.EventOutput;
import org.glassfish.jersey.media.sse.OutboundEvent;
import org.glassfish.jersey.media.sse.SseFeature;

import git.api.Api;
import git.domain.FlightsResult;
import git.domain.SearchFlightsInput;
import git.domain.User;
import git.flightsapi.Airport;

public class RestApiServlet {

	@Context
	private SecurityContext securityContext;

	@Inject
	private Api api;

	@GET
	@Path("/profile")
	@RolesAllowed({ "Administrator", "Customer" })
	public User getUser() {
		Principal principal = securityContext.getUserPrincipal();
		return api.getUser(principal.getName());
	}

	@GET
	@Path("/flights")
	@PermitAll
	public FlightsResult searchFlights(@QueryParam("from") String from, @QueryParam("to") String to,
			@QueryParam("dateFrom") String dateFrom, @QueryParam("dateTo") String dateTo,
			@QueryParam("nroPassengers") int nroPassengers) {
		SearchFlightsInput input = new SearchFlightsInput();
		return api.searchFlights(input);
	}
	
	
	public List<Airport> searchAirportsAutoComplete(@QueryParam("term")String term, @QueryParam("country")String country,@QueryParam("includeAll")boolean includeAll ){
		return api.searchAirportsAutoComplete(term,country,includeAll);
	}
	
	
	

	@GET
	@Produces(SseFeature.SERVER_SENT_EVENTS)
	public EventOutput getServerSentEvents() {
		final EventOutput eventOutput = new EventOutput();
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					for (int i = 0; i < 10; i++) {
						// ... code that waits 1 second
						final OutboundEvent.Builder eventBuilder = new OutboundEvent.Builder();
						eventBuilder.name("message-to-client");
						eventBuilder.data(String.class, "Hello world " + i + "!");
						final OutboundEvent event = eventBuilder.build();
						eventOutput.write(event);
					}
				} catch (IOException e) {
					throw new RuntimeException("Error when writing the event.", e);
				} finally {
					try {
						eventOutput.close();
					} catch (IOException ioClose) {
						throw new RuntimeException("Error when closing the event output.", ioClose);
					}
				}
			}
		}).start();
		return eventOutput;
	}

}
