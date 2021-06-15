package com.hari.dsal.dp;

import com.hari.dsal.trees.TreeNode;

public class HouseRobber_all {
	public int rob_198(int[] nums) {
		final int n = nums.length;
		if (n == 0)
			return 0;
		if (n == 1)
			return nums[0];

		int prev1 = 0; // dp[i - 1]
		int prev2 = 0; // dp[i - 2]

		for (int num : nums) {
			int dp = Math.max(prev1, prev2 + num);
			prev2 = prev1;
			prev1 = dp;
		}

		return prev1;
	}

	/*
	 * So this program is very similar to house robber. All we need to be is to use
	 * same solution as house robber , but 2 times. One from 0->n-2, and second from
	 * 1->n-1. Finally we need to return the max of the two values
	 */
	public int rob_213(int[] nums) {

		if (nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];
		if (nums.length == 2)
			return Math.max(nums[0], nums[1]);
		else {
			int[] dp = new int[nums.length];
			dp[0] = 0;
			dp[1] = nums[0];
			dp[2] = Math.max(nums[0], nums[1]);
			for (int i = 3; i < dp.length; i++) {
				dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
			}

			int max1 = dp[dp.length - 1];

			dp[0] = 0;
			dp[1] = nums[1];
			dp[2] = Math.max(nums[1], nums[2]);
			for (int i = 3; i < dp.length; i++) {
				dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
			}

			return Math.max(dp[dp.length - 1], max1);
		}
	}

	// House Robber 3
	public int[] helper(TreeNode node) {
		// return [rob this node, not rob this node]
		if (node == null) {
			return new int[] { 0, 0 };
		}
		int left[] = helper(node.left);
		int right[] = helper(node.right);
		// if we rob this node, we cannot rob its children
		int rob = node.val + left[1] + right[1];
		// else, we free to choose rob its children or not
		int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

		return new int[] { rob, notRob };
	}

	public int rob_337(TreeNode root) {
		int[] answer = helper(root);
		return Math.max(answer[0], answer[1]);
	}
}
