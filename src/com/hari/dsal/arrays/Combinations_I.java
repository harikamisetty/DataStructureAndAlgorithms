package com.hari.dsal.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combinations_I {

	private List<List<Integer>> getCombinations(int nums[], int target){

		if(nums==null || nums.length ==0) {
			return null;
		}

		Arrays.sort(nums);
		List<List<Integer>> results = new ArrayList<>();
		int start =0;
		combinationHelper(results, new ArrayList<Integer>(),nums,target,start);
		return results;
	}

	private void combinationHelper(List<List<Integer>> results, ArrayList<Integer> temp, int[] nums, int target,
			int start) {

		if(target<0) {
			return;
		} else if(target ==0) {
			results.add(new ArrayList<>(temp));
			return;
		} else {
			for(int i = start; i< nums.length; i++) {
				temp.add(nums[i]);
				combinationHelper(results, temp, nums, target-nums[i], i+1);
				temp.remove(temp.size() -1);
			}
		}
	}

	public static void main(String[] args) {
		Combinations_I com = new Combinations_I();
		int[] nums = {1,2,3,4,5,6};

		List<List<Integer>> combinations = com.getCombinations(nums, 8);

		combinations.forEach(item -> {
			System.out.println("\n");
			item.forEach(e -> System.out.print(e+ " "));
		});
	}
}
