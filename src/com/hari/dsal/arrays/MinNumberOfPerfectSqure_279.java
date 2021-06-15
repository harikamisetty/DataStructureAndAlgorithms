package com.hari.dsal.arrays;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class MinNumberOfPerfectSqure_279 {
	
	public int numSquares(int n) {
		return dp(n, new HashMap<>());
	}

	private int dp(int n, Map<Integer, Integer> map) {

		if (n == 0)
			return 0;
		if (n == 1)
			return 1;

		int sqrt = (int) Math.sqrt(n);
		if (sqrt * sqrt == n)
			return 1;

		Integer res = map.get(n);
		if (res != null)
			return res;

		res = Integer.MAX_VALUE;
		for (int i = 1; i <= sqrt; i++) {
			int sq = i * i;
			int tmp = dp(n - sq, map) + 1;
			res = Math.min(res, tmp);
		}

		map.put(n, res);
		return res;
	}

	// Solution #2
	public int numSquares_2(int n) {
		Queue<Integer> queue = new ArrayDeque<>();

		// For memorization
		boolean[] visited = new boolean[n + 1];
		visited[n] = true;

		int steps = 0;
		queue.add(n);

		while (!queue.isEmpty()) {
			steps += 1;
			int size = queue.size();
			for (int i = 0; i < size; ++i) {

				int val = queue.poll();
				
				for (int j = 1; j * j <= val; ++j) {
					int res = val - j * j;

					if (res == 0) { // 8ms Runtime
						return steps;
					}

					if (!visited[res]) {
						queue.add(res);
						visited[res] = true;
					}
				}

			}
		}

		return -1;
	}
	
	public static void main(String[] args) {
		MinNumberOfPerfectSqure_279 mnp = new MinNumberOfPerfectSqure_279();
		System.out.println(mnp.numSquares_2(12));
	}
}
