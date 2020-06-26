package com.hari.dsal.strings;

public class AddTwoStrings {

	// "14" + "8"
	private int addTwoStrings(String s1, String s2) {

		String ts1 = new StringBuilder(s1).reverse().toString();
		String ts2 = new StringBuilder(s2).reverse().toString();

		int lenS1 = s1.length();
		int lenS2 = s2.length();
		int max = lenS1;
		if (lenS1 < lenS2)
			max = lenS2;

		StringBuffer res = new StringBuffer();
		int carry = 0;
		for (int i = 0; i < max; i++) {
			int ints1 = 0;
			if (i < lenS1)
				ints1 = Integer.parseInt(String.valueOf(ts1.charAt(i)));
			int ints2 = 0;
			if (i < lenS2)
				ints2 = Integer.parseInt(String.valueOf(ts2.charAt(i)));
			res.append((ints1 + ints2 + carry) % 10);
			carry = ((ints1 + ints2 + carry) / 10);
		}
		return Integer.parseInt(res.reverse().toString());
	}

	public static void main(String[] args) {
		AddTwoStrings ats = new AddTwoStrings();
		System.out.println(ats.addTwoStrings("80", "133434"));
	}
}
