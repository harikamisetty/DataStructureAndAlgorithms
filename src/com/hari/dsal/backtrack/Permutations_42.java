package com.hari.dsal.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations_42 {

	private List<List<Integer>> getPermutations(int[] input){
		List<List<Integer>> res = new ArrayList<>();
		permutationHelper(res, new ArrayList<Integer>(),input,0);
		return res;
	}

	private void permutationHelper(List<List<Integer>> res, ArrayList<Integer> temp, int[] input, int start) {
		if(start > input.length)
			return;
		if(temp.size() == input.length) {
			res.add(new ArrayList<>(temp));
			return;
		}

		for(int i=0; i <input.length;i++) {
			// element already exists continue
			if(temp.contains(input[i]))
				continue;
			temp.add(input[i]);
			permutationHelper(res, temp, input, i+1);
			temp.remove(temp.size()-1);		}
	}
	public static void main(String[] args) {
		Permutations_42 cs_I = new Permutations_42();
		int[] input = {1,2,3};
		Arrays.sort(input);
		List<List<Integer>> res = cs_I.getPermutations(input);

		res.forEach(val ->{
			System.out.print("[");
			val.forEach(k->{
				System.out.print(k+",");
			});
			System.out.println("]");
		});
	}
}
