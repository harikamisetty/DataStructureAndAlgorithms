package com.hari.dsal.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combinations_III {

	private List<List<Integer>> getCombinations(int nums[], int target){

		if(nums==null || nums.length ==0) {
			return null;
		}

		Arrays.sort(nums);
		List<List<Integer>> results = new ArrayList<>();
		int start =0, size =3;
		combinationHelper(results, new ArrayList<Integer>(),size,target,start);
		return results;
	}

	private void combinationHelper(List<List<Integer>> results, ArrayList<Integer> temp, int size, int target,
			int start) {

		if(temp.size() == size && target ==0) {
			results.add(new ArrayList<>(temp));
			return;
		} else {
			for(int i = start; i< 8; i++) {
				temp.add(i);
				combinationHelper(results, temp, size, target-i, i+1);
				temp.remove(temp.size() -1);
			}
		}
	}

	public static void main(String[] args) {
		Combinations_III com = new Combinations_III();
		int[] nums = {1,2,3,4,5,6,1};

		List<List<Integer>> combinations = com.getCombinations(nums, 0);

		combinations.forEach(item -> {
			System.out.println("\n");
			item.forEach(e -> System.out.print(e+ " "));
		});
	}


}
