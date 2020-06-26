package com.hari.dsal.strings;

public class MultiplyStrings {

	public String multiply(String num1, String num2) {
		if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) {
			return "";
		}

		if (num1.equals("0") || num2.equals("0")) {
			return "0";
		}

		StringBuilder sb = new StringBuilder();
		int paddle = 0;

		for (int i = num1.length() - 1; i >= 0; i--) {
			StringBuilder temp = new StringBuilder();
			int carry = 0;
			for (int j = num2.length() - 1; j >= 0; j--) {
				carry += toNum(num1.charAt(i)) * toNum(num2.charAt(j));
				temp.insert(0, toChar(carry % 10));
				carry /= 10;
			}

			if (carry != 0) {
				temp.insert(0, toChar(carry));
			}

			if (sb.length() == 0) {
				sb.append(temp);
			} else {
				sb = new StringBuilder(addTwoStrings(sb, temp, ++paddle));
			}
		}

		return sb.toString();
	}

	private int toNum(char a) {
		return Character.getNumericValue(a);
	}

	private char toChar(int a) {
		return (char) (a + '0');
	}

	private StringBuilder addTwoStrings(StringBuilder str1, StringBuilder str2, int paddle) {
		for (int i = 0; i < paddle; i++) {
			str2.append("0");
		}

		// add integers of two strings
		int i = str1.length() - 1;
		int j = str2.length() - 1;

		int carry = 0;
		StringBuilder result = new StringBuilder();
		while (i >= 0 || j >= 0) {
			if (i >= 0) {
				carry += toNum(str1.charAt(i));
				i--;
			}

			if (j >= 0) {
				carry += toNum(str2.charAt(j));
				j--;
			}

			result.insert(0, toChar(carry % 10));
			carry /= 10;
		}

		if (carry != 0) {
			result.insert(0, toChar(carry));
		}

		return result;
	}
	
	public static void main(String[] args) {
		String str1 = "12";
		String str2 = "10";
		
		MultiplyStrings ms = new MultiplyStrings();
		System.out.println(ms.multiply(str1, str2));
				
	}

}
