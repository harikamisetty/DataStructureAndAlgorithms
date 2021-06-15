package com.hari.dsal.Amazon;

import java.util.ArrayList;
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

	public long prison(int n, int m, int[] h, int[] v) {
		ArrayList<ArrayList<Long>> prison = new ArrayList<ArrayList<Long>>();
		for (int r = 0; r <= n; r++) {
			ArrayList<Long> temp = new ArrayList<Long>();
			for (int c = 0; c <= m; c++) {
				temp.add((long) 1);
			}
			prison.add(temp);
		}

		int[] x = h;
		int xnum = x.length;
		Arrays.sort(x);
		int[] y = v;
		int ynum = y.length;
		Arrays.sort(y);

		// removing bar i means that list at i-1 and at i
		for (int a = xnum - 1; a >= 0; a--) {
			int i = x[a];
			for (int cell = 0; cell < prison.get(i).size(); cell++) {
				prison.get(i).set(cell, prison.get(i).get(cell) + prison.get(i - 1).get(cell));
			}
			prison.remove(i - 1);
		}

		ArrayList<ArrayList<Long>> newprison = new ArrayList<ArrayList<Long>>();

		for (int col = 0; col < prison.get(0).size(); col++) {
			ArrayList<Long> temp = new ArrayList<Long>();
			for (int row = 0; row < prison.size(); row++) {
				temp.add(prison.get(row).get(col));
			}
			newprison.add(temp);
		}

		for (int b = ynum - 1; b >= 0; b--) {
			int i = y[b];
			for (int cell = 0; cell < newprison.get(i).size(); cell++) {
				newprison.get(i).set(cell, newprison.get(i).get(cell) + newprison.get(i - 1).get(cell));
			}
			newprison.remove(i - 1);
		}

		long max = 1;
		for (ArrayList<Long> arr : newprison) {
			for (long num : arr) {
				if (num > max)
					max = num;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		MaximumAreaofaPieceofCakeAfterHorizontalanderticalCuts_1465 mac = new MaximumAreaofaPieceofCakeAfterHorizontalanderticalCuts_1465();
		int[] horizontalCuts = { 1 }, verticalCuts = { 2 };
		System.out.println(mac.maxArea(2, 2, horizontalCuts, verticalCuts));
		System.out.println(mac.prison(2, 2, horizontalCuts, verticalCuts));
	}
}
