package com.flights.service;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


class A { 
	
	void one(int A ) { }
	
}
class B  extends A { 
	 void  one (int B ) {} 
	
}

@SpringBootApplication
public class DemoApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		/*throw new NullPointerException();
		throw new IOException();
        throw new Exception();
		  A a  = new B ();
		  a.one(5);
		 */ 
		  
	}
   
}




