package com.hari.dsal.Amazon;

import java.util.Stack;

public class NextGeneraterElementII_503 {
	public int[] nextGreaterElements(int[] nums) {
		int n = nums.length;
		Stack<Integer> stack = new Stack();
		for (int i = n - 1; i >= 0; i--) {
			stack.push(i);
		}

		int[] res = new int[n];
		for (int i = n - 1; i >= 0; i--) {
			res[i] = -1;
			while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
				stack.pop();
			}

			if (!stack.isEmpty())
				res[i] = nums[stack.peek()];
			stack.push(i);
		}
		return res;
	}
	
	public static void main(String[] args) {
		int []a = {1,2,1,3};
		NextGeneraterElementII_503 nge = new NextGeneraterElementII_503();
		for(int val : nge.nextGreaterElements(a)) {
			System.out.println(val);
		}
	}
}
