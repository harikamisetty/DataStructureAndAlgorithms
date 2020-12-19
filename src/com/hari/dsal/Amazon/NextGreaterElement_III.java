package com.hari.dsal.Amazon;

public class NextGreaterElement_III {

	public int nextGreaterElement(int n) {
		char[] digits = String.valueOf(n).toCharArray();
		int i = digits.length - 2;
		
		while (i >= 0 && digits[i + 1] <= digits[i]) {
			i--;
		}
		if (i < 0) {
			return -1;
		}
		int j = digits.length - 1;
		
		while (j >= 0 && digits[j] <= digits[i]) {
			j--;
		}
		
		swap(digits, i, j);
		reverse(digits, i + 1);
		try {
			return Integer.parseInt(new String(digits));
		} catch (Exception e) {
			return -1;
		}
	}

	private void reverse(char[] a, int start) {
		int i = start;
		int j = a.length - 1;
		while (i < j) {
			swap(a, i, j);
			i++;
			j--;
		}
	}

	private void swap(char[] a, int i, int j) {
		char temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		NextGreaterElement_III nge3 = new NextGreaterElement_III();
		System.out.println(nge3.nextGreaterElement(1234));
	}
}