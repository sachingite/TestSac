package com;

public class Test implements Comparable<Test> {
	private String s;
	@Override
	public int compareTo(Test o) {
		// TODO Auto-generated method stub
		return s.compareTo(o.s);
	}
	

}
