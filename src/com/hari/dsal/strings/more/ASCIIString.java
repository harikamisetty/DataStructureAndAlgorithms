package com.hari.dsal.strings.more;

public class ASCIIString {
	
	public static void main(String[] args) {
		String test = "hello";
		
		for (int i =0; i < test.length(); i++){
			System.out.println(test.charAt(i));
			System.out.println(Integer.valueOf(test.charAt(i)));
			System.out.println(test.charAt(i)- 'a');
		}
	}
}
