package com.hari.dsal.dp;

public class PaintHouse_256 {
	public int minCost(int[][] costs) {

		if (costs.length == 0)
			return 0;
		int min = Integer.MAX_VALUE;
		int[][] memo = new int[costs.length][costs[0].length];
		for (int i = 0; i <= 2; i++) {
			min = Math.min(paintCost(costs, 0, i, memo), min);
		}

		return min;
	}

	public int paintCost(int[][] costs, int n, int color, int[][] memo) {
		if (n == costs.length)
			return 0;

		if (memo[n][color] > 0)
			return memo[n][color];

		int totalCost = costs[n][color];

		if (color == 0) { // Red
			totalCost += Math.min(paintCost(costs, n + 1, 1, memo), paintCost(costs, n + 1, 2, memo));
		} else if (color == 1) { // Blue
			totalCost += Math.min(paintCost(costs, n + 1, 0, memo), paintCost(costs, n + 1, 2, memo));
		} else { // Green
			totalCost += Math.min(paintCost(costs, n + 1, 0, memo), paintCost(costs, n + 1, 1, memo));
		}

		return memo[n][color] = totalCost;
	}

	public static void main(String[] args) {
		int[][] costs = { { 17, 2, 17 }, { 16, 16, 5 }, { 14, 3, 19 } };

		PaintHouse_256 ph = new PaintHouse_256();
		System.out.println(ph.minCost(costs));
	}
}
