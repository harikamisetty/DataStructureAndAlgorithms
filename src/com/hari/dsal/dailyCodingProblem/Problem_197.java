package com.hari.dsal.dailyCodingProblem;

public class Problem_197 {

	private void reverseArray(int[] a, int k) {

		if(a ==null || a.length <= 0) {
			return;
		}
		if(a.length < k)
			return;

		swap(a,0,k);
	}

	private void swap(int[] a, int i, int k) {

		while(k >i) {
			int temp = a[i];
			a[i] = a[k];
			a[k] = temp;
			i ++; k--;
		}
	}

	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7,8,9};
		Problem_197 p197 = new Problem_197();
		p197.reverseArray(a, 4);

		for(int val : a)
			System.out.print(val+",");
	}

}
