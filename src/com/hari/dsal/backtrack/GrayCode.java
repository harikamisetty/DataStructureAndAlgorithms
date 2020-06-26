package com.hari.dsal.backtrack;

import java.util.LinkedList;
import java.util.List;

public class GrayCode {

	private List<Integer> getGrayCode(int n){
		List<Integer> result = new LinkedList<>();
		// 1<<n will get number of combinations
		// G(i) = i ^ (i/2)
		for(int i=0; i < 1<<n; i++) {
			result.add(i ^ i >>1);
		}
		return result;
	}
	public static void main(String[] args) {
		GrayCode gc = new GrayCode();
		List<Integer> res = gc.getGrayCode(2);

		res.forEach(val -> {
			System.out.println(val);
		});
		System.out.println(1<<3);
		System.out.println(2<<1);
	}
}
