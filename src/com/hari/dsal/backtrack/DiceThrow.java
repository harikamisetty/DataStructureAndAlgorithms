package com.hari.dsal.backtrack;

import java.util.ArrayList;
import java.util.List;

public class DiceThrow {
	
	private List<List<Integer>> getPosibilities(int [] nums){
		List<List<Integer>> res = new ArrayList<>();
		diceThrowHelper(res, new ArrayList<>(),nums,0,2,7);
		return res;
	}

	private void diceThrowHelper(List<List<Integer>> res, ArrayList<Integer> list, int[] nums, int start, int length,int target) {
		
		if(list.size() > length || target < 0 || (list.size()>1 && target!=0))
			return;
		
		if(target ==0 && list.size() == 2) {
			res.add(new ArrayList<Integer>(list)); return;
		} else {
			for(int i=start;i<nums.length;i++) {
				list.add(nums[i]);
				diceThrowHelper(res,list,nums,i,length,target-nums[i]);
				list.remove(list.size() -1);
			}
		}		
	}
	
	public static void main(String[] args) {
		DiceThrow dt = new DiceThrow();
		int[] nums = {1,2,3,4,5,6};
		for(List<Integer> valList : dt.getPosibilities(nums)) {
			System.out.println("\n");
			for(int val : valList) {
				System.out.print(val+",");
			}
		}
	}
}
