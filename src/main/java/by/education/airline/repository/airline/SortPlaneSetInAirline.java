package by.education.airline.repository.airline;

import java.util.Collections;
import java.util.Comparator;
import java.util.Optional;
import java.util.Set;

import by.education.airline.entity.airline.Airline;
import by.education.airline.entity.plane.AbstractPlane;
import by.education.airline.specification.Specification;

public class SortPlaneSetInAirline implements Specification<Airline> {

	private Optional<String> airlineName;
	private Comparator<AbstractPlane> comparator;

	public SortPlaneSetInAirline(Optional<String> airlineName, Comparator<AbstractPlane> comparator) {
		this.airlineName = airlineName;
		this.comparator = comparator;
	}

	@Override
	public Set<Airline> execute() {

		for (Airline airline : AirlineRepositoryImpl.INSTANCE.airlineList) {
			if (airline != null && airlineName.equals(airline.getName())) {
				Collections.sort(airline.getAllPlanes(), comparator);
			}
		}
		return null;
	}

}
