package com.hari.dsal.arrays;

public class FindPivotIndex_724 {
	 public int pivotIndex(int[] nums) {
	        int sum = 0, leftsum = 0;
	        
	        for (int x: nums) 
	        	sum += x;
	        
	        for (int i = 0; i < nums.length; ++i) {
	            if (leftsum == sum - leftsum - nums[i]) 
	            	return i;
	            
	            leftsum += nums[i];
	        }
	        return -1;
	    }
	 
	 public static void main(String[] args) {
		 FindPivotIndex_724 fpi = new FindPivotIndex_724();
		 int[] nums = {1,7,3,6,5,6};
		 System.out.println(fpi.pivotIndex(nums));
	}
}
