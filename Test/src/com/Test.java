package com;

public class Test implements Comparable<Test> {
	private String s;
	@Override
	public int compareTo(Test o) {
		// TODO Auto-generated method stub
		System.out.println("Sachin");
		return s.compareTo(o.s);
	}
	

}
