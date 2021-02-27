package com.hari.dsal.brackets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveInvalidParentheses_301 {
	public List<String> removeInvalidParentheses_1(String s) {
		int l = 0, r = 0;
		for (char ch : s.toCharArray())
			if (ch == '(')
				l++;
			else if (ch == ')') {
				if (l > 0)
					l--;
				else
					r++;
			}

		// Backtracking
		Set<String> ans = new HashSet<String>();
		removeHelper(0, l, r, 0, s, new StringBuilder(), ans);
		List<String> rtn = new ArrayList<String>();
		rtn.addAll(ans);

		return rtn;
	}

	private void removeHelper(int index, int l, int r, int open, String s, StringBuilder prefix, Set<String> ans) {
		if (l < 0 || r < 0 || open < 0)
			return;

		if (index == s.length()) {
			if (l + r == 0)
				ans.add(prefix.toString());
			return;
		}

		char ch = s.charAt(index);
		if (ch == '(') {
			removeHelper(index + 1, l - 1, r, open, s, prefix, ans);
			removeHelper(index + 1, l, r, open + 1, s, prefix.append(ch), ans);
		} else if (ch == ')') {
			removeHelper(index + 1, l, r - 1, open, s, prefix, ans);
			removeHelper(index + 1, l, r, open - 1, s, prefix.append(ch), ans);
		} else
			removeHelper(index + 1, l, r, open, s, prefix.append(ch), ans);

		prefix.setLength(prefix.length() - 1);
	}

	public static void main(String[] args) {
		String Input = "(((a)())()";

		RemoveInvalidParentheses_301 rip = new RemoveInvalidParentheses_301();
		for (String res : rip.removeInvalidParentheses(Input)) {
			System.out.println(res);
		}
	}

	// #2 Solution

	public List<String> removeInvalidParentheses(String s) {
		List<String> res = new ArrayList<String>();
		helper(s, 0, 0, res, new char[] { '(', ')' });
		return res;

	}

	private void helper(String s, int left, int right, List<String> res, char[] pars) {

		int stack = 0;
		int n = s.length();

		for (; right < n; right++) {
			char c = s.charAt(right);

			if (c == pars[0]) {
				stack++;
			} else if (c == pars[1]) {
				stack--;
			}

			if (stack < 0)
				break;
		}

		if (stack < 0) {
			for (; left <= right; left++) {
				char c = s.charAt(left);
				if (c == pars[0])
					continue;
				if (left > 1 && s.charAt(left) == s.charAt(left - 1))
					continue;
				helper(s.substring(0, left) + s.substring(left + 1), left, right, res, pars);
			}

		} else if (stack > 0) {
			helper(new StringBuilder(s).reverse().toString(), 0, 0, res, new char[] { ')', '(' });
		} else {
			res.add(pars[0] == '(' ? s : new StringBuilder(s).reverse().toString());
		}
	}
}
