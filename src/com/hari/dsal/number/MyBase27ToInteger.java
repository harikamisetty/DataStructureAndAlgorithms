package com.hari.dsal.number;

public class MyBase27ToInteger {
	public static void main(String a[]) {
		String str = "adef";
		Integer i = Integer.parseInt(str, 27);
		System.out.println("Integer value: " + i);
	}
}
