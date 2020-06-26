package com.hari.dsal.strings.more;

import java.util.HashSet;
import java.util.Set;

public class DuplicateNumbers {

	public static void main(String[] args) {
		int a[] = { 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 10 };
		System.out.println(isArrayHasDuplicates(a));
	}

	private static boolean isArrayHasDuplicates(int[] a) {

		Set<Integer> duplicatesSet = new HashSet<Integer>();
		for (int i = 0; i < a.length; i++) {
			if (duplicatesSet.contains(a[i]))
				return true;
			duplicatesSet.add(a[i]);
		}
		return false;
	}

}
