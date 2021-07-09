package com.flights.service;

public  class TestBean {
    static int INT = 1;
    public int test;
    String name ;
    public TestBean() {
        test = INT++;
    }
	public String getName() {
		 
		return test +""+name;
	}
	public void setName(String string) {
		name  = ""+string;
		
	}


}