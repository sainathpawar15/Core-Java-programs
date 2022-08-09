package com.hashmap;

import java.util.HashMap;

public class HashmapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap<String,Employee> hm=new HashMap<String,Employee>();
		hm.put("Employee1", new Employee("sainath",101,1000.00d));
		System.out.println(hm);
		

		
	}

}
