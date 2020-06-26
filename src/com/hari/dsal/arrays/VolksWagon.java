package com.hari.dsal.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VolksWagon {
	
	// Get Combinations
	public void getItemCount(List<List<Integer>> result, List<Integer> temp, int[] nums, int remain, int start) {
		if (remain < 0) {
			return;
		} else if (remain == 0) {
			result.add(new ArrayList<Integer>(temp));
			return;
		} else {
			for (int i = start; i < nums.length; i++) {
				temp.add(nums[i]);
				getItemCount(result, temp, nums, remain - nums[i], i + 1);
				temp.remove(temp.size() - 1);
			}
		}
	}
	
	// From Map to get maximum boxes for truck
	public void getCombinations(int[] nums, Map<Integer, Integer> boxes) {
		Arrays.sort(nums);
		List<List<Integer>> results = new ArrayList<>();
		getItemCount(results, new ArrayList<>(), nums, 5, 0);

		int max = 0;
		for (List<Integer> res : results) {
			int sum = 0;
			for (int val : res) {
				sum = sum + val * boxes.get(val);
			}
			max = Math.max(max, sum);
		}		
		System.out.println(" Max Boxes for Truck : "+ max);
	}
	
	// Two List to Map
	public Map<Integer, Integer> getInputMap(int[] boxes, int[] units){
		
		Map<Integer, Integer> inputMap = new HashMap<>();
		
		for(int i=0; i< boxes.length; i++) {
			inputMap.put(boxes[i], units[i]);			
		}
		return inputMap;
	}

	public static void main(String[] args) {
		VolksWagon vw = new VolksWagon();
		int A[] = { 1, 2, 3, 4 };
		int B[] = { 3, 2, 1, 4 };
		vw.getCombinations(A,vw.getInputMap(A,B));
	}
}
