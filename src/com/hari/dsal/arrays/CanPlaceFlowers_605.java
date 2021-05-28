package com.hari.dsal.arrays;

public class CanPlaceFlowers_605 {
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		if (flowerbed == null || flowerbed.length == 0)
			return true;
		if(n==0)
			return true;
		if (flowerbed.length < n)
			return false;
		if (flowerbed.length == 1 && flowerbed[0] == 0 && n == 1)
			return true;
		if (flowerbed.length == 2 && (flowerbed[0] == 1 || flowerbed[1] == 1))
			return false;

		for (int i = 0; i < flowerbed.length; i++) {
			if (n == 0)
				return true;
			if (i == 0 && flowerbed[0] == 0 && flowerbed[1] == 0) {
				flowerbed[0] = 1;
				n--;
				continue;
			}
			if (i == flowerbed.length - 1 && flowerbed[flowerbed.length - 1] == 0
					&& flowerbed[flowerbed.length - 2] == 0) {
				flowerbed[flowerbed.length - 1] = 1;
				n--;
				continue;
			}

			if (i>0 && flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
				flowerbed[i] = 1;
				n--;
				continue;
			}
		}
		return n == 0 ? true : false;
	}
	
	public static void main(String[] args) {
		CanPlaceFlowers_605 cpf = new CanPlaceFlowers_605();
		int[] nums = {0,1,0}; int n =1;
		System.out.println(cpf.canPlaceFlowers(nums, n));
	}
}
