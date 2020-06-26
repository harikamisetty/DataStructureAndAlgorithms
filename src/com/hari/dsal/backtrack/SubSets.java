package com.hari.dsal.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSets {

	private List<List<Integer>> getSubSets(int[] input){
		List<List<Integer>> res = new ArrayList<>();
		subsetCombinations(res, new ArrayList<>(), input,0);
		return res;
	}

	private void subsetCombinations(List<List<Integer>> res, List<Integer> temp, int[] input,int start) {
		// No conditions here since we need to get all combinations.
		res.add(new ArrayList<>(temp));

		for(int i=start; i<input.length; i++) {
			temp.add(input[i]);
			subsetCombinations(res, temp, input, i+1);
			temp.remove(temp.size()-1);
		}
	}
	public static void main(String[] args) {
		SubSets cs_I = new SubSets();
		int[] input = {1,2,3};
		Arrays.sort(input);
		List<List<Integer>> res = cs_I.getSubSets(input);

		res.forEach(val ->{
			System.out.print("[");
			val.forEach(k->{
				System.out.print(k+",");
			});
			System.out.println("]");
		});
	}
}
