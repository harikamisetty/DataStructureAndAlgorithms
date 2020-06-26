package com.hari.dsal.leetcode;

/*
 * 1,2,3 -> 1,3,2
 * 
 * implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * 
 */
public class NextPermutation {

	public static int[] nextPermutation(int[] num) {
		if (num == null || num.length == 0) {
			return null;
		}

		int i, j;
		for (i = num.length - 2; i >= 0; i--) {
			if (num[i] < num[i + 1]) {
				break;
			}
		}

		// for the case where the num[] is in descending order
		if (i >= 0) {
			for (j = i + 1; j < num.length; j++) {
				if (num[j] <= num[i]) {
					break;
				}
			}
			j = j - 1;
			swap(num, i, j);
		}
		reverse(num, i + 1);
		return num;
	}

	private  static void swap(int[] num, int i, int j) {
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}

	private static void reverse(int[] num, int start) {
		int end = num.length - 1;
		while (start < end) {
			int temp = num[start];
			num[start] = num[end];
			num[end] = temp;

			start++;
			end--;
		}
	}

	public static void main(String[] args) {
		
		int[] nums = {123,132,231,312,321,213};
		nextPermutation(nums);
		for(int num: nums) {
			System.out.println(num);
		}
	}

}
