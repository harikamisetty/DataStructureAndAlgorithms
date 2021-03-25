package com.hari.dsal.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		final int length = num.length;
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		if (length < 3)
			return result;

		// Sort the array
		Arrays.sort(num);

		for (int i = 0; i < length - 2; i++) {
			if (num[i] > 0)
				break;
			if (i == 0 || num[i] > num[i - 1]) {
				int target = 0 - num[i];
				int start = i + 1;
				int end = length - 1;
				while (start < end) {
					if (num[start] + num[end] == target) {
						ArrayList<Integer> elem = new ArrayList<Integer>();
						elem.add(num[i]);
						elem.add(num[start]);
						elem.add(num[end]);

						result.add(elem);
						start++;
						end--;

						// Remove duplicated results
						while (start < end && num[end + 1] == num[end])
							end--;
						while (start < end && num[start - 1] == num[start])
							start++;
					} else if (num[start] + num[end] > target)
						end--;
					else
						start++;
				}
			}
		}
		return result;
	}
	
public List<List<Integer>> threeSum_BT(int[] nums) {
        
        if(nums == null || nums.length ==0)
            return null;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        
        threeSumHelper(res,temp,nums,0,0);
        return res;
    }
    
   private void threeSumHelper(List<List<Integer>>res,List<Integer> temp,int[] nums,int start,int target){
       
       if(target< 0)
           return;
       
       if(target ==0){
          res.add(new ArrayList<>(temp));// temp.add(nums[start]);
       } else {
           for(int i=start; i< nums.length;i++){
               temp.add(nums[i]);
               threeSumHelper(res,temp,nums,i+1,target+nums[i]);
               temp.remove(temp.size()-1);
           }
       }
       
   }
}
