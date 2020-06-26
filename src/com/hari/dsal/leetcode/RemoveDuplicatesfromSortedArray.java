package com.hari.dsal.leetcode;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesfromSortedArray {

	public static int removeDuplicates2(int[] nums) {
		Set<Integer> results = new HashSet<>();

		for (int i = 0; i < nums.length; i++) {
			if (!results.contains(nums[i])) {
				results.add(nums[i]);
			}
		}
		return results.size();
	}

	public static void main(String[] args) {
		int[] a = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };

		System.out.println(removeDuplicates2(a));
	}
}
