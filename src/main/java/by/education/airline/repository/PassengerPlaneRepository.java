package by.education.airline.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import by.education.airline.criterion.passengerplane.PassengerPlaneCriterion;
import by.education.airline.entity.plane.PassengerPlane;
import by.education.airline.exception.RepositoryException;

public interface PassengerPlaneRepository {

	public void addPassengerPlane(PassengerPlane passengerPlane);

	public void updatePassengerPlane(PassengerPlane passengerPlane);

	public Optional<PassengerPlane> removePassengerPlane(PassengerPlane passengerPlane);

	public List<Optional<PassengerPlane>> getAllPassengerPlanes();

	public Set<PassengerPlane> execute(PassengerPlaneCriterion criterion) throws RepositoryException;

}
