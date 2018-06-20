package it.techgap.challenge.java.senior;

import it.techgap.challenge.java.senior.beans.OneSecondWait;
import it.techgap.challenge.java.senior.beans.TimeBasedKVCache;
import it.techgap.challenge.java.senior.beans.ValueCounter;

public class Challenge05BaseDataMethods {

	public static void executeWait(OneSecondWait waitp, int times){
		for (int i = 0; i < times; i++) {
			new Thread(() -> {
				try {
					waitp.waitOneSecond();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}).start();
		}
		try {
			Thread.sleep(1100l);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static <V> ValueCounter<V> newValueCounter(){
		return new ValueCounterImpl<>();
	}
	
	public static <K,V> TimeBasedKVCache<K,V> newTimeBasedKVCache(){
		return new TimeBasedKVCacheImpl<>();
	}

}
