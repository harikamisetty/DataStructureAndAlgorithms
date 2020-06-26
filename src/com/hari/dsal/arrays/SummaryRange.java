package com.hari.dsal.arrays;

import java.util.ArrayList;
import java.util.List;

public class SummaryRange {

	public static List<String> getranges(int[] a) {
		int length = a.length;
		List<String> list = new ArrayList<>();
		if (length == 1) {
			list.add(a[0] + "");
			return list;
		}

		for (int i = 0; i < length; i++) {
			int b = a[i];

			while (i + 1 < length && (a[i + 1] - a[i]) == 1) {
				i++;
			}

			if (b != a[i]) {
				list.add(b + "->" + a[i]);
			} else { 
				list.add(b + "");
			}
		}

		return list;
	}
	
	public static void main(String[] args) {
		
		int A[] = {1,2,3,5,6,8,9};
		
		List<String> results = getranges(A);
		
		for(String val: results) {
			System.out.println(val);
		}
	}

}
