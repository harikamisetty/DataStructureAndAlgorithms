package com.hari.dsal.mislanious;

public class FaceBook {
	
	private int getMinPosition(int[] a) {
		int length = a.length;
		int start =0, end = length -1;
		
		while(start < end) {
			int mid = (start + end) / 2;
			
			if(a[mid]>a[end]) {
				start = mid+1;
			} else if(a[mid]<a[end]) {
				end = mid;
			} else 
				end--;
		}
		return start;
	}
	public static void main(String[] args) {
		int a[] = {4,5,6,7,8,0,1,2,3};
		//int a[] = {40,50,60,70,80,0,10,20,30};
		//int a[] = {0,1,2,3};
		//int a[] = {3,2,1,0};
		//int a[] = {3,2,1,0,1,2,3};
		FaceBook fb = new FaceBook();
		System.out.println(fb.getMinPosition(a));
	}
}
