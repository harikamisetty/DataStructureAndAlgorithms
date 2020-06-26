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
	
	//Each time buy and sell with total profit.
	public static int maxProfit1(int[] prices) {
		if (prices == null || prices.length <= 1)
			return 0;
		int result =0;
		for (int i = 1; i < prices.length; i++) {
			if(prices[i] > prices[i-1]) {
				result = result + (prices[i] - prices[i-1]);
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
	}
}
