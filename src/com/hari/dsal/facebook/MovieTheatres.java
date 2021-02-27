package com.hari.dsal.facebook;

import java.util.Arrays;
import java.util.Comparator;

public class MovieTheatres {
	public int solve(int[][] intervals) {

		Integer[] start = new Integer[intervals.length];
		Integer[] end = new Integer[intervals.length];

		for (int i = 0; i < intervals.length; i++) {
			start[i] = intervals[i][0];
			end[i] = intervals[i][1];
		}

		Arrays.sort(start, new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				return a - b;
			}
		});

		Arrays.sort(end, new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				return a - b;
			}
		});

		int startpoint = 0, endpoint = 0, noofrooms = 0;

		while (startpoint < start.length) {

			if (start[startpoint] >= end[endpoint]) {
				noofrooms--;
				endpoint++;
			}
			noofrooms++;
			startpoint++;
		}

		return noofrooms;

	}

	private class intervalComparator implements Comparator<Integer> {
		public int compare(Integer a, Integer b) {
			return a - b;
		}
	}
}
