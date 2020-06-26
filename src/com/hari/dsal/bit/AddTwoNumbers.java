package com.hari.dsal.bit;

public class AddTwoNumbers {

	private static void addTwoNumbers(int x, int y) {

		while (y != 0) {
			int carry = x & y;
			x = x ^ y;
			y = (carry << 1);
		}
		System.out.println("Addition Value Is : " + x);

	}

	public static void main(String[] args) {
		addTwoNumbers(20, 30);
		System.out.println(5&7);
	}
}