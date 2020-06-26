package com.hari.dsal.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		final int length = num.length;
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		if (length < 3)
			return result;

		// Sort the array
		Arrays.sort(num);

		for (int i = 0; i < length - 2; i++) {
			if (num[i] > 0)
				break;
			if (i == 0 || num[i] > num[i - 1]) {
				int target = 0 - num[i];
				int start = i + 1;
				int end = length - 1;
				while (start < end) {
					if (num[start] + num[end] == target) {
						ArrayList<Integer> elem = new ArrayList<Integer>();
						elem.add(num[i]);
						elem.add(num[start]);
						elem.add(num[end]);

						result.add(elem);
						start++;
						end--;

						// Remove duplicated results
						while (start < end && num[end + 1] == num[end])
							end--;
						while (start < end && num[start - 1] == num[start])
							start++;
					} else if (num[start] + num[end] > target)
						end--;
					else
						start++;
				}
			}
		}
		return result;
	}
}
