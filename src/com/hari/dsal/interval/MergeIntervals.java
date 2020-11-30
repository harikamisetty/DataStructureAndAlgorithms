package com.hari.dsal.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {

	public ArrayList<Interval> merge(List<Interval> intervals) {
		ArrayList<Interval> result = new ArrayList<Interval>();
		if (intervals == null || intervals.size() == 0) {
			return result;
		}

		Collections.sort(intervals, new IntervalComparator());

		Interval prev = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++) {
			Interval curr = intervals.get(i);
			if (isOverlapped(curr, prev)) {
				prev.start = prev.start;
				prev.end = Math.max(curr.end, prev.end);
			} else {
				result.add(prev);
				prev = curr;
			}
		}

		result.add(prev);
		return result;
	}

	private boolean isOverlapped(Interval curr, Interval prev) {
		return curr.start <= prev.end;
	}

	public class IntervalComparator implements Comparator<Interval> {
		public int compare(Interval a, Interval b) {
			return a.start - b.start;
		}
	}

	// Merge with Arrays
	public int[][] merge(int[][] intervals) {

		// Sort array
		sort(intervals);

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

	private void sort(int[][] intervals) {
		List<Interval> temp = new ArrayList<>();

		for (int[] val : intervals) {
			Interval interval = new Interval(val[0], val[1]);
			temp.add(interval);
		}

		Collections.sort(temp, new IntervalComparator());
		int i = 0;
		for (Interval tempi : temp) {
			intervals[i][0] = tempi.start;
			intervals[i][1] = tempi.end;
			i++;
		}
	}

	private boolean isOverlap(int[] int1, int[] int2) {

		if (int1[1] >= int2[0])
			return true;
		return false;
	}

	// Another Solution
	private class IntervalComparator1 implements Comparator<int[]> {
		@Override
		public int compare(int[] a, int[] b) {
			return a[0] < b[0] ? -1 : a[0] == b[0] ? 0 : 1;
		}
	}

	public int[][] merge1(int[][] intervals) {
		Collections.sort(Arrays.asList(intervals), new IntervalComparator1());

		LinkedList<int[]> merged = new LinkedList<>();
		for (int[] interval : intervals) {
			// if the list of merged intervals is empty or if the current
			// interval does not overlap with the previous, simply append it.
			if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
				merged.add(interval);
			}
			// otherwise, there is overlap, so we merge the current and previous
			// intervals.
			else {
				merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
			}
		}

		return merged.toArray(new int[merged.size()][]);
	}

	public static void main(String[] args) {
		Interval int1 = new Interval(1, 4);
		Interval int2 = new Interval(2, 6);
		Interval int3 = new Interval(6, 7);
		Interval int4 = new Interval(7, 9);
		Interval int5 = new Interval(8, 10);
		Interval int6 = new Interval(10, 14);
		Interval int7 = new Interval(11, 14);
		Interval int8 = new Interval(12, 16);
		Interval int9 = new Interval(16, 24);
		Interval int10 = new Interval(20, 24);

		List<Interval> intervalList = Arrays.asList(int1, int2, int3, int4, int5, int6, int7, int8, int9, int10);
		MergeIntervals mi = new MergeIntervals();
		List<Interval> merList = mi.merge(intervalList);

		merList.forEach(e -> System.out.println("(" + e.start + "," + e.end + ")" + "\n"));

		// int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
		int[][] intervals = { { 1, 4 }, { 0, 4 } };
		int[][] res = mi.merge1(intervals);

		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i][0] + "-------" + res[i][1]);
		}
	}
}
