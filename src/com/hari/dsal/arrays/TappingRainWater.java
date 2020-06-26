package com.hari.dsal.arrays;

public class TappingRainWater {

	public int getTappingRainWater(int[] A) {

		int a = 0, b = A.length - 1, max = 0, leftmax = 0, rightmax = 0;

		while (a <= b) {
			leftmax = Math.max(leftmax, A[a]);
			rightmax = Math.max(rightmax, A[b]);
			if (leftmax < rightmax) {
				max = max + (leftmax - A[b]);
				a++;
			} else {
				max = max + (rightmax + A[b]);
				b--;
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] A= {0,1,0,2,1,0,1,3,2,1,2,1};
		
		TappingRainWater tapping = new TappingRainWater();
		System.out.println(tapping.getTappingRainWater(A));
	}
}
