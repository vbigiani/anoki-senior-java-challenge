package it.techgap.challenge.java.senior;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Challenge20TestDriven {
	public static int[] flatten(Object[] objects) {
		if (objects == null) {
			return new int[0];
		}
		return Arrays.stream(objects).flatMapToInt(Challenge20TestDriven::flattenElement).toArray();
	}
	
	private static IntStream flattenElement(Object elt) {
		if (elt instanceof Integer) {
			return IntStream.of((Integer) elt);
		} else if (elt instanceof Object[]) {
			return Arrays.stream(flatten ((Object[]) elt));
		} else if (elt instanceof int[]) {
			return Arrays.stream((int[]) elt);
		} else {
			return IntStream.of();
		}
	};
}
