package com.hari.dsal.mislanious;

import java.util.Arrays;

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
	}
}
