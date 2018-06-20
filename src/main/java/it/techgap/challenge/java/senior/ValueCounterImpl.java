package it.techgap.challenge.java.senior;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import it.techgap.challenge.java.senior.beans.ValueCounter;

public class ValueCounterImpl<V> implements ValueCounter<V> {
	private Map<V, AtomicInteger> counts = new HashMap<>();

	@Override
	public void addValue(V value) {
		if (!counts.containsKey(value)) {
			counts.put(value, new AtomicInteger());
		}
		counts.get(value).getAndIncrement();
	}

	@Override
	public int howMany(V value) {
		if (!counts.containsKey(value)) {
			return 0;
		}
		return counts.get(value).get();
	}

}
