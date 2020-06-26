package com.hari.dsal.arrays;

public class ContainerWithMostWater {
	
	public int maxArea(int[] height) {
        if (height == null || height.length <= 1) 
            return 0;
             
        int lo = 0, hi = height.length - 1;
        int max = 0, min = 0; 
         
        while (lo < hi) {
        	min = Math.min(height[lo], height[hi]);
            max = Math.max(max, (hi - lo) * min);
            
            if (height[lo] < height[hi]) 
            	lo++;
            else 
            	hi--;
        }
        return max;
    }
	
	public static void main(String[] args) {
		int A[] = {7,5,3,9};
		ContainerWithMostWater cwmw = new ContainerWithMostWater();
		System.out.println(cwmw.maxArea(A));
		
	}

}
