package it.techgap.challenge.java.senior;

import it.techgap.challenge.java.senior.beans.OneSecondWait;
import it.techgap.challenge.java.senior.beans.TimeBasedKVCache;
import it.techgap.challenge.java.senior.beans.ValueCounter;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static it.techgap.challenge.java.senior.Challenge05BaseDataMethods.*;
import static org.junit.Assert.*;

public class Challenge05BaseDataMethodsTest {

    // =================================================
    // This test class is not meant to be changed!
    // =================================================
	
	@Test
	public void testWait(){
		/*
		 * Executes the given OneSecondWait the given amounts of times.
		 */
		executeWait(new OneSecondWait(), 1);
		assertEquals(1, OneSecondWait.waitedSeconds.get());
		OneSecondWait.reset();
		
		executeWait(new OneSecondWait(), 7);
		assertEquals(7, OneSecondWait.waitedSeconds.get());
		OneSecondWait.reset();
		
		/*
		 * Execute OneSecondWait ten times
		 * in less than 5 seconds!
		 */
		long start = System.currentTimeMillis();
		executeWait(new OneSecondWait(), 10);
		assertEquals(10, OneSecondWait.waitedSeconds.get());
		long elapsed = System.currentTimeMillis() - start;
		assertTrue(elapsed < 5000);
		OneSecondWait.reset();
	}
	
	@Test
	public void testCounter(){
		/*
		 * Test a provided ValueCounter.
		 */
		ValueCounter<String> counter = newValueCounter();
		assertEquals(0, counter.howMany("foo"));
		
		counter.addValue("foo");
		assertEquals(1, counter.howMany("foo"));

		counter.addValue("foo");
		assertEquals(2, counter.howMany("foo"));

		counter.addValue("foo");
		assertEquals(3, counter.howMany("foo"));
		
		counter.addValue("bar");
		assertEquals(1, counter.howMany("bar"));
		assertEquals(3, counter.howMany("foo"));
		
		assertEquals(0, counter.howMany("baz"));
	}
	
	@Test
	public void testCache() throws InterruptedException{
		/*
		 * Test a provided TimeBasedKVCache
		 */
		TimeBasedKVCache<String, Integer> cache = newTimeBasedKVCache();
		cache.setElementsTimeToLive(500, TimeUnit.MILLISECONDS);
		cache.setMaximumElements(3);
		
		cache.addValue("1", 1);
		cache.addValue("2", 2);
		cache.addValue("3", 3);
		cache.addValue("4", 4);
		cache.addValue("4", 5);
		
		assertNull(cache.getValue("1"));
		assertEquals(new Integer(2), cache.getValue("2"));
		assertEquals(new Integer(3), cache.getValue("3"));
		assertEquals(new Integer(5), cache.getValue("4"));
		
		Thread.sleep(500);
		
		assertNull(cache.getValue("2"));
		assertNull(cache.getValue("3"));
		assertNull(cache.getValue("4"));
		
	}
	
	
}
