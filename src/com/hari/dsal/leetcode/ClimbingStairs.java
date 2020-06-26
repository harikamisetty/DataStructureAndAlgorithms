package com.hari.dsal.leetcode;

// Formula n Stairs = array(n-2) + array(n-1)

public class ClimbingStairs {
	
	public static int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        
        int[] ways = new int[n + 1];
        ways[0] = 1;
        ways[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            ways[i] = ways[i - 2] + ways[i - 1];
            System.out.println("Ways for i..........."+i+"="+ ways[i]);
        }
        System.out.println("Ways are like ..........."+ ways[n]);
        return ways[n];
    }
	
	public static void main(String[] args) {
		climbStairs(10);
		
	}

}
