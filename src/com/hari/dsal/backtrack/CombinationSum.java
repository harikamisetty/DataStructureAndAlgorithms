package com.hari.dsal.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

	public List<List<Integer>> getCombinations(int[] nums, int target) {
		List<List<Integer>> results = new ArrayList<>();
		// SORT
		Arrays.sort(nums);
		backtrack(results, new ArrayList<>(), nums, target, 0);
		return results;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start) {

		if (remain < 0)
			return;
		else if (remain == 0) {
			
			// CREATE NEW ARRAYLIST
			list.add(new ArrayList<Integer>(tempList));
			return;
		} else {
			for (int i = start; i < nums.length; i++) {
				tempList.add(nums[i]);
				backtrack(list, tempList, nums, remain - nums[i], i); // Use i instead of i+1 we can reuse same element.
				tempList.remove(tempList.size() - 1); // Remove last element since it make list more than target
			}
		}
	}

	public static void main(String[] args) {
		int A[] = { 2, 3, 5,2 };

		CombinationSum cm = new CombinationSum();
		List<List<Integer>> results = cm.getCombinations(A, 5);

		for (List<Integer> res : results) {
			System.out.println("\n");
			res.forEach(val -> {
				System.out.print(val + " ");
			});
		}
	}
}
