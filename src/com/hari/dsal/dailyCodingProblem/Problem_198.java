package com.hari.dsal.dailyCodingProblem;

public class Problem_198 {

	private int subSetWithMaxMod(int []a) {
		if(a == null || a.length == 0) {
			return 0;
		}
		int j=1;
		int arrSize =0;

		for(int i=1; i < a.length; i++) {
			if(a[i]%a[i-1] ==0) {
				j++;
				continue;
			}else {
				arrSize=Math.max(arrSize, j);
				j=1;
			}
		}
		return arrSize;
	}

	public static void main(String[] args) {
		Problem_198 p198 = new Problem_198();
		int[] a = {3,5,10,20,2,4,8,16,32,76};
		System.out.println(p198.subSetWithMaxMod(a));
	}

}
