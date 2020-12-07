package com.hari.dsal.Google;

import java.util.Stack;

public class TappingRainWater_42 {
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

	public static void main(String[] args) {
		//int[] A = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		int[] A = { 1, 0, 2, 0, 1};

		TappingRainWater_42 tapping = new TappingRainWater_42();
		System.out.println(tapping.trap1(A));
		System.out.println(tapping.trap(A));
	}
}
