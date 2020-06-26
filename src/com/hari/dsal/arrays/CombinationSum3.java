 package com.hari.dsal.arrays;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
	
	public List<List<Integer>> combinationSum3(int size, int target){
		
		List<List<Integer>> ans = new ArrayList<>();
		combination(ans, new ArrayList<Integer>(), size, 1 , target);
		
		return ans;
	}

	private void combination(List<List<Integer>> ans, ArrayList<Integer> tempList, int size, int start, int target) {
		
		if(tempList.size() == size && target ==0) {			
			List<Integer> li = new ArrayList<Integer>(tempList);
			ans.add(li);
			return;
		}
		
		for(int i = start; i <= 9; i++) {
			tempList.add(i);
			combination(ans, tempList, size, i+1, target -i);
			tempList.remove(tempList.size() - 1);
			
		}
	}
	
	public static void main(String[] args) {
		CombinationSum3 combination = new CombinationSum3();
		List<List<Integer>> results = combination.combinationSum3(3, 9);
		
		for(List<Integer> res:results) {
			System.out.println("\n");
			res.forEach(val -> {
				System.out.print(val+ " ");
			});
		}
	}
}
