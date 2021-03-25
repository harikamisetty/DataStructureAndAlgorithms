package com.hari.dsal.Amazon;

import java.util.Arrays;

public class MaximumAreaofaPieceofCakeAfterHorizontalanderticalCuts_1465 {
	public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
		int start = 0, maxh = 0, maxw = 0;
		// sort the arrays
		Arrays.sort(horizontalCuts);
		Arrays.sort(verticalCuts);

		// find the max space between elements
		for (int i = 0; i < horizontalCuts.length; i++) {
			maxh = Math.max(maxh, horizontalCuts[i] - start);
			start = horizontalCuts[i];
		}
		// this is the space between end of the cake and last element
		maxh = Math.max(maxh, h - start);

		start = 0;
		for (int i = 0; i < verticalCuts.length; i++) {
			maxw = Math.max(maxw, verticalCuts[i] - start);
			start = verticalCuts[i];
		}
		maxw = Math.max(maxw, w - start);

		long res = (long) maxh * (long) maxw;
		res %= (int) 1E9 + 7;
		return (int) res;
	}

	public static void main(String[] args) {
		MaximumAreaofaPieceofCakeAfterHorizontalanderticalCuts_1465 mac = new MaximumAreaofaPieceofCakeAfterHorizontalanderticalCuts_1465();
		int[] horizontalCuts = { 1, 2, 4 }, verticalCuts = { 1, 3 };
		System.out.println(mac.maxArea(5, 4, horizontalCuts, verticalCuts));
	}
}
