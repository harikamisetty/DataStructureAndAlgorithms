package com.hari.dsal.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class IntervalUnion {

	public int[][] solve(int[][] intervals) {
		if (intervals.length == 1)
			return intervals;
		Arrays.sort(intervals, new Comparator<int[]>() {

			@Override
			public int compare(final int[] entry1, final int[] entry2) {

				if (entry1[0] > entry2[0])
					return 1;
				else
					return -1;
			}
		});

		int cStart = intervals[0][0];
		int cEnd = intervals[0][1];
		List<int[]> res = new ArrayList<>();

		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] <= cEnd && intervals[i][1] > cEnd) {
				cEnd = intervals[i][1];
			} else {
				if (intervals[i][1] > cEnd) {
					res.add(new int[] { cStart, cEnd });
					cStart = intervals[i][0];
					cEnd = intervals[i][1];
				}
			}
		}
		res.add(new int[] { cStart, cEnd });
		return res.toArray(new int[res.size()][2]);
	}
	
	public static void main(String[] args) {
		IntervalUnion iu = new IntervalUnion();
		int[][] intervals = {
		                     {0, 5},
		                     {4, 6}
	};
		int[][]res =iu.solve(intervals);
		for(int i=0;i<res.length;i++) {
			for(int j=0;j<res[0].length;j++) {
				System.out.print(res[i][j]);
			}
		}
	}
}
