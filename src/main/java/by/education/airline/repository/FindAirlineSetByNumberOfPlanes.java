package by.education.airline.repository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import by.education.airline.entity.airline.Airline;
import by.education.airline.specification.Specification;

public class FindAirlineSetByNumberOfPlanes implements Specification<Airline> {

	private int planesNumber;

	public FindAirlineSetByNumberOfPlanes(int planesNumber) {
		this.planesNumber = planesNumber;
	}

	@Override
	public Set<Airline> execute() {

		Set<Airline> result = new HashSet<>();

		for (Optional<Airline> airline : AirlineRepositoryImpl.INSTANCE.airlineList) {

			if (airline.isPresent() && airline.get().getNumberOfPlanes() == planesNumber) {
				result.add(airline.get());
			}
		}
		return result;
	}

}