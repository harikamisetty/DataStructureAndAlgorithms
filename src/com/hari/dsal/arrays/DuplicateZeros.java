package com.hari.dsal.arrays;

public class DuplicateZeros {
	public void duplicateZeros(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				for (int j = arr.length - 2; j >= i; j--) {
					arr[j + 1] = arr[j];
				}
				i++;
			}
		}

	}
	
	public static void main(String[] args) {
		DuplicateZeros dz = new DuplicateZeros();
		int[] nums = {1,0,2,3,0,4,5,0};
		dz.duplicateZeros(nums);
	}
}
