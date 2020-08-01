package com.hari.dsal.leetcode;

public class FindFirstandLastPositionofElementinSortedArray {
	public static void main(String[] args) {
		FindFirstandLastPositionofElementinSortedArray fma = new FindFirstandLastPositionofElementinSortedArray();
		int[] nums = { 5, 7, 7, 8, 8, 10 };
		int[] res = fma.searchRange(nums, 8);

		for (int val : res)
			System.out.println(val + ",");
	}

	public int[] searchRange(int[] nums, int target) {

		int res[] = { -1, -1 };

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target) {
				if (res[0] == -1) {
					res[0] = i;
				} else {
					res[1] = i;
				}
			}
		}
		if (res[1] == -1 && res[0] != -1)
			res[1] = res[0];
		return res;
	}
}
