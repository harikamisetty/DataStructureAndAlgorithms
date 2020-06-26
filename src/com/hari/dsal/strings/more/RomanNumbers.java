package com.hari.dsal.strings.more;

import java.util.HashMap;
import java.util.Map;

public class RomanNumbers {
	
	 public static int romanToInt(String s) {
		 
	        if (s == null || s.length() == 0) {
	            return 0;
	        }
	        
	        Map<Character, Integer> romanValues = new HashMap<>();
	        romanValues.put('I', 1);
	        romanValues.put('V', 5);
	        romanValues.put('X', 10);
	        romanValues.put('L', 50);
	        romanValues.put('C', 100);
	        romanValues.put('D', 500);
	        romanValues.put('M', 1000);
	        
	        int length = s.length();
	        int result = romanValues.get(s.charAt(length - 1)); // 5
	        
	        for (int i = length - 2; i >= 0; i--) {// XIV from this XI 1 > 5 ---> res = 5 10>1  
	            if (romanValues.get(s.charAt(i)) >= romanValues.get(s.charAt(i + 1))) {
	                result += romanValues.get(s.charAt(i));
	            } else {
	                result -= romanValues.get(s.charAt(i));    
	            }            
	        }
	        System.out.println(" Result .........."+ result);
	        
	        return result;
	    }

	public static void romanToDecimal(java.lang.String romanNumber) {
		int decimal = 0;
		int lastNumber = 0;
		String romanNumeral = romanNumber.toUpperCase();
		/*
		 * operation to be performed on upper cases even if user enters roman values in
		 * lower case chars
		 */
		for (int x = romanNumeral.length() - 1; x >= 0; x--) {
			char convertToDecimal = romanNumeral.charAt(x);

			switch (convertToDecimal) {
			case 'M':
				decimal = processDecimal(1000, lastNumber, decimal);
				lastNumber = 1000;
				break;

			case 'D':
				decimal = processDecimal(500, lastNumber, decimal);
				lastNumber = 500;
				break;

			case 'C':
				decimal = processDecimal(100, lastNumber, decimal);
				lastNumber = 100;
				break;

			case 'L':
				decimal = processDecimal(50, lastNumber, decimal);
				lastNumber = 50;
				break;

			case 'X':
				decimal = processDecimal(10, lastNumber, decimal);
				lastNumber = 10;
				break;

			case 'V':
				decimal = processDecimal(5, lastNumber, decimal);
				lastNumber = 5;
				break;

			case 'I':
				decimal = processDecimal(1, lastNumber, decimal);
				lastNumber = 1;
				break;
			}
		}
		System.out.println(decimal);
	}

	public static int processDecimal(int decimal, int lastNumber, int lastDecimal) {
		if (lastNumber > decimal) {
			return lastDecimal - decimal;
		} else {
			return lastDecimal + decimal;
		}
	}

	public static void main(String args[]) {
		romanToInt("XIV");
	}
}
