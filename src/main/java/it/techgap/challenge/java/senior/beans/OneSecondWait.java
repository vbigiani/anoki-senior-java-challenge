package it.techgap.challenge.java.senior.beans;

import java.util.concurrent.atomic.AtomicInteger;


public class OneSecondWait {

	// =================================================
	// This test class is not meant to be changed!
	// =================================================

	public static AtomicInteger waitedSeconds = new AtomicInteger(0);
	
	public void waitOneSecond() throws InterruptedException{
		Thread.sleep(1000);
		waitedSeconds.incrementAndGet();
	}
	
	public static void reset(){
		waitedSeconds.set(0);
	}

}
