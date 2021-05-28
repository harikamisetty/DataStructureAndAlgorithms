package com.hari.dsal.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LNumber_386 {
	public List<Integer> lexicalOrder(int n) {
		List<Integer> ans = new ArrayList<>();
		int curr = 1;

		while (ans.size() < n) {
			ans.add(curr);

			if (curr * 10 <= n) {
				curr *= 10;

			} else {
				while (curr % 10 == 9 || curr == n)
					curr /= 10;
				++curr;
			}
		}

		return ans;
	}
	// Solution 2 with Strings
	public int[] solve(int n) {
		int[] res = new int[n];
		List<String> s = new ArrayList<String>();

		for (int i = 1; i <= n; i++) {
			s.add(String.valueOf(i));
		}

		Collections.sort(s);
		List<Integer> ans = new ArrayList<Integer>();
		for (int i = 0; i < n; i++)
			ans.add(Integer.valueOf(s.get(i)));

		for (int i = 0; i < n; i++)
			res[i] = ans.get(i);
		return res;
	}

	public static void main(String[] args) {
		LNumber_386 ln = new LNumber_386();
		List<Integer> list = ln.lexicalOrder(12);
	}
}
