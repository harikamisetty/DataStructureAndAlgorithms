package com.hari.dsal.facebook;

import java.util.HashMap;
import java.util.Map;

public class DotProductofTwoSparseVectors_1570 {
	 private Map<Integer, Integer> indexToNum = new HashMap<>();
	    
	 DotProductofTwoSparseVectors_1570(int[] nums) {
	    for (int i = 0; i < nums.length; ++i)
	      if (nums[i] != 0)
	        indexToNum.put(i, nums[i]);
	    }
	    
		// Return the dotProduct of two sparse vectors
	    public int dotProduct(DotProductofTwoSparseVectors_1570 vec) {
	       if (indexToNum.size() < vec.indexToNum.size())
	            return vec.dotProduct(this);

	    int ans = 0;

	    for (final int index : vec.indexToNum.keySet())
	      if (indexToNum.containsKey(index))
	        ans += vec.indexToNum.get(index) * indexToNum.get(index);

	    return ans;
	    }
	    
	    public static void main(String[] args) {
	    	int[] nums1= {1,0,0,2,3};
	    	int[] nums2 = {0,3,0,4,0};
	    	
	    	DotProductofTwoSparseVectors_1570 dpt1 = new DotProductofTwoSparseVectors_1570(nums1);
	    	DotProductofTwoSparseVectors_1570 dpt2 = new DotProductofTwoSparseVectors_1570(nums2);
	    	System.out.println(dpt1.dotProduct(dpt2));
		}
}
