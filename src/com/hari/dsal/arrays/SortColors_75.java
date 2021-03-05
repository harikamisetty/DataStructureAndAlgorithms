package com.hari.dsal.arrays;

public class SortColors_75 {
	public void sortColors(int[] nums) {
		int l = 0; // next 0 should be put in l
		int r = nums.length - 1; // next 2 should be put in r

		for (int i = 0; i <= r;)
			if (nums[i] == 0)
				swap(nums, i++, l++);
			else if (nums[i] == 1)
				++i;
			else
				// we may swap a 0 to index i, but we're still not sure whether
				// this 0 is put in the correct index, so we can't move pointer i
				swap(nums, i, r--);
	}

	private void swap(int[] nums, int i, int j) {
		final int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public void sortColors_string(String[] strs) {
		int l = 0; // next 0 should be put in l
		int r = strs.length - 1; // next 2 should be put in r
		int i = 0;
		while (i <= r) {
			if (strs[i].equals("red"))
				swap(strs, i++, l++);
			else if (strs[i].equals("green"))
				++i;
			else
				// we may swap a 0 to index i, but we're still not sure whether
				// this 0 is put in the correct index, so we can't move pointer i
				swap(strs, i, r--);
		}

	}

	private void swap(String[] nums, int i, int j) {
		final String temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		SortColors_75 sc = new SortColors_75();
		int[] nums = { 2, 0, 2, 1, 1, 0 };
		String str[] = { "green", "blue", "red", "red" };
		sc.sortColors(nums);
		for (int val : nums) {
			System.out.print(val + ",");
		}
		System.out.println("\n");
		sc.sortColors_string(str);
		for (String val : str) {
			System.out.print(val + ",");
		}
	}
}
