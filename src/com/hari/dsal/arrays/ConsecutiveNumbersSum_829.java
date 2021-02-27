package com.hari.dsal.arrays;

public class ConsecutiveNumbersSum_829 {
	public int consecutiveNumbersSum(int N) {
		int ans = 1;
		for (int i = 2; i * (i + 1) / 2 <= N; ++i) {
			if ((N - i * (i + 1) / 2) % i == 0)
				++ans;
		}
		return ans;
	}
	public static void main(String[] args) {
		ConsecutiveNumbersSum_829 cn = new ConsecutiveNumbersSum_829();
		System.out.println(cn.consecutiveNumbersSum(5));
	}
}
