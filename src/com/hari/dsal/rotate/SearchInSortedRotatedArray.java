package com.hari.dsal.rotate;

public class SearchInSortedRotatedArray {

	public static void main(String[] args) {
		SearchInSortedRotatedArray sra = new SearchInSortedRotatedArray();
		int[] a = { 4, 5, 6, 7, 0, 1, 2 };
		int[] B = { 3, 2, 1, 0, 4, 5, 6, 7 };
		int[] C = { 3, 2, 1, 4, 5 };
		int[] D = { 1, 3, 1, 1, 1 };
		System.out.println(sra.getItemPosition(a, 1));
		System.out.println(sra.getItemPosition(B, 2));
		System.out.println(sra.getItemPosition(C, 2));
		System.out.println(sra.getItemPosition(D, 3));

		/*
		 * System.out.println(sra.search(a, 1)); System.out.println(sra.search(B, 2));
		 * System.out.println(sra.search(C, 2));
		 */
		System.out.println(sra.search(D, 3));
	}

	private int getItemPosition(int a[], int target) {

		if (a == null || a.length == 0)
			return -1;
		if (a.length == 1 && a[0] == target) {
			return 0;
		}

		int start = 0, end = a.length - 1;

		while (start <= end) {
			int mid = (start + end) / 2;

			if (a[mid] == target)
				return mid;

			if (a[start] < a[mid]) {
				if (target >= a[start] && target < a[mid]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else {
				if (target > a[mid] && target <= a[end]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
		}
		return -1;
	}

	public boolean search(int[] nums, int target) {

		if (nums == null || nums.length == 0) {
			return false;
		}

		int lo = 0;
		int hi = nums.length - 1;

		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (nums[mid] == target || nums[lo] == target || nums[hi] == target) {
				return true;
			}

			if (nums[lo] <= nums[mid]) {
				if (nums[lo] <= nums[mid] && target < nums[mid]) {
					hi = mid - 1;
				} else if (target >= nums[lo] && target < nums[mid]) {
					hi = mid - 1;
				} else {
					lo = mid + 1;
				}
			} else {
				if (nums[mid] < target && target <= nums[hi]) {
					lo = mid + 1;
				} else {
					hi = mid - 1;
				}
			}
		}
		return false;

	}
}
