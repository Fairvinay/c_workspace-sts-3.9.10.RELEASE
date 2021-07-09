package com.flights.service.reference;

import java.util.function.Consumer;

public interface RunnableInterface extends Runnable {
	
	  public void basic();
	  
	  @Override public default void run() {
		  
		  try {
			Thread.sleep(3000);
			basic();
			System.out.println("Watingin to print");
		} catch (InterruptedException e) {
			
		}
		  
	  };
	 
}
