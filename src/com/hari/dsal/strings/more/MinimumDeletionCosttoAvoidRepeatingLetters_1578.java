package com.hari.dsal.strings.more;

public class MinimumDeletionCosttoAvoidRepeatingLetters_1578 {
	public int minCost(String s, int[] cost) {
		int res = 0, max_cost = 0, sum_cost = 0, n = s.length();

		for (int i = 0; i < n; ++i) {

			if (i > 0 && s.charAt(i) != s.charAt(i - 1)) {
				res += sum_cost - max_cost;
				sum_cost = max_cost = 0;
			}

			sum_cost += cost[i];
			max_cost = Math.max(max_cost, cost[i]);
		}

		res += sum_cost - max_cost;
		return res;
	}

	public static void main(String[] args) {
		MinimumDeletionCosttoAvoidRepeatingLetters_1578 mdc = new MinimumDeletionCosttoAvoidRepeatingLetters_1578();
		String s = "abaac";
		int[] nums = { 1, 2, 3, 4, 5 };
		System.out.println(mdc.minCost(s, nums));
	}
}
