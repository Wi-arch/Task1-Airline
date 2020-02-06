package by.education.airline.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import by.education.airline.entity.airline.Airline;
import by.education.airline.entity.plane.PassengerPlane;
import by.education.airline.exception.RepositoryException;
import by.education.airline.specification.Specification;
import by.education.airline.util.PlaneParser;
import by.education.airline.util.Reader;

public enum PassengerPlaneRepositoryImpl implements Repository<PassengerPlane> {

	INSTANCE;

	private String path = "src/main/resources/PassengerPlanes.txt";
	List<Optional<PassengerPlane>> passengerPlaneList = new ArrayList<>();

	private PassengerPlaneRepositoryImpl() {
		initPassengerPlaneRepository();
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public Set<PassengerPlane> execute(Specification<PassengerPlane> specification) throws RepositoryException {
		if (specification == null) {
			throw new RepositoryException("Null criterion");
		}
		return specification.execute();
	}

	private void initPassengerPlaneRepository() {
		String source = Reader.getInstance().readStringFromFile(path);
		passengerPlaneList = PlaneParser.parseStringToPassengerPlaneList(source);
		for (Optional<PassengerPlane> plane : passengerPlaneList) {
			String name = plane.get().getAirlineName().orElse("");
			Repository<Airline> airlineRepository = AirlineRepositoryImpl.INSTANCE;
			Specification<Airline> specification = new FindAirlineByName(name);
			try {
				Set<Airline> airline = airlineRepository.execute(specification);
				if (!airline.isEmpty()) {
					airline.iterator().next().addPlane(plane.get());
				}
			} catch (RepositoryException e) {
				// TODO write log
			}
		}
	}

}
