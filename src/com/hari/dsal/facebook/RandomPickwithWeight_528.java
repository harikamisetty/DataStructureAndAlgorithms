package com.hari.dsal.facebook;

import java.util.Random;

public class RandomPickwithWeight_528 {

	int[] arr;

	public RandomPickwithWeight_528(int[] w) {
		arr = new int[w.length];
		arr = w;
	}

	public int pickIndex() {
		int target = new Random().nextInt(arr[arr.length - 1]);
		int l = 0;
		int r = arr.length;

		while (l < r) {
			int m = l + (r - l) / 2;
			if (arr[m] > target)
				r = m;
			else
				l = m + 1;
		}
		return l;
	}
}