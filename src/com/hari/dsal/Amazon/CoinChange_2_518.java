package com.hari.dsal.Amazon;

public class CoinChange_2_518 {

	public int change(int amount, int[] coins) {
		int[] dp = new int[amount + 1];
		dp[0] = 1;

		for (final int coin : coins)
			for (int i = coin; i <= amount; ++i)
				dp[i] += dp[i - coin];

		return dp[amount];
	}

	public static void main(String[] args) {
		int amount = 5;
		int[] coins = { 1, 2, 5 };

		CoinChange_2_518 cc = new CoinChange_2_518();
		System.out.println(cc.change(amount, coins));
	}
}
