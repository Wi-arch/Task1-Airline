package by.education.airline.repository.airline;

import java.util.Set;

import by.education.airline.entity.airline.Airline;
import by.education.airline.specification.Specification;

public class AddAirline implements Specification<Airline> {

	private Airline airline;

	public AddAirline(Airline airline) {
		this.airline = airline;
	}

	@Override
	public Set<Airline> execute() {

		AirlineRepositoryImpl.INSTANCE.airlineList.add(airline);
		return null;
	}

}
