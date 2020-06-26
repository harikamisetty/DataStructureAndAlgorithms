package com.hari.dsal.leetcode;

import java.util.Arrays;

public class ThirdMaximumNumber {
	
	public static int thirdMax(int[] nums) {
        int[] temp = Arrays.copyOf(nums, nums.length);;
        
        Arrays.sort(nums);
        int rank = 1;
        int value = 0;
        for (int i=0; i<nums.length; i++){
            if (i> 0 && nums[i] != nums[i-1]){
                ++rank;
            }
            
            if(rank == 3) {
                value = nums[i];
                break;
            }
        }
        
        for(int j=0; j< temp.length; j++){
            if(temp[j] == value) return j+1;
        }
        return 0;
    }
	
	public static void main(String[] args) {
		int [] a= {3,2,1};
		System.out.println(thirdMax(a));
	}

}
