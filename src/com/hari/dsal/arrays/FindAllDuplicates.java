package com.hari.dsal.arrays;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicates {

	public static void main(String[] args) {
		int A[] = { 4, 3, 2, 7, 8, 2, 3, 1 };
		List<Integer> res = getAllDuplicates(A);
		
		for(int val : res) {
			System.out.println(val);
		}
	}

	private static List<Integer> getAllDuplicates(int[] nums) {
		List<Integer> resList = new ArrayList<>();

		for (int i = 0; i < nums.length; i++) {
			int index = Math.abs(nums[i]) - 1;

			if (nums[index] < 0)
				resList.add(Math.abs(index + 1));

			nums[index] = -nums[index];
		}

		return resList;
	}

}
