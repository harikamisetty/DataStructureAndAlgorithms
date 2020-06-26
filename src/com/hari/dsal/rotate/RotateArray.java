package com.hari.dsal.rotate;

public class RotateArray {
	
	private void rotateArray(int a[], int k) {
		
		if(a== null || a.length ==0)
			return;
		if(a.length ==1)
			return;
		
		k %= a.length;
		
		reverse(a,0,a.length-1);
		reverse(a,0,a.length-k-1);
		reverse(a,a.length-k,a.length-1);
	}

	private void reverse(int[] a, int i, int j) {
		
		while(i<j) {
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i++; j--;
		}
	}
	
	public static void main(String[] args) {
		int []a= {1,2,3,4,5,6};
		RotateArray ra = new RotateArray();
		ra.rotateArray(a, 2);
		
		for(int val:a) {
			System.out.print(val+" ");
		}
	}
}
