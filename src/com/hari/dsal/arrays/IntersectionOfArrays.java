package com.hari.dsal.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IntersectionOfArrays {

	public int[] intersection(int[] nums1, int[] nums2) {
		List<Integer> myList = Arrays.stream(nums1).boxed().collect(Collectors.toList());
		List<Integer> res = new ArrayList<>();

		for (int i = 0; i < nums2.length; i++) {
			if (myList.contains(nums2[i]) && !res.contains(nums2[i])) {
				res.add(nums2[i]);
			}
		}
		return res.stream().mapToInt(Integer::intValue).toArray();
	}
	
	public static void main(String[] args) {
		int a[] = {2,3,4,1}, b[] = {3,4,5,6};
		IntersectionOfArrays ia = new IntersectionOfArrays();
		for(int val : ia.intersection(a, b)) {
			System.out.println(val);
		}
	}
}