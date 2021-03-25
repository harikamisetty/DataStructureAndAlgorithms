package com.hari.dsal.arrays;

import java.util.Arrays;

public class TaskSchedule_621 {
	public int leastInterval(char[] tasks, int n) {

		int[] count = new int[26];

		for (char task : tasks) {
			++count[task - 'A'];
		}

		int maxFreq = Arrays.stream(count).max().getAsInt();
		int maxTaskOccupy = (maxFreq - 1) * (n + 1);
		int nMaxFreq = (int) Arrays.stream(count).filter(c -> c == maxFreq).count();

		return Math.max(maxTaskOccupy + nMaxFreq, tasks.length);
	}

	public static void main(String[] args) {
		TaskSchedule_621 ts = new TaskSchedule_621();
		char[] tasks = { 'A', 'A', 'A', 'B', 'B', 'B' };
		System.out.println(ts.leastInterval(tasks, 2));
	}
}
