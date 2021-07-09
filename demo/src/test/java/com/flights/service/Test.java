package com.flights.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

    @SuppressWarnings("resource")
    public static void main(String[] args) {

        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        TestBean myBean1  = (TestBean) ac.getBean("myBean");
        TestBean  teatBean= (TestBean) ac.getBean("testBean");
         
        System.out.println("a : " + teatBean.test + " : "
                + teatBean.getName());
        teatBean.setName("a TEST BEAN 1");
        System.out.println("uPdate : " + teatBean.test + " : "
                + teatBean.getName());

        System.out.println("a1 : " + myBean1.test + " : " + myBean1.getName());
        myBean1.setName(" a1 TEST BEAN 10");
        System.out.println("a1 update : " + teatBean.test + " : "
                + myBean1.getName());

    }

}