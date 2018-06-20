package it.techgap.challenge.java.senior;

import static it.techgap.challenge.java.senior.Challenge20TestDriven.flatten;
import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class Challenge20TestDrivenTest {

	@Test
	public void testFlattenArray() {
		assertArrayEquals(new int[] {}, flatten(null));
		assertArrayEquals(new int[] {}, flatten(new Object[] {}));
		assertArrayEquals(new int[] { }, flatten(new Object[] { null }));
		assertArrayEquals(new int[] { 1 }, flatten(new Object[] { new Object[] { 1 } }));
		assertArrayEquals(new int[] { 1, 2, 3, 4, 5 },
				flatten(new Object[] { 1, 2, new Object[] { 3, 4 }, new Object[] {}, 5 }));
		assertArrayEquals(new int[] { 1, 2, 3, 4, 5 },
				flatten(new Object[] { 1, 2, new int[] { 3, 4 }, new int[] {}, 5 }));
	}
}
