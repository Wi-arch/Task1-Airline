package by.education.airline.criterion;

import java.util.Set;

public interface Criterion<T> {

	public Set<T> execute();
}
