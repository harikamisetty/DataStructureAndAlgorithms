package com.hari.dsal.arrays;

public class SquaresofaSortedArray_977 {
	
	// # TWO Pointer approach
	public int[] sortedSquares(int[] nums) {
		int N = nums.length;
		int j = 0;
		
		// # Find the negative numbers
		while (j < N && nums[j] < 0)
			j++;
		
		int i = j - 1;
		int[] ans = new int[N];
		int t = 0;
		
		// # Arrange Positive and Negative numbers
		while (i >= 0 && j < N) {
			if (nums[i] * nums[i] < nums[j] * nums[j]) {
				ans[t++] = nums[i] * nums[i];
				i--;
			} else {
				ans[t++] = nums[j] * nums[j];
				j++;
			}
		}
		
		// # Still Positive numbers left do the calculation
		while (i >= 0) {
			ans[t++] = nums[i] * nums[i];
			i--;
		}
		
		// # Still Negative numbers left do calculation
		while (j < N) {
			ans[t++] = nums[j] * nums[j];
			j++;
		}
		
		return ans;
	}

	public static void main(String[] args) {
		int a[] = { -4, -1, 0, 3, 10 };

		SquaresofaSortedArray_977 sos = new SquaresofaSortedArray_977();

		for (int val : sos.sortedSquares(a)) {
			System.out.print(val + ",");
		}
	}
}
