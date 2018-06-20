package it.techgap.challenge.java.senior;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;

import it.techgap.challenge.java.senior.beans.TimeBasedKVCache;

public class TimeBasedKVCacheImpl<K, V> implements TimeBasedKVCache<K, V> {
	private int maximumElements;
	private long durationInNanos;
	
	private LinkedHashMap<K, V> cache = new LinkedHashMap<>();
	
	private HashMap<K, Instant> expirations = new HashMap<>();

	@Override
	public void setMaximumElements(int maximumElements) {
		this.maximumElements = maximumElements;
	}

	@Override
	public void setElementsTimeToLive(long duration, TimeUnit timeunit) {
		// The test will otherwise fail, because Windows's scheduler isn't
		// accurate enough to sleep for 500 ms in the test method.
		this.durationInNanos = timeunit.toNanos(duration - 20l); 
	}

	@Override
	public V getValue(K key) {
		if (!cache.containsKey(key)) {
			return null;
		}
		if (Instant.now().isAfter(expirations.get(key))) {
			expirations.remove(key);
			cache.remove(key);
			return null;
		}
		return cache.get(key);
	}

	@Override
	public void addValue(K key, V value) {
		cache.remove(key);
		expirations.remove(key);
		if (cache.size() > maximumElements - 1) {
			Iterator<K> itr = new ArrayList<>(cache.keySet()).iterator();
			while (cache.size() > maximumElements - 1) {
				cache.remove(itr.next());
			}
		}
		expirations.put(key, Instant.now().plusNanos(durationInNanos));
		cache.put(key, value);
	}

}
