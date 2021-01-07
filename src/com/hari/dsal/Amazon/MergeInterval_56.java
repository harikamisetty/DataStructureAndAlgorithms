package com.hari.dsal.Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeInterval_56 {

	// Merge with Arrays
	public int[][] merge(int[][] intervals) {

		// Sort array
		Collections.sort(Arrays.asList(intervals), new IntervalComparator1());

		List<int[]> tempList = new ArrayList<>();
		int[] prev = intervals[0];

		for (int i = 1; i < intervals.length; i++) {
			int[] curr = intervals[i];

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

	private class IntervalComparator1 implements Comparator<int[]> {
		@Override
		public int compare(int[] a, int[] b) {
			return a[0] < b[0] ? -1 : a[0] == b[0] ? 0 : 1;
		}
	}

	private boolean isOverlap(int[] int1, int[] int2) {
		if (int1[1] >= int2[0])
			return true;
		return false;
	}
	
	// #2 Solution

	public int[][] merge1(int[][] intervals) {
		List<int[]> ans = new ArrayList<>();

		Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));

		for (int[] interval : intervals)
			if (ans.isEmpty() || ans.get(ans.size() - 1)[1] < interval[0])
				ans.add(interval);
			else
				ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], interval[1]);

		return ans.toArray(new int[ans.size()][]);
	}
	
	
	public static void main(String[] args) {
		int [][] intervals = {{1,3},{2,6},{8,10},{15,18}};
		MergeInterval_56 mi = new MergeInterval_56();
		int [][] res = mi.merge1(intervals);
		
		for(int[] val : res) {
			System.out.println("\n");
			for (int value: val) {
				System.out.print(value+",");
			}
		}
	}
}