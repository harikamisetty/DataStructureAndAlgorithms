package com.hari.dsal.DailyBite;

public class ArrayOperations {

	private boolean isValueExists(int[] arr, int value) {
		int mid = (arr.length-1) /2;
		//Step 1
		int i=mid,j =mid;
		
		while(i!=0 && j!=arr.length-1) {			
			if(arr[i] == value)
				return true;
			if(arr[j]==value)
				return true;
			// Step 2
			j++; i--;
		}		
		return false;
	}
	
	

	public static void main(String[] args) {
		int a[] = { 2, 4, 6, 8, 9, 10, 12, 15, 18, 20 };
		int k = 3;
		
		ArrayOperations ao = new ArrayOperations();
		System.out.println(ao.isValueExists(a, 5));
	}
}
