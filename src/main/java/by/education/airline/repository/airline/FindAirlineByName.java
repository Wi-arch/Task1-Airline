package by.education.airline.repository.airline;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import by.education.airline.entity.airline.Airline;
import by.education.airline.specification.Specification;

public class FindAirlineByName implements Specification<Airline> {

	private Optional<String> name;

	public FindAirlineByName(String name) {
		this.name = Optional.ofNullable(name);
	}

	@Override
	public Set<Airline> execute() {

		Set<Airline> result = new HashSet<>();

		for (Airline airline : AirlineRepositoryImpl.INSTANCE.airlineList) {

			if (airline != null && airline.getName().equals(name)) {
				result.add(airline);
			}
		}
		return result;
	}

}
