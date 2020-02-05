package by.education.airline.criterion.airline;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import by.education.airline.entity.airline.Airline;
import by.education.airline.repository.AirlineRepositoryImpl;

public class FindAirlineByNumberOfPlanes implements AirlineCriterion {

	private int planesNumber;

	public FindAirlineByNumberOfPlanes(int planesNumber) {
		this.planesNumber = planesNumber;
	}

	@Override
	public Set<Airline> execute() {

		Set<Airline> result = new HashSet<>();

		for (Optional<Airline> airline : AirlineRepositoryImpl.INSTANCE.getAllAirlines()) {

			if (airline.isPresent() && airline.get().getNumberOfPlanes() == planesNumber) {
				result.add(airline.get());
			}
		}
		return result;
	}

}
