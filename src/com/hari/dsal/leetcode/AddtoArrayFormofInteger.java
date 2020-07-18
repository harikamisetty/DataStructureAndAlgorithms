package com.hari.dsal.leetcode;

import java.util.ArrayList;
import java.util.List;

public class AddtoArrayFormofInteger {
	public List<Integer> addToArrayForm(int[] A, int K) {
		int i=0;
		long result =0;
		List<Integer> resList = new ArrayList<>();
		
		StringBuilder sb1 = new StringBuilder();
		for(int p =0; p < A.length; p++){
            sb1.append(A[i]);
        }
		
		StringBuilder sb2 = new StringBuilder();
		sb2.append(K);
		
		
		
		/*while(i<A.length) {
			result = result *10 + A[i];
			i++;
		}
		result += K;
		
		while(result>0) {
			resList.add(0,(int)(result % 10));
			result =result / 10;
			
		}*/
		return addTwoStrings(sb1.toString(),sb2.toString());
	}
	
	private List<Integer> addTwoStrings(String s1, String s2) {

		String ts1 = new StringBuilder(s1).reverse().toString();
		String ts2 = new StringBuilder(s2).reverse().toString();

		int lenS1 = s1.length();
		int lenS2 = s2.length();
		int max = lenS1;
		if (lenS1 < lenS2)
			max = lenS2;

		StringBuffer res = new StringBuffer();
		int carry = 0;
		for (int i = 0; i < max; i++) {
			int ints1 = 0;
			if (i < lenS1)
				ints1 = Integer.parseInt(String.valueOf(ts1.charAt(i)));
			int ints2 = 0;
			if (i < lenS2)
				ints2 = Integer.parseInt(String.valueOf(ts2.charAt(i)));
			res.append((ints1 + ints2 + carry) % 10);
			carry = ((ints1 + ints2 + carry) / 10);
		}
		if(carry>0)
			res.append(carry);
		res= res.reverse();
		List<Integer> resList = new ArrayList<>();
		for(int i=0; i < res.length(); i++) {
			resList.add(Integer.parseInt(String.valueOf(res.charAt(i))));
		}
		return resList;
	}
	
	public static void main(String[] args) {
		AddtoArrayFormofInteger aam = new AddtoArrayFormofInteger();
		int A[] = {9,9};
		List<Integer> res = aam.addToArrayForm(A, 99);
		res.forEach(e -> {
			System.out.print(e +",");
		});
	}
}
