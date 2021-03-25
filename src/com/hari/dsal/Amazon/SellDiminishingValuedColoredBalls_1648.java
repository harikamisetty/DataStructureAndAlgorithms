package com.hari.dsal.Amazon;

import java.util.Arrays;

public class SellDiminishingValuedColoredBalls_1648 {

	public int maxProfit(int[] inventory, int orders) {
		Arrays.sort(inventory);
		int i = inventory.length - 1;
		int tmp = orders, curr = inventory[i];
		long sum = 0;
		while (tmp > 0) {
			while (i > 0 && inventory[i - 1] == curr) {
				--i;
			}
			int prev = (i == 0 ? 0 : inventory[i - 1]);
			int need = tmp / (inventory.length - i);
			if (need == 0) {
				sum += (long) curr * tmp;
				tmp = 0;
			} else {
				int min = Math.min(need, curr - prev);
				sum += (curr - min + 1L + curr) * min / 2 * (inventory.length - i);
				tmp -= min * (inventory.length - i);
				curr -= min;
			}
		}
		return (int) (sum % 1000000007);
	}
	
	public static void main(String[] args) {
		SellDiminishingValuedColoredBalls_1648 sd = new SellDiminishingValuedColoredBalls_1648();
		
		int[] inventory= {2,5};
		System.out.println(sd.maxProfit(inventory, 4));		
	}
}
