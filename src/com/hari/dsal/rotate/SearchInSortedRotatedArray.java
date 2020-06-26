package com.hari.dsal.rotate;

public class SearchInSortedRotatedArray {

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
	
	public static void main(String[] args) {
		SearchInSortedRotatedArray sra = new SearchInSortedRotatedArray();
		int []a = {4,5,6,7,0,1,2};
		int[] B= {3,2,1,0,4,5,6,7};
		int[] C= {3,2,1,4,5};
		System.out.println(sra.getItemPosition(a, 1));
		System.out.println(sra.getItemPosition(B, 2));
		System.out.println(sra.getItemPosition(C, 2));
	}
}
