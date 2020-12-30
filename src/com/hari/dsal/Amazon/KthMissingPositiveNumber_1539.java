package com.hari.dsal.Amazon;

public class KthMissingPositiveNumber_1539 {
	public int findKthPositive(int[] arr, int k) {
		
		int lo = 0;
		int n = arr.length;
		int hi = n;
		
		while (lo < hi) {
		
			int mid = (lo + hi) / 2;
			
			if (arr[mid] - (mid + 1) >= k) {
				hi = mid;
			} else {
				lo = mid + 1;
			}
		}
		return k + lo;
	}

	public static void main(String[] args) {
		int a[] = { 2, 3, 4, 7, 11 };
		KthMissingPositiveNumber_1539 kp = new KthMissingPositiveNumber_1539();
		System.out.println(kp.findKthPositive(a, 5));
	}
}
