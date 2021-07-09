package com.flights.service.reference;

import java.util.function.BiPredicate;
import java.util.function.Consumer;

interface ThreeConsumer<T, U, V> {
    void accept(T t, int u, int v);
}
public class TestMethodReference {
	
	protected static  void display() {
		 System.out.println("TestMethodRefernce called ");
	 }
	protected  void print (int tta) {
		 System.out.println("print TestMethodRefernce called "+tta);
	 }
	protected  void print () {
		 System.out.println("print TestMethodRefernce called ");
	 }

	public  RunnableInterface bind2and3(
            Consumer c, int arg2) {
		     
			//Consumer x =  (arg1) -> c.accept(arg2);
		 /*
		  * new RunnableInterface() { public void run () {
				print();
			} }; 
		  */
			c.accept(arg2);
			return () -> { System.out.println("baic"); };
	}
	 public static void main(String[] args) {
		
		 TestMethodReference testRef = new DerivedMethodRefernce();
		 Thread pickTh = new Thread (new PickThread(testRef));
		 
		 testRef.display();
		 pickTh.start();
		 
	 }
	 
	 
}
class PickThread implements Runnable {
	TestMethodReference testOne;  
	 
	public PickThread( TestMethodReference tesMeth) {
		this.testOne =tesMeth;
	}
	@Override
	public void run() {
		
		int i = 0;
		while(i < 10 ) {
			
			Consumer c = (s ) -> testOne.print((int) s);
			BiPredicate<Integer , Integer > biPre = (a,b ) -> {
			   return a > b;
			};
			
			
			System.out.println(" this 5 i> 6 " +biPre.test(5,6)); 
			
			//testOne.bind2and3(c,3);
			/*
			 * new RunnableInterface() { public void run() 
				 { c.accept(4); } } ;
			 */
			RunnableInterface runnIter  = () -> { c.accept(3);};
			runnIter.run();
	       i++;
		}
	}
	
}
class DerivedMethodRefernce extends TestMethodReference {
	
	  public static  void display() {
		 System.out.println("DerivedMethodRefernce called ");
	 }

}