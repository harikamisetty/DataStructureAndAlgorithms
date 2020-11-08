package com.hari.dsal.Salesforce;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TwoSetsNearSum {
	
	// Find middle element and compare with Sum and allocate the numbers to sets
	public static void minSum(List<Integer> set) {
		List<Integer> set1 = new ArrayList<>();
		List<Integer> set2 = new ArrayList<>();

		List<Integer> sortedSet = set.stream().sorted().collect(Collectors.toList());

		int totalSum = sortedSet.stream().mapToInt(Integer::valueOf).sum();
		int halfSum = totalSum / 2;
		// put highest element n set1
		int maxElement = sortedSet.get(sortedSet.size() - 1);
		set1.add(maxElement);

		int s1Sum = maxElement;
		int s2Sum = 0;
		for (int i = sortedSet.size() - 2; i >= 0; i--) {
			int curr = sortedSet.get(i);
			if (s1Sum <= halfSum && s1Sum + curr <= halfSum) {
				set1.add(curr);
				s1Sum += curr;
			} else {
				set2.add(curr);
				s2Sum += curr;
			}
		}

		System.out.println("S1: sum = " + s1Sum);
		System.out.println("S2: sum = " + s2Sum);

	}
}
