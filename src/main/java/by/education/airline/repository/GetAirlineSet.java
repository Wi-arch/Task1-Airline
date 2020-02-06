package by.education.airline.repository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import by.education.airline.entity.airline.Airline;
import by.education.airline.specification.Specification;

public class GetAirlineSet implements Specification<Airline> {

	@Override
	public Set<Airline> execute() {
		Set<Airline> result = new HashSet<>();
		for (Optional<Airline> airline : AirlineRepositoryImpl.INSTANCE.airlineList) {
			if (airline.isPresent()) {
				result.add(airline.get());
			}
		}
		return result;
	}

}