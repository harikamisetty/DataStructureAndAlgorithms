package com.hari.dsal.arrays;

import java.util.Stack;

public class TrappingRainWater_42 {
	// SOLUTION with STACK
	public int trap(int[] height) {
		Stack<Integer> stack = new Stack<>();
		int ans = 0;
		for (int i = 0; i < height.length; i++) {
			while (!stack.isEmpty() && height[i] >= height[stack.peek()]) {
				int cur = height[stack.pop()];
				if (!stack.isEmpty())
					ans += (i - stack.peek() - 1) * (Math.min(height[i], height[stack.peek()]) - cur);
			}
			stack.push(i);
		}
		return ans;
	}

	// SOLUTION with 2 pointers
	public int trap1(int[] height) {
		int ans = 0, l = 0, r = height.length - 1;
		int barL = 0, barR = 0;
		while (l <= r) {
			barL = Math.max(barL, height[l]);//1
			barR = Math.max(barR, height[r]);//6
			if (barL < barR) // 1 < 6
				ans += barL - height[l++];//ans = 0,1
			else
				ans += barR - height[r--];
		}
		return ans;
	}
	
	public int trap2(int[] height) {
	    int result = 0;
	 
	    if(height==null || height.length<=2)
	        return result;
	 
	    int left[] = new int[height.length];
	    int right[]= new int[height.length];
	 
	    //scan from left to right
	    int max = height[0];
	    left[0] = height[0];
	    for(int i=1; i<height.length; i++){
	        if(height[i]<max){
	            left[i]=max;
	        }else{
	            left[i]=height[i];
	            max = height[i];
	        }
	    }
	 
	    //scan from right to left
	    max = height[height.length-1];
	    right[height.length-1]=height[height.length-1];
	    for(int i=height.length-2; i>=0; i--){
	        if(height[i]<max){
	            right[i]=max;
	        }else{
	            right[i]=height[i];
	            max = height[i];
	        }
	    }
	 
	    //calculate totoal
	    for(int i=0; i<height.length; i++){
	        result+= Math.min(left[i],right[i])-height[i];
	    }
	 
	    return result;
	}

	public static void main(String[] args) {
	int[] A = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		//int[] A = { 1, 2, 3, 4};

		TrappingRainWater_42 tapping = new TrappingRainWater_42();
		System.out.println(tapping.trap1(A));
		System.out.println(tapping.trap2(A));
	}
}
