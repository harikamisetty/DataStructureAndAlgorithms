package com.hari.dsal.arrays;

public class BestTimeToBuySellStock {

	// Best time to buy and Sell
	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length <= 1)
			return 0;
		int min = prices[0]; // min so far
		int result = 0;
		for (int i = 1; i < prices.length; i++) {
			result = Math.max(result, prices[i] - min); // Fiind Max Profit
			min = Math.min(min, prices[i]); // Find the next min
		}
		return result;
	}

	// Each time buy and sell with total profit.
	public static int maxProfit1(int[] prices) {
		if (prices == null || prices.length <= 1)
			return 0;
		int result = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1]) {
				result = result + (prices[i] - prices[i - 1]);
			}
		}
		return result;
	}

	// Find 2 transactions to get more Profit.
	public static int maxProfit2(int[] prices) {

		int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
		int release1 = 0, release2 = 0;

		for (int val : prices) {
			release2 = Math.max(release2, hold2 + val);
			hold2 = Math.max(hold2, release1 - val);

			release1 = Math.max(release1, hold1 + val);
			hold1 = Math.max(hold1, -val);
		}

		return release2;
	}

	public static int maxProfit3(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}

		int[] left = new int[prices.length];
		int[] right = new int[prices.length];

		process(prices, left, right);

		int maxProfit = 0;
		for (int i = 0; i < prices.length; i++) {
			maxProfit = Math.max(maxProfit, left[i] + right[i]);
		}

		return maxProfit;
	}

	private static void process(int[] prices, int[] left, int[] right) {
		// find out the maximal profit from 0 to i
		int min = prices[0];
		for (int i = 1; i < prices.length; i++) {
			left[i] = Math.max(left[i - 1], prices[i] - min);

			min = Math.min(min, prices[i]);
		}

		// Find out the maximal profit from n - 1 to i
		int max = prices[prices.length - 1];
		for (int i = prices.length - 2; i >= 0; i--) {
			right[i] = Math.max(right[i + 1], max - prices[i]);

			max = Math.max(max, prices[i]);
		}
	}

	public static void main(String[] args) {
		int stocks[] = new int[6];
		stocks[0] = 10;
		stocks[1] = 20;
		stocks[2] = 30;
		stocks[3] = 15;
		stocks[4] = 25;
		stocks[5] = 50;
		System.out.println(maxProfit(stocks));
		System.out.println(maxProfit1(stocks));
		System.out.println(maxProfit2(stocks));
		System.out.println(maxProfit3(stocks));
	}
}
