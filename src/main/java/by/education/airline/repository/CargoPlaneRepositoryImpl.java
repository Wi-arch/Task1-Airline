package by.education.airline.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import by.education.airline.entity.airline.Airline;
import by.education.airline.entity.plane.CargoPlane;
import by.education.airline.exception.RepositoryException;
import by.education.airline.specification.Specification;
import by.education.airline.util.PlaneParser;
import by.education.airline.util.Reader;

public enum CargoPlaneRepositoryImpl implements Repository<CargoPlane> {

	INSTANCE;

	private String path = "CargoPlanes.txt";
	List<Optional<CargoPlane>> cargoPlaneList = new ArrayList<>();

	private CargoPlaneRepositoryImpl() {
		initCargoPlaneRepository();
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public Set<CargoPlane> execute(Specification<CargoPlane> specification) throws RepositoryException {
		if (specification == null) {
			throw new RepositoryException("Null criterion");
		}

		return specification.execute();
	}

	private void initCargoPlaneRepository() {
		String source = Reader.getInstance().readStringFromFile(path);
		cargoPlaneList = PlaneParser.parseStringToCargoPlaneList(source);
		for (Optional<CargoPlane> plane : cargoPlaneList) {
			String name = plane.get().getAirlineName().orElse("");
			Repository<Airline> airlineRepository = AirlineRepositoryImpl.INSTANCE;
			Specification<Airline> specification = new FindAirlineByName(name);
			try {
				Set<Airline> airlines = airlineRepository.execute(specification);
				if (!airlines.isEmpty()) {
					airlines.iterator().next().addPlane(plane.get());
				}
			} catch (RepositoryException e) {
				// TODO write log
			}
		}
	}

}
