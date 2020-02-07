package by.education.airline.validator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AbstractPlaneValidatorTest {

	@Test
	public void testIsFuelConsumptionPositive() {
		boolean actual = AbstractPlaneValidator.isFuelConsumptionPositive(10);
		assertEquals(true, actual);
	}

	@Test
	public void testIsFuelConsumptionNegative() {
		boolean actual = AbstractPlaneValidator.isFuelConsumptionPositive(-44);
		assertEquals(false, actual);
	}
}
