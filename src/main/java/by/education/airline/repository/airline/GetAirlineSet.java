package by.education.airline.repository.airline;

import java.util.HashSet;
import java.util.Set;

import by.education.airline.entity.airline.Airline;
import by.education.airline.specification.Specification;

public class GetAirlineSet implements Specification<Airline> {

	@Override
	public Set<Airline> execute() {
		Set<Airline> result = new HashSet<>();
		for (Airline airline : AirlineRepositoryImpl.INSTANCE.airlineList) {
			if (airline != null) {
				result.add(airline);
			}
		}
		return result;
	}

}
