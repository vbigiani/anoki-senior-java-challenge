package it.techgap.challenge.java.senior;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Challenge00BaseMethodsTest {

	// =================================================
    // This test class is not meant to be changed!
    // =================================================
	
	@Test
	public void roundTest(){
		/*
		 * Round numbers
		 */
		Assert.assertEquals(4, Challenge00BaseMethods.round(4.1));
		Assert.assertEquals(5, Challenge00BaseMethods.round(4.6));
		Assert.assertEquals(4, Challenge00BaseMethods.round(4.0f));
		Assert.assertEquals(4, Challenge00BaseMethods.round(4));
		Assert.assertEquals(4, Challenge00BaseMethods.round("4.44"));
		Assert.assertEquals(4, Challenge00BaseMethods.round("4"));
	}


	@Test
	public void bitTest(){
		/*
		 * How many bits are needed to represent the given number ?
		 */
		Assert.assertEquals(3, Challenge00BaseMethods.bitNeeded(4));
		Assert.assertEquals(3, Challenge00BaseMethods.bitNeeded(6));
		Assert.assertEquals(3, Challenge00BaseMethods.bitNeeded(7));
		Assert.assertEquals(9, Challenge00BaseMethods.bitNeeded(477));
	}
	
	@Test
	public void palindromicTest(){
		/*
		 * Is the given number "palindromic" ?
		 * Meaning the number remains the same if you read it either from left to right
		 * or right to left.
		 */
		assertTrue(Challenge00BaseMethods.palindromic(77));
		assertTrue(Challenge00BaseMethods.palindromic(99));
		assertTrue(Challenge00BaseMethods.palindromic(101));
		assertTrue(Challenge00BaseMethods.palindromic(7667));
		assertFalse(Challenge00BaseMethods.palindromic(1234));
		assertFalse(Challenge00BaseMethods.palindromic(4333));
		assertFalse(Challenge00BaseMethods.palindromic(7657));
	}
	
	@Test
	public void hexTest(){
		/*
		 * Hex string to number.
		 */
		Assert.assertEquals(4, Challenge00BaseMethods.hex("4"));
		Assert.assertEquals(514, Challenge00BaseMethods.hex("202"));
        Assert.assertEquals(10, Challenge00BaseMethods.hex("A"));
	}
	
	@Test
	public void swapTest(){
		/*
		 * Replace character "x" with "y" and "y" with "x" ignoring case.
		 */
		Assert.assertEquals("codey", Challenge00BaseMethods.swapXY("codex"));
		Assert.assertEquals("jollx", Challenge00BaseMethods.swapXY("jolly"));
		Assert.assertEquals("yx", Challenge00BaseMethods.swapXY("XY"));
		Assert.assertEquals("Joex and yavier plaxed hockex", Challenge00BaseMethods.swapXY("Joey and Xavier played hockey"));
	}
	
	@Test
	public void findNumbersTest(){
		/*
		 * Find all the numbers in a given string and return them as an array.
		 */
		Assert.assertArrayEquals(new Number[]{2015, 44, 2.5, .3}, Challenge00BaseMethods.findNumbers("In 2015 we hit 44°C for about 2.5 days in Italy, .3 avg"));
		Assert.assertArrayEquals(new Number[]{47, 38}, Challenge00BaseMethods.findNumbers("Plate EX47J--38"));
        Assert.assertArrayEquals(new Number[]{1843, 1843}, Challenge00BaseMethods.findNumbers("In 1843 John reached the top of Green Hill, 1843 mt. on sea level."));
	}

}