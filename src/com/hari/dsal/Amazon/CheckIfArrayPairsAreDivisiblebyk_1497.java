package com.hari.dsal.Amazon;

public class CheckIfArrayPairsAreDivisiblebyk_1497 {
	public int solve(int[] nums, int k) {
		
		int freq[] = new int[k];
		
		for (int i = 0; i < nums.length; i++)
			++freq[nums[i] % k];

		int sum = freq[0] * (freq[0] - 1) / 2;
		
		for (int i = 1; i <= k / 2 && i != (k - i); i++)
			sum += freq[i] * freq[k - i];

		if (k % 2 == 0)
			sum += freq[k / 2] * (freq[k / 2] - 1) / 2;
		
		return sum;
	}

	public boolean canArrange(int[] arr, int k) {
		int nrr[] = new int[k];
		for (int i = 0; i < arr.length; i++) {
			int rem = arr[i] % k;
			if (rem < 0)
				rem += k;
			nrr[rem]++;
		}
		if (nrr[0] % 2 != 0)
			return (false);
		for (int i = 1; i < k; i++) {
			if (nrr[i] != nrr[k - i])
				return (false);
		}
		return (true);
	}
	
	public static void main(String[] args) {
		int arr[] = {2, 4, 5, 1, 2};
		CheckIfArrayPairsAreDivisiblebyk_1497 cp = new CheckIfArrayPairsAreDivisiblebyk_1497();
		System.out.println(cp.solve(arr, 6));
		System.out.println(cp.canArrange(arr, 6));
		
		System.out.println();
	}
}
