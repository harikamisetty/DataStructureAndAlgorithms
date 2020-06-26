package com.hari.dsal.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


// Enhanced to remove the reused element from combination
public class CombinationSum_I {

	private List<List<Integer>> getCombinations(int[] input, int target){

		List<List<Integer>> res = new ArrayList<>();
		combinationHelper(res, new ArrayList<Integer>(),input,0,target);
		return res;
	}

	Set<Integer> tempset = new HashSet<>();
	private void combinationHelper(List<List<Integer>> res, ArrayList<Integer> temp, int[] input, int start,
			int target) {
		if(target<0)
			return;
		// && isSetContains(temp,tempset) use only when you don't have duplicates in input
		if(target == 0 && isSetContains(temp,tempset)) {
			res.add(new ArrayList<>(temp));
			return;
		}

		for(int i=start;i<input.length;i++) {
			if(i> start && input[i] == input[i-1])
				continue;
			temp.add(input[i]);
			combinationHelper(res, temp, input, i+1, target-input[i]);
			temp.remove(temp.size()-1);
		}
	}
	private boolean isSetContains(ArrayList<Integer> temp, Set<Integer> tempset) {
		for (int element : temp) {
			if (tempset.contains(element)) {
				return false;
			} else {
				tempset.add(element);
			}
		}
		return true;
	}
	public static void main(String[] args) {
		CombinationSum_I cs_I = new CombinationSum_I();
		int[] input = {2,3,4,5,6,7,9};
		Arrays.sort(input);
		List<List<Integer>> res = cs_I.getCombinations(input, 9);

		res.forEach(val ->{
			System.out.print("[");
			val.forEach(k->{
				System.out.print(k+",");
			});
			System.out.println("]");
		});
	}
}
