package com.hari.dsal.Amazon;

public class ProductOfArrayExpert_238 {
	public int[] productExceptSelf(int[] nums) {
		int[] res = new int[nums.length];
		res[0] = 1;

		for (int i = 1; i < nums.length; i++) {
			res[i] = res[i - 1] * nums[i - 1];
		}

		int r = 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			res[i] = res[i] * r;
			r = r * nums[i];
		}

		return res;
	}

	public static void main(String[] args) {
		int[] p = { 1, 2, 3, 4 };
		ProductOfArrayExpert_238 poa = new ProductOfArrayExpert_238();
		for (int val : poa.productExceptSelf(p)) {
			System.out.println(val);
		}
	}
}
