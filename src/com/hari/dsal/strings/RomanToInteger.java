package com.hari.dsal.strings;

import java.util.HashMap;

public class RomanToInteger {

	public int romanToInt(String s) {
		if (s == null || s.length() == 0)
			return 0;

		// create a hash table to store the dictorary
		HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
		hashMap.put('I', 1);
		hashMap.put('V', 5);
		hashMap.put('X', 10);
		hashMap.put('L', 50);
		hashMap.put('C', 100);
		hashMap.put('D', 500);
		hashMap.put('M', 1000);

		int num = 0;

		for (int i = 0; i < s.length(); i++) {
			if (i <= s.length() - 2 && hashMap.get(s.charAt(i)) < hashMap.get(s.charAt(i + 1))) {
				num -= hashMap.get(s.charAt(i));
			} else {
				num += hashMap.get(s.charAt(i));
			}
		}
		return num;
	}
	
	public int romanToInteger(String str) {
		
		int sum =0;
		
		if(str.indexOf("IV")!= -1) {sum = sum -2;}
		if(str.indexOf("IX")!= -1) {sum = sum -2;}
		if(str.indexOf("XL")!= -1) {sum = sum -20;}
		if(str.indexOf("XC")!= -1) {sum = sum -20;}
		if(str.indexOf("CD")!= -1) {sum = sum -200;}
		if(str.indexOf("CM")!= -1) {sum = sum -200;}
		
		char[] c= str.toCharArray();
		;
		
		for(int count =0; count < str.length();count++) {
			
			if(c[count]=='M') sum = sum + 1000;
			if(c[count]=='D') sum = sum + 500;
			if(c[count]=='C') sum = sum + 100;
			if(c[count]=='L') sum = sum + 50;
			if(c[count]=='X') sum = sum + 10;
			if(c[count]=='V') sum = sum + 5;
			if(c[count]=='I') sum = sum + 1;
		}		
		
		return sum;		
	}
	
	
	public static void main(String[] args) {
		RomanToInteger rtoi = new RomanToInteger();
		System.out.println(rtoi.romanToInteger("MMXIV"));
	}
}
