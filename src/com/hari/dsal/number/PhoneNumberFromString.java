package com.hari.dsal.number;

public class PhoneNumberFromString {

	public static int getNumber(char uppercaseLetter) {

		char[] letter = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
				'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
		int[] value = { 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 8,8,8,9, 9, 9, 9 };
		for (int i = 0; i < letter.length; i++) {
			if (uppercaseLetter == letter[i])
				return value[i];
		}
		return 0; // <--- shouldn't happen
	}
	
	public static void getNumber1(char letter) {
		 String letters = "XFINITY";
		 
	      String number = letters.replaceAll("[ABCabc]", "2");
	      number = number.replaceAll("[DEFdef]", "3");
	      number = number.replaceAll("[GHIghi]", "4");
	      number = number.replaceAll("[JKLjkl]", "5");
	      number = number.replaceAll("[MNOmno]", "6");
	      number = number.replaceAll("[PQRSpqrs]", "7");
	      number = number.replaceAll("[TUVtuv]", "8");
	      number = number.replaceAll("[WXYZwxyz]", "9");
	 
	      System.out.println(letters);
	      System.out.println(number);
	}
	public static void main(String[] args) {
		String phone = "XFINITY";
		String phoneNumber="";
		
		char numbers[] = phone.toCharArray();
		for(char eachc : numbers) {
			phoneNumber = phoneNumber + String.valueOf(getNumber(eachc));
		}
		System.out.println(phoneNumber);
		getNumber1('h');
		}
}