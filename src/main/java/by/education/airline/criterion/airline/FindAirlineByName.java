package by.education.airline.criterion.airline;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import by.education.airline.entity.airline.Airline;
import by.education.airline.repository.AirlineRepositoryImpl;

public class FindAirlineByName implements AirlineCriterion {

	private Optional<String> name;

	public FindAirlineByName(String name) {
		this.name = Optional.ofNullable(name);
	}

	@Override
	public Set<Airline> execute() {

		Set<Airline> result = new HashSet<>();

		for (Optional<Airline> airline : AirlineRepositoryImpl.INSTANCE.getAllAirlines()) {

			if (airline.isPresent() && airline.get().getName().equals(name)) {
				result.add(airline.get());
			}
		}
		return result;
	}
}
