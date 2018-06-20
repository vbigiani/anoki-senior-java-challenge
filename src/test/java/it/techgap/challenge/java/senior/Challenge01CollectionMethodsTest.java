package it.techgap.challenge.java.senior;

import org.junit.Test;

import static it.techgap.challenge.java.senior.Challenge01CollectionMethods.*;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class Challenge01CollectionMethodsTest {

    // =================================================
    // This test class is not meant to be changed!
    // =================================================
	
	@Test
	public void boundaryTest(){
		/*
		 * Find max & min on a given unordered array.
		 */
		assertEquals(3, max(new int[]{-3,1,2,3,-1,0}));
		assertEquals(-3, min(new int[]{-3,1,2,3,-1,0}));
	}
	
	@Test
	public void sortArrayTest(){
		/*
		 * Sort unordered arrays.
		 */
		assertArrayEquals(new Boolean[]{true, true, true, false, false}, sortIt(new Boolean[]{false, true, true, false, true}));
		assertArrayEquals(new int[]{1,2,3,4,5}, sortIt(new int[]{4,2,5,3,1}));
		assertArrayEquals(new int[]{1,2,3,4,5}, sortIt(new int[]{1,2,3,4,5}));
		assertArrayEquals(new int[]{1,1,3,3,4}, sortIt(new int[]{4,3,1,3,1}));
	}
	
	@Test
	public void filterTest(){
		/*
		 * Filter arrays removing unwanted elements.
		 */
		int[] sourceArr = { -3, -2, -1, 1, 2, 3 };
		int[] filteredArr = removeNegative(sourceArr);
		assertArrayEquals(new int[]{1,2,3}, filteredArr);
		assertArrayEquals(new int[]{-3, -2, -1, 1, 2, 3}, sourceArr);

		assertArrayEquals(new int[]{0,1,2}, removeNegative(new int[]{-3,1,0,2,-1}));
	}
	
	@Test
	public void countTest(){
		/*
		 * Count occurrences of a given string in an array.
		 */
		assertEquals(1, count(new String[]{"x","y","z"}, "x"));
		assertEquals(3, count(new String[]{"x","y","z","x","x"}, "x"));

		/*
		 * How many time is present the the string with maximum occurrencies ?
		 */
		assertEquals(3, maxRepetitions(new String[]{"x","y","z","x","x"}));
		assertEquals(1, maxRepetitions(new String[]{"x","y","z"}));
		assertEquals(0, maxRepetitions(new String[]{}));
	}
	
	@Test
	public void mergeAndSortTest(){
		/*
		 * Merge & sort two arrays.
		 */
		assertArrayEquals(new int[]{1,2,3,4,5,6}, mergeAndSort(new int[]{3,1,5}, new int[]{6,2,4}));
		assertArrayEquals(new int[]{-3,-2,-1,0,1,2,3}, mergeAndSort(new int[]{-1,0,1}, new int[]{-2,0,2}, new int[]{-3,0,3}));
	}

}
