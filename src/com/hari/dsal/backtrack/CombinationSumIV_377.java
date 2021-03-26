package com.hari.dsal.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumIV_377 {
    public int combinationSum4(int[] nums, int target) {
        
    	List<List<Integer>> results = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(results, new ArrayList<>(), nums, target,0);
		return results.size();
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start) {
	
		if(remain < 0 || start >= nums.length)
			return;
		else if(remain ==0)
			list.add(new ArrayList<Integer>(tempList));
		else {
			for(int i = 0; i < nums.length; i++) {
				
				tempList.add(nums[i]);
				backtrack(list, tempList, nums, remain - nums[i], i); 
				tempList.remove(tempList.size() - 1); 
			}
		}
	}
	
	 public int combinationSum4_1(int[] nums, int target) {
	        int store[]=new int [target+1];
	        for(int i=0;i<=target;i++){
	                store[i]=-1;
	        }
	        return(dp(nums,target,store));
	    }//combinationSum4
	    public int dp(int nums[],int t,int store[]){
	        if(t==0)
	            return(1);
	        if(t<0)
	            return(0);
	        if(store[t]!=-1)
	            return(store[t]);
	        int ans=0;
	        for(int i=0;i<nums.length;i++){
	            ans=ans+dp(nums,t-nums[i],store);
	        }
	        store[t]=ans;
	        return(store[t]);
	    }//dp 
	
	public static void main(String[] args) {
		//int A[] = {1,2,3};
		int A[] = {4,2,1};
		
		CombinationSumIV_377 cm = new CombinationSumIV_377();
		System.out.println(cm.combinationSum4_1(A, 32));
		
	}
}
