package com.hari.dsal.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MeetingRooms {

	public boolean canAttendMeetings(int[][] intervals) {
		if (intervals.length < 2)
			return true;

		Collections.sort(Arrays.asList(intervals), new IntervalComparator1());

		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] >= intervals[i - 1][1]) {
				continue;
			}
			return false;
		}
		return true;
	}

	private class IntervalComparator1 implements Comparator<int[]> {
		@Override
		public int compare(int[] a, int[] b) {
			return a[0] < b[0] ? -1 : a[0] == b[0] ? 0 : 1;
		}
	}

	public static void main(String[] args) {
		MeetingRooms mr = new MeetingRooms();
		int[][] intervals = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
		System.out.println(mr.canAttendMeetings(intervals));
	}

}
