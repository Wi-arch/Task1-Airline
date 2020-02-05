package by.education.airline.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import by.education.airline.criterion.airline.AirlineCriterion;
import by.education.airline.entity.airline.Airline;
import by.education.airline.exception.RepositoryException;
import by.education.airline.util.AirlineParser;
import by.education.airline.util.Reader;

public enum AirlineRepositoryImpl implements AirlineRepository {

	INSTANCE;

	private String path;
	private List<Optional<Airline>> airlines = new ArrayList<>();

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
	public void addAirline(Airline airline) {
		this.airlines.add(Optional.ofNullable(airline));
	}

	@Override
	public void updateAirline(Airline cargoPlane) {

		Optional<String> name = cargoPlane.getName();
		for (int i = 0; i < airlines.size(); i++) {
			if (airlines.get(i).isPresent() && airlines.get(i).get().getName().equals(name)) {
				airlines.set(i, Optional.ofNullable(cargoPlane));
				break;
			}
		}
	}

	@Override
	public Optional<Airline> removeAirline(Airline cargoPlane) {

		Optional<String> name = cargoPlane.getName();
		for (int i = 0; i < airlines.size(); i++) {
			if (airlines.get(i).isPresent() && airlines.get(i).get().getName().equals(name)) {
				return airlines.remove(i);
			}
		}
		return Optional.empty();
	}

	@Override
	public List<? extends Optional<Airline>> getAllAirlines() {
		return new ArrayList<>(airlines);
	}

	@Override
	public Set<Airline> execute(AirlineCriterion criterion) throws RepositoryException {

		if (criterion == null) {
			throw new RepositoryException("Null criterion");
		}
		return criterion.execute();
	};

	private void initAirlineRepository() {
		String airlines = Reader.getInstance().readStringFromFile(path);
		this.airlines = AirlineParser.parseStringToAirlines(airlines);
	}

}
