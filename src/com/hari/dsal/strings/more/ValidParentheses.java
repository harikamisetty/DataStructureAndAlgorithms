package com.hari.dsal.strings.more;

import java.util.Stack;

/*
 * Use java.util.stack to store only opening brackets
 */
public class ValidParentheses {

	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		boolean isValid = false;

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '(' || ch == '{' || ch == '[') {
				stack.push(ch);
			} else {
				if (!stack.isEmpty() && isPair(stack.peek(), ch)) {
					stack.pop();
				} else {
					return false;
				}
			}
		}

		return stack.isEmpty();
	}

	private static boolean isPair(char c1, char c2) {
		return (c1 == '(' && c2 == ')') || (c1 == '{' && c2 == '}') || (c1 == '[' && c2 == ']');
	}

	public static boolean isValid1(String s) {
		if (s == null || s.length() == 0)
			return true;
		if (s.length() == 1)
			return false;
		int i = 0;
		Stack<Character> stack = new Stack<>();

		while (i < s.length()) {
			char var = s.charAt(i);
			if (var == '{' || var == '(' || var == '[') {
				stack.push(var);
			} else {
				if (!stack.empty() && isValid(stack.peek(), var)) {
					stack.pop();
				} else {
					return false;
				}
			}
			i++;
		}
		return stack.empty();
	}

	private static boolean isValid(char c1, char c2) {
		return (c1 == '(' && c2 == ')') || (c1 == '{' && c2 == '}') || (c1 == '[' && c2 == ']');
	}
	
	 public static int divide(int dividend, int divisor) {
	        
	        if(divisor<0 && dividend<0)
	        return Math.abs(dividend / divisor);
	        
	       
	         return (dividend / divisor);
	        
	    }

	public static void main(String[] args) {

		System.out.println(isValid("{{{}}}"));
		System.out.println(isValid1("{{"));
		System.out.println(divide(-2147483648, 1));
	}

}
