package by.education.airline.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import by.education.airline.entity.airline.Airline;
import by.education.airline.exception.RepositoryException;
import by.education.airline.specification.Specification;
import by.education.airline.util.AirlineParser;
import by.education.airline.util.Reader;

public enum AirlineRepositoryImpl implements Repository<Airline> {

	INSTANCE;

	private String path = "Airlines.txt";
	List<Optional<Airline>> airlineList = new ArrayList<>();

	private AirlineRepositoryImpl() {
		initAirlineRepository();
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public Set<Airline> execute(Specification<Airline> specification) throws RepositoryException {
		if (specification == null) {
			throw new RepositoryException("Null criterion");
		}
		return specification.execute();
	}

	private void initAirlineRepository() {
		String source = Reader.getInstance().readStringFromFile(path);
		airlineList = AirlineParser.parseStringToAirlineList(source);
	}

}
