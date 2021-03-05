package com.hari.dsal.strings;

import java.util.Stack;

public class MinimumRemovetoMakeValidParentheses_1249 {
	public String minRemoveToMakeValid(String s) {
		Stack<Integer> stack = new Stack<>(); // unpaired '(' indicies
		StringBuilder sb = new StringBuilder(s);

		for (int i = 0; i < s.length(); ++i)
			if (sb.charAt(i) == '(') {
				stack.push(i); // record unpaired '(' index
			} else if (sb.charAt(i) == ')') {
				if (stack.isEmpty())
					sb.setCharAt(i, '#'); // mark unpaired ')' as '#'
				else
					stack.pop(); // find a pair!
			}

		// mark unpaired '(' as '#'
		while (!stack.isEmpty())
			sb.setCharAt(stack.pop(), '#');

		return sb.toString().replaceAll("#", "");
	}
	
	public static void main(String[] args) {
		String s = "lee(t(c)o)de)";
		
		MinimumRemovetoMakeValidParentheses_1249 mr = new MinimumRemovetoMakeValidParentheses_1249();
		System.out.println(mr.minRemoveToMakeValid(s));
	}
}
