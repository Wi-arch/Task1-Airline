package by.education.airline.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import by.education.airline.criterion.passengerplane.PassengerPlaneCriterion;
import by.education.airline.entity.plane.PassengerPlane;
import by.education.airline.exception.RepositoryException;

public enum PassengerPlaneRepositoryImpl implements PassengerPlaneRepository {

	INSTANCE;

	private String path;
	private List<Optional<PassengerPlane>> passengerPlanes = new ArrayList<>();

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
	public void addPassengerPlane(PassengerPlane passengerPlane) {
		passengerPlanes.add(Optional.ofNullable(passengerPlane));
	}

	@Override
	public void updatePassengerPlane(PassengerPlane passengerPlane) {

		int id = passengerPlane.getId();
		for (int i = 0; i < passengerPlanes.size(); i++) {
			if (passengerPlanes.get(i).isPresent() && passengerPlanes.get(i).get().getId() == id) {
				passengerPlanes.set(i, Optional.ofNullable(passengerPlane));
				break;
			}
		}
	}

	@Override
	public Optional<PassengerPlane> removePassengerPlane(PassengerPlane passengerPlane) {

		int id = passengerPlane.getId();
		for (int i = 0; i < passengerPlanes.size(); i++) {
			if (passengerPlanes.get(i).isPresent() && passengerPlanes.get(i).get().getId() == id) {
				return passengerPlanes.remove(i);
			}
		}
		return Optional.empty();
	}

	@Override
	public List<Optional<PassengerPlane>> getAllPassengerPlanes() {
		return new ArrayList<>(passengerPlanes);
	}

	@Override
	public Set<PassengerPlane> execute(PassengerPlaneCriterion criterion) throws RepositoryException {

		if (criterion == null) {
			throw new RepositoryException("Null criterion");
		}
		return criterion.execute();
	}

	private void initPassengerPlaneRepository() {
		// TODO
	}

}
