package com.hari.dsal.mislanious;

public class SubArrayForAGivenSum {
	
	public static void main(String[] args) {
		
		int A[] = {2,3,4,6,8,11};
		
		System.out.println(arraySequence(A, 10));	
	}

	private static int arraySequence(int[] a, int target) {
		
		if(a==null && a.length == 0) return 0;
		
		int results=0;
		for(int i=0; i<a.length; i++) {
			
			if(a[i] == target) return 1;
			int sum = a[i];
			for(int j= i+1; j<a.length; j++) {
				sum = sum + a[j];
				if(sum == target) {
					results = Math.max(results, j-i+1);
				} else if(sum > target) break;
			}
		}
		return results;
	}
}
