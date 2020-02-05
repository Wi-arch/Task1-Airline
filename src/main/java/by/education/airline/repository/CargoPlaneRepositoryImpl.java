package by.education.airline.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import by.education.airline.criterion.cargoplane.CargoPlaneCriterion;
import by.education.airline.entity.plane.CargoPlane;
import by.education.airline.exception.RepositoryException;
import by.education.airline.util.CargoPlaneParser;
import by.education.airline.util.Reader;

public enum CargoPlaneRepositoryImpl implements CargoPlaneRepository {

	INSTANCE;

	private String path;
	private List<Optional<CargoPlane>> cargoPlanes = new ArrayList<>();

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
	public void addCargoPlane(CargoPlane cargoPlane) {
		cargoPlanes.add(Optional.ofNullable(cargoPlane));
	}

	@Override
	public void updateCargoPlane(CargoPlane cargoPlane) {

		int id = cargoPlane.getId();
		for (int i = 0; i < cargoPlanes.size(); i++) {
			if (cargoPlanes.get(i).isPresent() && cargoPlanes.get(i).get().getId() == id) {
				cargoPlanes.set(i, Optional.ofNullable(cargoPlane));
				break;
			}
		}
	}

	@Override
	public Optional<CargoPlane> removeCargoPlane(CargoPlane cargoPlane) {

		int id = cargoPlane.getId();
		for (int i = 0; i < cargoPlanes.size(); i++) {
			if (cargoPlanes.get(i).isPresent() && cargoPlanes.get(i).get().getId() == id) {
				return cargoPlanes.remove(i);
			}
		}
		return Optional.empty();
	}

	@Override
	public List<Optional<CargoPlane>> getAllCargoPlanes() {
		return new ArrayList<>(cargoPlanes);
	}

	@Override
	public Set<CargoPlane> execute(CargoPlaneCriterion criterion) throws RepositoryException {

		if (criterion == null) {
			throw new RepositoryException("Null criterion");
		}

		return criterion.execute();
	}

	private void initCargoPlaneRepository() {
		String source = Reader.getInstance().readStringFromFile(path);
		this.cargoPlanes = CargoPlaneParser.parseStringToCargoPlanes(source);
	}

}
