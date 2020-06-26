package com.hari.dsal.mislanious;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortIntegerList {
	
	public static void main(String[] args) {
		
		List l = new ArrayList<>();
		l.add(new Integer(10));
		l.add(new Integer(1));
		l.add(new Integer(20));
		l.add(new Integer(15));
		l.add(new Integer(5));
		l.add(new Integer(30));
		l.add(new Integer(25));
		

		Collections.sort(l);
		Object[] a= l.toArray();
		for(int i=0 ; i<a.length; i++) {
			System.out.println(a[i]);
		}
		l.forEach(e-> System.out.println("Element Value is :....."+ e));
	}
}
