package com.hari.dsal.arrays;

import java.util.Arrays;

public class IncreaseSize {

	public int solve(int[] nums) {

		if (nums.length == 0)
			return 0;

		// dp[i] := length of LIS ending at nums[i]
		int[] dp = new int[nums.length];
		Arrays.fill(dp, 1);

		for (int i = 1; i < nums.length; ++i)
			for (int j = 0; j < i; ++j)
				if (nums[j] < nums[i])
					dp[i] = Math.max(dp[i], dp[j] + 1);

		return Arrays.stream(dp).max().getAsInt();
	}

	public static void main(String[] args) {
		IncreaseSize is = new IncreaseSize();
		int[] nums = { 6, 1, 7, 2, 8, 3, 4, 5 };
		System.out.println(is.solve(nums));
	}

}
