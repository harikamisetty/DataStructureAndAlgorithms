package com.hari.dsal.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSets {
	
	public List<List<Integer>> subSets(int[] nums){
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(list, new ArrayList<>(), nums, 0);
		return list;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
		
		list.add(new ArrayList<>(tempList)); // Add to final List
		
		for(int i= start; i< nums.length; i++) {
			tempList.add(nums[i]);
			backtrack(list, tempList, nums, i+1);
			tempList.remove(tempList.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		SubSets subset = new SubSets();
		int[] A = {1,2,3};
		List<List<Integer>> results = subset.subSets(A);
		
		for(List<Integer> res:results) {
			System.out.println("\n");
			res.forEach(val -> {
				System.out.print(val+ " ");
			});
		}
	}
}
