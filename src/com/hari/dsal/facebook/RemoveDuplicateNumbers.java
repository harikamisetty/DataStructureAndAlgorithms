package com.hari.dsal.facebook;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicateNumbers {
	 public int[] solve(int[] nums) {
         int[] res1 = new int[nums.length];
        if(nums==null)
          return res1;
        if(nums.length ==0)
          return res1;
       List<Integer> res = new ArrayList<>();

       for(int i=0;i<nums.length;i++){
           boolean found = false;
           for(int j=i+1;j<nums.length;j++){
               if(nums[i] == nums[j])
                found =true;
           }
           if(!found)
            res.add(nums[i]);
       }


        return res.stream().mapToInt(Integer::intValue).toArray();
    }
	 
	 public static void main(String[] args) {
		int[] nums = {1, 3, 5, 0, 3, 5, 8};
		RemoveDuplicateNumbers rd = new RemoveDuplicateNumbers();
		for(int val : rd.solve(nums)) {
			System.out.println(val);
		}
	}
}
