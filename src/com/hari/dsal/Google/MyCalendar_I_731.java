package com.hari.dsal.Google;

import java.util.ArrayList;
import java.util.List;

public class MyCalendar_I_731 {

	List<int[]> ranges = new ArrayList<>();
	List<int[]> overlaps = new ArrayList<>();

	public boolean book(int start, int end) {
		
		for (int[] overlap : overlaps) {
			if (Math.max(start, overlap[0]) < Math.min(end, overlap[1]))
				return false;
		}

		for (int[] range : ranges) {
			int maxstart = Math.max(start, range[0]);
			int minend = Math.min(end, range[1]);
			if (maxstart < minend)
				overlaps.add(new int[] { maxstart, minend });
		}
		ranges.add(new int[] { start, end });
		return true;
	}
}
