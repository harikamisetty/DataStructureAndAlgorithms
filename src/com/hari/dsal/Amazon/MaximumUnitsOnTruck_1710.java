package com.hari.dsal.Amazon;

import java.util.Arrays;

public class MaximumUnitsOnTruck_1710 {
	public int maximumUnits(int[][] boxTypes, int truckSize) {

		Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
		
		int count = 0;
		for (int[] boxtype : boxTypes) {
			int boxCount = Math.min(truckSize, boxtype[0]);
			count = count + boxCount * boxtype[1];
			truckSize = truckSize - boxCount;

			if (truckSize == 0)
				break;
		}
		return count;
	}

	public static void main(String[] args) {
		MaximumUnitsOnTruck_1710 mu = new MaximumUnitsOnTruck_1710();
		int[][] boxTypes = { { 1, 3 }, { 2, 2 }, { 3, 1 } };
		int truckSize = 4;

		System.out.println(mu.maximumUnits(boxTypes, truckSize));
	}
}
