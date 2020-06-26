package com.hari.dsal.strings.more;

public class CheckIfStringContainsDigitsOnly {

	public static void main(String[] args) {
		digitsOnlyString("111");
		digitsOnlyString("111a 1");
		digitsOnlyString("111 222");
		digitsOnlyString("111L");

	}

	private static void digitsOnlyString(String string) {
		if(string.matches("\\d+")) System.out.println("Digit Only String ::"+string); // string.matches("\\d+")
		
		try {
			long l = Long.parseLong(string);
			System.out.println("Digit Only String ::"+string);
		}catch(Exception e){
			System.out.println("Non Digit Only String ::"+string);
		}
		
	}

}

