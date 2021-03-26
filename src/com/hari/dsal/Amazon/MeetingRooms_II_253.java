package com.hari.dsal.Amazon;

import java.util.Arrays;

public class MeetingRooms_II_253 {

	public int canAttendMeetings(int[][] intervals) {
		// Check for the base case. If there are no intervals, return 0
		if (intervals.length == 0) {
			return 0;
		}

		Integer[] start = new Integer[intervals.length];
		Integer[] end = new Integer[intervals.length];

		for (int i = 0; i < intervals.length; i++) {
			start[i] = intervals[i][0];
			end[i] = intervals[i][1];
		}

		// Sort the intervals by end time
		Arrays.sort(end,(a,b)->a-b);

		// Sort the intervals by start time
		Arrays.sort(start, (a,b) -> a-b);

		// The two pointers in the algorithm: e_ptr and s_ptr.
		int startPointer = 0, endPointer = 0;

		// Variables to keep track of maximum number of rooms used.
		int usedRooms = 0;

		// Iterate over intervals.
		while (startPointer < intervals.length) {

			// If there is a meeting that has ended by the time the meeting at
			// `start_pointer` starts
			if (start[startPointer] >= end[endPointer]) {
				usedRooms --;
				endPointer ++;
			}

			// We do this irrespective of whether a room frees up or not.
			// If a room got free, then this used_rooms += 1 wouldn't have any effect.
			// used_rooms would
			// remain the same in that case. If no room was free, then this would increase
			// used_rooms
			usedRooms ++;
			startPointer ++;
		}

		return usedRooms;
	}

	public static void main(String[] args) {
		MeetingRooms_II_253 mr = new MeetingRooms_II_253();
		// int[][] intervals = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
		// int[][] intervals = { { 5, 8 }, { 6, 8 } };
		int[][] intervals = { { 2, 15 }, { 4, 9 }, { 9, 29 }, { 16, 23 }, { 36, 45 } };
		System.out.println(mr.canAttendMeetings(intervals));
	}
}