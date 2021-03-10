package com.hari.dsal.mislanious;

public class test {
	
	 public boolean solve(int[] nums) {

	        int countAnomalies = 0,top =0;        
	        for(int i=1;i<nums.length;i++){
	            if(nums[i-1] > nums[i]){
	                countAnomalies++;
	            }
	        }
	        
	        for(int i=nums.length-1;i>0;i--){
	            if(nums[i-1] < nums[i]){
	                top++;
	            }
	        }
	        if(countAnomalies == 0 || top ==0) return true;
	        if(countAnomalies == 1 || top == 1)
	            return true;
	        return false;        
	    }
	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MAX_VALUE+1);
		test t = new test();
		int [] nums = {3,2,1};
		System.out.println(t.solve(nums));
		
	}

}
