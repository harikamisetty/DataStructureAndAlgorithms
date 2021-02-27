package com.hari.dsal.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SumOfTwoNumbers {
	public boolean solve(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return false;

        Set<Integer> tempMap = new HashSet<>();

        for (int val : nums) {
            if (val > k)
                continue;
            if (tempMap.contains(val))
                return true;
            else
                tempMap.add(k - val);
        }
        return false;
    }
	
	
	private boolean hasIt(Set<Integer> tempMap, int i) {
		
		while(tempMap.iterator().hasNext()) {
			int val  = tempMap.iterator().next();
			if(val == i)
				return true;
		}
		
		return false;
	}


	public boolean solve_map(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return false;

        Map<Integer,Integer> tempMap = new HashMap<>();

        for (int val : nums) {
            if (val > k)
                continue;
            if (tempMap.containsKey(k - val))
                return true;
            else
                tempMap.put(k - val,val);
        }
        return false;
    }
	
	public static void main(String[] args) {
		SumOfTwoNumbers sotn = new SumOfTwoNumbers();
		int [] nums = {35, 8, 18, 3, 22};
				int k = 11;
				
				System.out.println(sotn.solve(nums, k));
	}
}
