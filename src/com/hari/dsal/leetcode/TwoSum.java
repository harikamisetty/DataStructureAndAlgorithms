package com.hari.dsal.leetcode;

import java.util.HashMap;

public class TwoSum {
	
	public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
 
        HashMap<Integer, Integer> visited = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (visited.containsKey(target - nums[i])) {
                result[0] = visited.get(target - nums[i]);
                result[1] = i;
                return result;
            }
            visited.put(nums[i], i);
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		int [] a = {2,7,5,6,9};
		int[] res = twoSum(a,9);
		
		for(int i: res) {
			System.out.println(i);
		}
	}
}
