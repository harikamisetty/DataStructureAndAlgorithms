package com.hari.dsal.Google;

import java.util.Map;
import java.util.TreeMap;

public class MyCalendar_I_732 {
	Map<Integer, Integer> timeline = new TreeMap<>();

	public int book(int start, int end) {

		timeline.put(start, timeline.getOrDefault(start, 0) + 1);
		timeline.put(end, timeline.getOrDefault(end, 0) - 1);

		int ans = 0, k = 0;

		for (int count : timeline.values()) {
			ans = Math.max(ans, k += count);
		}
		return ans;
	}
	
	public static void main(String[] args) {
		MyCalendar_I_732 mc = new MyCalendar_I_732();
		mc.book(10, 20);
		mc.book(50, 60);
		mc.book(10, 40);
		mc.book(5, 15);
		mc.book(5, 10);		
	}
}
