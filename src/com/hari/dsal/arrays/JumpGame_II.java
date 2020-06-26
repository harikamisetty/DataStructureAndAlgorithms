package com.hari.dsal.arrays;

public class JumpGame_II {

	public int jump2(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
         
        if (A[0] == 0 && A.length > 1) {
            return Integer.MAX_VALUE;
        }
         
        int[] dp = new int[A.length];
         
        // Initialization
        for (int i = 1; i < A.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
         
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] != Integer.MAX_VALUE && A[j] + j >= i) {
                    dp[i] = dp[j] + 1;
                    break;
                }
            }
        }
         
        return dp[A.length - 1];
    }
	
	// BEST Solution
	private int jumpGame_ds(int[] numarr) {
		int e = 0;
		int sc = 0;
		int max = 0;

		for (int i = 0; i < numarr.length-1; i++) {
			max = Math.max(max, i + numarr[i]);
			if (i == e) {
				sc++;
				e = max;
			}
		}
		return sc;
	}

	public static void main(String[] args) {
		int[] jumps = { 2, 3, 1, 1, 4};

		JumpGame_II jump2 = new JumpGame_II();
		System.out.println(jump2.jump2(jumps));
		System.out.println(jump2.jumpGame_ds(jumps));
	}

}
