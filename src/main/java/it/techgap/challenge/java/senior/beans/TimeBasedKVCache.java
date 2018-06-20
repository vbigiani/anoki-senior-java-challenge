package it.techgap.challenge.java.senior.beans;

import java.util.concurrent.TimeUnit;

/**
 * Time based cache interface.
 * This class should cache at most N elements
 * in memory and evict them after the given time amount (TTL)
 */
public interface TimeBasedKVCache<K,V> {
	
	/**
	 * Maximum elements to keep, FIFO policy
	 * 
	 * @param elements
	 */
	public void setMaximumElements(int elements);
	
	public void setElementsTimeToLive(long duration, TimeUnit timeunit);
	
	public V getValue(K key);
	public void addValue(K key, V value);

}
