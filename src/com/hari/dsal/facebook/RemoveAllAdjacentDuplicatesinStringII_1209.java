package com.hari.dsal.facebook;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesinStringII_1209 {
	public String solve(String s, int k) {

		StringBuilder sb = new StringBuilder(s);
		Stack<Integer> counts = new Stack<>();
		
		for (int i = 0; i < sb.length(); ++i) {
			if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
				counts.push(1);
			} else {
				int incremented = counts.pop() + 1;
				if (incremented == k) {
					sb.delete(i - k + 1, i + 1);
					i = i - k;
				} else {
					counts.push(incremented);
				}
			}
		}
		return sb.toString();
	}

	public String removeDuplicates(String s, int k) {
		Stack<Integer> counts = new Stack<>();
		char[] sa = s.toCharArray();
		int j = 0;
		for (int i = 0; i < s.length(); ++i, ++j) {
			sa[j] = sa[i];
			if (j == 0 || sa[j] != sa[j - 1]) {
				counts.push(1);
			} else {
				int incremented = counts.pop() + 1;
				if (incremented == k) {
					j = j - k;
				} else {
					counts.push(incremented);
				}
			}
		}
		return new String(sa, 0, j);
	}

	public static void main(String[] args) {
		RemoveAllAdjacentDuplicatesinStringII_1209 drs = new RemoveAllAdjacentDuplicatesinStringII_1209();
		System.out.println(drs.solve("baaabbdddd", 3));
	}
}
