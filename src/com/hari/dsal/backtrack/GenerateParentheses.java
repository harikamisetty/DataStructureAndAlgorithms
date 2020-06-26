package com.hari.dsal.backtrack;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

	private List<String> generateParentheses(int n) {
		List<String> list = new ArrayList<>();
		backtrack(list, "", n, 0, 0);
		return list;
	}

	private void backtrack(List<String> list, String str, int max, int open, int close) {

		if (str.length() == max * 2) {
			list.add(str);
			return;
		}

		if (open < max)
			backtrack(list, str + "(", max, open + 1, close);
		if(close < open)
			backtrack(list, str + ")", max, open, close + 1);
	}

	public static void main(String[] args) {
		GenerateParentheses gp = new GenerateParentheses();
		List<String> res = gp.generateParentheses(3);
		res.forEach(p-> {
			System.out.print(p);
			System.out.println("\n");
		});
	}
}
