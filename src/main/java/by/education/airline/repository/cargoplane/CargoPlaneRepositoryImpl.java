package by.education.airline.repository.cargoplane;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.apache.log4j.Logger;

import by.education.airline.entity.airline.Airline;
import by.education.airline.entity.plane.CargoPlane;
import by.education.airline.exception.RepositoryException;
import by.education.airline.repository.Repository;
import by.education.airline.repository.airline.AirlineRepositoryImpl;
import by.education.airline.repository.airline.FindAirlineByName;
import by.education.airline.specification.Specification;
import by.education.airline.util.PlaneParser;
import by.education.airline.util.Reader;

public enum CargoPlaneRepositoryImpl implements Repository<CargoPlane> {

	INSTANCE;

	private final Logger LOGGER = Logger.getLogger(CargoPlaneRepositoryImpl.class);
	private String path = "src/main/resources/CargoPlanes.txt";
	List<Optional<CargoPlane>> cargoPlaneList = new ArrayList<>();

	private CargoPlaneRepositoryImpl() {
		initCargoPlaneRepository();
		LOGGER.info("Cargo plane repository initialized successfully");
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
			LOGGER.warn("Null specification");
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
				Set<Airline> airline = airlineRepository.execute(specification);
				if (airline.iterator().hasNext()) {
					airline.iterator().next().addPlane(plane.get());
				}
			} catch (RepositoryException e) {
				LOGGER.warn(e);
			}
		}
	}

}
