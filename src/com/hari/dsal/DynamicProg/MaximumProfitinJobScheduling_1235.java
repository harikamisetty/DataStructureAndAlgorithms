package com.hari.dsal.DynamicProg;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

public class MaximumProfitinJobScheduling_1235 {
	public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
		Job[] jobs = new Job[startTime.length];
		
		for (int i = 0; i < jobs.length; i++) {
			jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
		}
		
		Arrays.sort(jobs, Comparator.comparingInt(o -> o.end));
		
		int[] dp = new int[jobs.length];

		for (int i = 0; i < jobs.length; i++) {
			dp[i] = jobs[i].profit;
		}

		for (int i = 1; i < jobs.length; i++) {
			dp[i] = Math.max(dp[i - 1], jobs[i].profit);
			
			for (int j = i - 1; j >= 0; j--)
			
				if (jobs[i].start >= jobs[j].end) {
					dp[i] = Math.max(dp[i], dp[j] + jobs[i].profit);
					break;
				}
		}

		return dp[jobs.length - 1];
	}

	public int jobScheduling_1(int[] startTime, int[] endTime, int[] profit) {
		int n = startTime.length;
		int[][] jobs = new int[n][];
		for (int i = 0; i < n; i++) {
			jobs[i] = new int[] { startTime[i], endTime[i], profit[i] };
		}
		Arrays.sort(jobs, (a, b) -> a[1] - b[1]);
		TreeMap<Integer, Integer> dp = new TreeMap<>();
		dp.put(0, 0);
		int res = 0;
		for (int[] job : jobs) {
			int cur = dp.floorEntry(job[0]).getValue() + job[2];
			if (cur > res) {
				dp.put(job[1], res = cur);
			}
		}
		return res;
	}

	public int jobScheduling_2(int[] startTime, int[] endTime, int[] profit) {
		int n = startTime.length;
		int[][] jobs = new int[n][];
	
		for (int i = 0; i < n; i++) {
			jobs[i] = new int[] { startTime[i], endTime[i], profit[i] };
		}
		
		Arrays.sort(jobs, (a, b) -> a[1] - b[1]);
		
		int[] dp = new int[n + 1];
		
		for (int i = 0; i < n; i++) {
			int l = -1, r = i - 1;
			while (l < r) {
				int m = l + ((r - l + 1) >> 1);
				if (jobs[m][1] <= jobs[i][0]) {
					l = m;
				} else {
					r = m - 1;
				}
			}
			dp[i + 1] = Math.max(dp[i], dp[l + 1] + jobs[i][2]);
		}
		return dp[n];
	}

	public static void main(String[] args) {
		int[] startTime = { 1,2,3,4,6 }, endTime = { 3,5,10,6,9 }, profit = { 20,20,100,70,60 };
		MaximumProfitinJobScheduling_1235 mp = new MaximumProfitinJobScheduling_1235();
		System.out.println(mp.jobScheduling_2(startTime, endTime, profit));
	}
}

class Job {
	int start;
	int end;
	int profit;

	public Job(int start, int end, int profit) {
		this.start = start;
		this.end = end;
		this.profit = profit;
	}
}
