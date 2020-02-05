package by.education.airline.specification;

import java.util.Set;

public interface Specification<T> {

	public Set<T> execute();
}
