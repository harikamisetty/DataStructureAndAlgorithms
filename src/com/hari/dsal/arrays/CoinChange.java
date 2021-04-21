package com.hari.dsal.arrays;

import java.util.Arrays;
import java.util.List;

public class CoinChange {
	public int coinChange(int[] coins, int amount) {
		// dp[i] := fewest # of coins to make up i
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, 1, dp.length, amount + 1);

		for (final int coin : coins)
			for (int i = coin; i <= amount; ++i)
				dp[i] = Math.min(dp[i], dp[i - coin] + 1);

		return dp[amount] == amount + 1 ? -1 : dp[amount];
	}
	
	private List<Integer> getCoins(int[] coins, int amount){
		
		//TODO Need to implement
		return null;
	}
	
	public static void main(String[] args) {
		
		CoinChange cc = new CoinChange();
		int [] a= {5,10,25};
		System.out.println(cc.coinChange(a, 15));
	}
}
