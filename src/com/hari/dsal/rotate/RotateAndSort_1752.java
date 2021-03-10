package com.hari.dsal.rotate;

public class RotateAndSort_1752 {
	public boolean solve(int[] nums) {
		int res = -1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < nums[i - 1]) {
				res = i;
				break;
			}
		}
		if (res == -1)
			return true;

		for (int i = res + 1; i < nums.length; i++) {
			if (nums[i] < nums[i - 1])
				return false;
		}
		int last = nums[nums.length - 1];
		for (int i = 0; i < res; i++) {
			if (nums[i] < last)
				return false;
			last = nums[i];
		}
		return true;
	}

	public static void main(String[] args) {
		int[] nums = { 4, 1,2, 3 };
		RotateAndSort_1752 ras = new RotateAndSort_1752();
		System.out.println(ras.solve(nums));
	}
}
