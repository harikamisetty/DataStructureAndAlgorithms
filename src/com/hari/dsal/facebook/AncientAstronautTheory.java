package com.hari.dsal.facebook;

public class AncientAstronautTheory {
	public boolean solve(String dictionary, String s) {

		char[] carr = dictionary.toCharArray();
		int cindex = -1, lindex = -1;
		for (int i = carr.length - 1; i >= 0; i--) {
			cindex = s.lastIndexOf(carr[i]);
			if (i == carr.length - 1)
				lindex = cindex;
			else if (cindex > lindex) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		AncientAstronautTheory aat = new AncientAstronautTheory();
		String dictionary = "acb";
		String s = "aaaa h ccc i bbb";
		System.out.println(aat.solve(dictionary, s));
	}
}
