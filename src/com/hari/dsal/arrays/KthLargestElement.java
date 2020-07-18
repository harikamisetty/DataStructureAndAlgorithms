package com.hari.dsal.arrays;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElement {

	public static void main(String[] args) {
		int A[] = { 2, 5, 1, 78, 56, 45 };
		String[] strs= {"hari","amma","ravi","sujatha","mohan"};
		KthLargestElement ls= new KthLargestElement();
		System.out.println(largestElement(A, 2));
		System.out.println(ls.largestString(strs,2));
	}
	// Ayyays Solution
	private static int largestElement(int[] a, int k) {
		// 1. Method 1 by using the Arrays.sort
		Arrays.sort(a);
		System.out.println(a[a.length - k]);

		// 2. Using PriorityQueue
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
		for (int i : a) {
			q.offer(i);
 
			if (q.size() > k) {
				q.poll();
			}
		}
		return q.peek();
	}
	
	// Strings Solution
	private String largestString(String[] strs, int k) {
		// 1. Method 1 by using the Arrays.sort
				Arrays.sort(strs);
				System.out.println(strs[strs.length - k]);

				// 2. Using PriorityQueue
				PriorityQueue<String> q = new PriorityQueue<>(k);
				for (String i : strs) {
					q.offer(i);
		 
					if (q.size() > k) {
						q.poll();
					}
				}
				return q.peek();
	}
}
