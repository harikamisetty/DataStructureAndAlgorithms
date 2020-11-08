package com.hari.dsal.mislanious;

import java.util.Arrays;
import java.util.Comparator;

public class StringOperations {
	
	public static void main(String[] args) {
		String s = "Anacell provides the best services in the city";
		
		String[] strs = s.split("\\s+");
		String[] strs2 =  s.split("\\W");
		
		for(String str: strs) {
			System.out.print(str+",");
		}
		System.out.println("\n");
		for(String str: strs2) {
			System.out.print(str+",");
		}	
		
		String s1 = "hello";
		char []sc1 = s1.toCharArray();
		Arrays.sort(sc1);
		System.out.println(String.valueOf(sc1));
		
		System.out.println((char)(97 + 3));
		
		String str = "hello";
		int index = str.indexOf('o');
		System.out.println(index);
		
		// REMOVE A SINGLE CHARACTER FROM A STRING
		str = str.substring(0, index) + str.substring(index + 1);
		System.out.println(str);
		
		String para = "hello,How are you,test";
		
		String patternString = para.replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase();
		System.out.println(para +" - "+patternString);
		
		String paragraph = "A man, a plan, a canal: Panama";
		// REMOVE UNWANTED CHARACTERS
		String normalizedStr = paragraph.replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase();
		System.out.println(normalizedStr);
		
		// REMOVE SPACE BETWEEN STRINGS
		String finals = normalizedStr.replaceAll("\\s+","");
		System.out.println(finals);
		
		// SPLIT THE ARRAY TO 2 PARTS
		String fs ="hello how are you?";
		String []fstr= fs.split("\\s+", 2);
		
		for(String st: fstr) {
			System.out.println(st);
		}
		
		System.out.println(fs.compareTo(fs));
		
		
		// Compare
		/*
		 * 0: if (x==y)
		  -1: if (x < y)
		   1: if (x > y)
		 */
		String []st1 ={"hari","koman","amma"};		
		
		Comparator<String> myComp = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				boolean ch = Character.isDigit(o1.charAt(0));
				if(ch)
					return -1;
				int val = o1.compareTo(o2);
				System.out.println(val);
			return val;
			}			
		};
		Arrays.sort(st1, myComp);
		
		for(String val : st1) {
			System.out.println(val);
		}
		
		System.out.println("gari".compareTo("amma"));
	}
}
