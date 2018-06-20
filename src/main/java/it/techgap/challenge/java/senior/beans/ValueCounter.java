package it.techgap.challenge.java.senior.beans;

/**
 * simple interface which counts
 * how many time a given value has been seen
 */
public interface ValueCounter<V> {
	
	/**
	 * add a value to be counted against
	 */
	public void addValue(V value);
	/**
	 * return number of times value has been added 
	 */
	public int howMany(V value);

}
