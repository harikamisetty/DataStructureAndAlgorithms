package com.hari.dsal.Amazon;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum_239 {

	public int[] maxSlidingWindow(int[] nums, int k) {

		int[] ans = new int[nums.length - k + 1];
		Deque<Integer> q = new ArrayDeque<>(); // max queue

		for (int i = 0; i < nums.length; ++i) {
			while (!q.isEmpty() && q.peekLast() < nums[i])
				q.pollLast();
			q.offerLast(nums[i]);
			if (i >= k && nums[i - k] == q.peekFirst()) // out of bound
				q.pollFirst();
			if (i >= k - 1)
				ans[i - k + 1] = q.peekFirst();
		}

		return ans;
	}

	public static void main(String[] args) {
		int[] a = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 3;
		SlidingWindowMaximum_239 swm = new SlidingWindowMaximum_239();
		for (int val : swm.maxSlidingWindow(a, k)) {
			System.out.print(val + ",");
		}
	}
}
