package com.hari.dsal.facebook;

import java.util.Arrays;

/*
 *  denominations = [1, 5, 10, 25]
    amount = 60
    
    Outout : 3
 * 
 * 
 */
public class MakingChangeSequel {
	
	private int getChange(int []nums, int amount) {
		
		int [] dp = new int[amount+1];
		Arrays.fill(dp, 1,dp.length,amount+1);
		
		for(int coin : nums) {
			for(int i=coin;i<=amount;i++) {
				dp[i] = Math.min(dp[i], dp[i-coin]+1);
			}
		}
		return dp[amount] == amount + 1 ? -1 : dp[amount];
	}
	public static void main(String[] args) {
		MakingChangeSequel mcs = new MakingChangeSequel();
		int[] nums = {1, 5, 10, 25};
		System.out.println(mcs.getChange(nums, 65));
	}
	

}
