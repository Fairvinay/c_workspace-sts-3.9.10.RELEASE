package com.sample.next;

public class Derived extends Base {
	 public Derived (int a ) {
		  super(a );
	 }
	 public void two() throws RuntimeException { 
		 System.out.println(" This is Derived two ");	
	 }
	 public static void  three ()  { 
		System.out.println("Derived three ");
	 }
	 @Override
	 public void shape(int b) {
		 System.out.println(" This is Derived Object ");	
			
	 }
	 public void one ( Base r ) {
		 
	 }
	 void one(int a){
		 System.out.println(" derived class "); 
	 }
}
