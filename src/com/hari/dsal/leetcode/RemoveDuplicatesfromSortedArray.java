package com.hari.dsal.leetcode;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesfromSortedArray {

	public static int removeDuplicates2(int[] nums) {
		Set<Integer> results = new HashSet<>();

		for (int i = 0; i < nums.length; i++) {
			if (!results.contains(nums[i])) {
				results.add(nums[i]);
			}
		}
		return results.size();
	}
	
	public int findDuplicate(int[] nums) {
        if (nums.length < 2) return -1;
        
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        do {
            slow = nums[slow];
            fast = nums[fast];
        } while (slow != fast);
        return slow;
    }
	
	public int findDuplicate2(int[] nums) {
	    int slow = nums[nums[0]];
	    int fast = nums[nums[nums[0]]];

	    while (slow != fast) {
	      slow = nums[slow];
	      fast = nums[nums[fast]];
	    }

	    slow = nums[0];

	    while (slow != fast) {
	      slow = nums[slow];
	      fast = nums[fast];
	    }

	    return slow;
	  }

	public static void main(String[] args) {
		int[] a = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
		int[] b = { 2, 2, 3};
		System.out.println(removeDuplicates2(a));
		RemoveDuplicatesfromSortedArray rd= new RemoveDuplicatesfromSortedArray();
		System.out.println(rd.findDuplicate2(b));
	}
}
