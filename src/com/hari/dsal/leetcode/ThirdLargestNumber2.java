package com.hari.dsal.leetcode;

import java.util.Arrays;

public class ThirdLargestNumber2 {
	
	 public static int thirdMax(int[] nums) {
	        int[] temp = Arrays.copyOf(nums, nums.length);;
	        
	        Arrays.sort(nums);
	        int rank = 1;
	        int value = 0;
	        int maxRank = nums.length < 3 ? nums.length : 3;
	        for (int i=0; i<nums.length; i++){
	            if (i> 0 && nums[i] != nums[i-1]){
	                ++rank;
	            }
	            
	            if(rank == maxRank) {
	                value = nums[i];
	                break;
	            }
	        }
	        int res = 1;
	        for(int j=0; j< temp.length; j++){
	            if(j > 0 && temp[j] != temp[j-1]) ++res; 
	            if(temp[j] == value) return res;
	        }
	        return 0;
	    }
	 
	 public static void main(String[] args) {
		 
		int [] a= {2,2,3,1};
		System.out.println(thirdMax(a));
	}

}
