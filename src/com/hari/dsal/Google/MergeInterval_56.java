package com.hari.dsal.Google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval_56 {

	// Merge with Arrays
	public int[][] merge(int[][] intervals) {

		// Sort array
		Arrays.sort(intervals, (a, b) -> a[0] < b[0] ? -1 : a[0] == b[0] ? 0 : 1);

		List<int[]> tempList = new ArrayList<>();
		int[] prev = intervals[0];

		for (int i = 1; i < intervals.length; i++) {
			int[] curr = intervals[i];

			// OVERLAP ?
			if (isOverlap(prev, curr)) {
				prev[0] = prev[0];
				prev[1] = Math.max(prev[1], curr[1]);
			} else {
				tempList.add(prev);
				prev = curr;
			}
		}

		tempList.add(prev);
		int[][] res = new int[tempList.size()][intervals[0].length];
		int i = 0;

		for (int[] val : tempList) {
			res[i++] = val;
		}
		return res;
	}

	private boolean isOverlap(int[] int1, int[] int2) {
		if (int1[1] >= int2[0])
			return true;
		return false;
	}

	public static void main(String[] args) {
		MergeInterval_56 mi = new MergeInterval_56();
		int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
		for (int valarr[] : mi.merge(intervals)) {
			System.out.println("\n");
			for (int val : valarr) {
				System.out.print(val + " ");
			}
		}
	}
}