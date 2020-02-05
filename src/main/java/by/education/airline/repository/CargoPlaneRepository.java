package by.education.airline.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import by.education.airline.criterion.cargoplane.CargoPlaneCriterion;
import by.education.airline.entity.plane.CargoPlane;
import by.education.airline.exception.RepositoryException;

public interface CargoPlaneRepository {

	public void addCargoPlane(CargoPlane cargoPlane) throws RepositoryException;

	public void updateCargoPlane(CargoPlane cargoPlane) throws RepositoryException;

	public Optional<CargoPlane> removeCargoPlane(CargoPlane cargoPlane) throws RepositoryException;

	public List<Optional<CargoPlane>> getAllCargoPlanes() throws RepositoryException;

	public Set<CargoPlane> execute(CargoPlaneCriterion criterion) throws RepositoryException;
}
