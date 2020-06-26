package com.hari.dsal.rotate;

public class FindMinInRotateArray {

	private int getMinNumber(int a[]) {

		if (a == null || a.length == 0)
			return -1;
		
		if (a.length == 1)
			return a[0];
		
		if (a.length == 2) {
			if (a[0] > a[1])
				return a[1];
			else
				return a[0];
		}
		
		int start = 0, end = a.length - 1;

		while (start <= end) {

			int mid = (start + end) / 2;

			if (a[mid] < a[end]) {
				end = mid;
			} else if (a[mid] >a[start]) {
				start = mid + 1;
			} else {
				end--;
			}
		}
		return a[start];
	}

	public static void main(String[] args) {
				
		int[] A= {1,3,5};
		int[] B= {3,2,1,0,4,5,6,7};
		int[] C= {3,2,1,4,5};
		int[] D= {3,3,1,3};
		int[] E= {1,3,3};
		int[] F= {10,1,10,10,10};
		int[] G= {1,1,1,1};

		FindMinInRotateArray smra = new FindMinInRotateArray();

		System.out.println(smra.getMinNumber(A));
		System.out.println(smra.getMinNumber(B));
		System.out.println(smra.getMinNumber(C));
		System.out.println(smra.getMinNumber(D));
		System.out.println(smra.getMinNumber(E));
		System.out.println(smra.getMinNumber(F));
		System.out.println(smra.getMinNumber(G));
	}

}
