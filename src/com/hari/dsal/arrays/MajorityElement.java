package com.hari.dsal.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MajorityElement { 

	public List<Integer> majorityelement(int[] nums) {
		List<Integer> res = new ArrayList<>();
		Set<Integer> resSet = new HashSet<>();

		for (int val : nums) {
			if (resSet.contains(val)) {
				res.add(val);
			} else {
				resSet.add(val);
			}
		}
		return res;
	}

	public List<Integer> majorityelement1(int[] nums) {
		List<Integer> res = new ArrayList<>();

		for (int i = 0; i < nums.length; i++) {

			int index = Math.abs(nums[i]) - 1;

			if (nums[index] < 0) {
				res.add(Math.abs(index + 1));
			}
			nums[index] = -nums[index];
		}
		return res;
	}

	public static void main(String[] args) {

		int A[] = {2, 3, 4, 5, 2, 6, 7 };

		MajorityElement majele = new MajorityElement();
		System.out.println(majele.majorityelement(A));

		List<Integer> res = majele.majorityelement1(A);
		for (int val : res) {
			System.out.print(val + ",");
		}
	}
}
