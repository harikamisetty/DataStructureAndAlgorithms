package com.hari.dsal.bit;

public class BinaryNumberPalindrome {

	static void isBinaryPalindrome(int num) {
		long n1;
		long reverse = 0;
		n1 = num;
		while (n1 > 0) {
			reverse = reverse << 1;
			if ((n1 & 1) == 1)
				reverse = reverse ^ 1;
			n1 = n1 >> 1;
		}
		if (num == reverse) {
			System.out.println("Binary representation of " + num + " is palindrome");
		} else {
			System.out.println("Binary representation of " + num + " is not palindrome");
		}
	}
	
	public static void main(String argc[]) {
		isBinaryPalindrome(5);
	}

}
