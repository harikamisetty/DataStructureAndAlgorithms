package com.hari.dsal.Amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class KClosestPoints_973 {

	public int[][] kClosest(int[][] points, int K) {
		int m = points.length;
		Map<Integer, Double> resList = new HashMap<>();
		int res[][] = new int[K][2];

		for (int i = 0; i < m; i++) {
			int x = (points[i][0] - 0);
			int y = (points[i][1] - 0);
			double d = Math.sqrt((x * x) + (y * y));
			resList.put(i, d);

		}

		LinkedHashMap<Integer, Double> lmap = new LinkedHashMap<>();
		resList.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.forEachOrdered(x -> lmap.put(x.getKey(), x.getValue()));

		List<Entry<Integer, Double>> countList = lmap.entrySet().parallelStream().limit(K).collect(Collectors.toList());
		List<Integer> keys = new ArrayList<>();

		for (Entry<Integer, Double> val : countList) {
			keys.add(val.getKey());
		}

		int j = 0;
		for (int i = 0; i < m; i++) {
			if (keys.contains(i))
				res[j++] = points[i];
		}

		return res;
	}

	// Solution #2
	public int[][] kClosest_1(int[][] points, int K) {
		int[][] ans = new int[K][2];
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> squareDist(b) - squareDist(a));

		for (int[] point : points) {
			pq.offer(point);
			if (pq.size() > K)
				pq.poll();
		}

		int i = K;
		while (!pq.isEmpty())
			ans[--i] = pq.poll();

		return ans;
	}

	private int squareDist(int[] p) {
		return p[0] * p[0] + p[1] * p[1];
	}

	public static void main(String[] args) {
		KClosestPoints_973 kp = new KClosestPoints_973();
		// int[][] points = {{1,3},{-2,2}};
		int[][] points = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
		int res[][] = kp.kClosest_1(points, 2);
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[0].length; j++) {
				System.out.print(res[i][j] + ",");
			}
			System.out.println("\n");
		}
	}
}
