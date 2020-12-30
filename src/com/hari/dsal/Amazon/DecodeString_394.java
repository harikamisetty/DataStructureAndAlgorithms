package com.hari.dsal.Amazon;

import java.util.Stack;
import javafx.util.Pair;

public class DecodeString_394 {
	public String decodeString(String s) {
		Stack<Pair<StringBuilder, Integer>> stack = new Stack<>(); // (prevStr, repeatCount)
		StringBuilder currStr = new StringBuilder();
		int currNum = 0;

		for (final char c : s.toCharArray())
			if (Character.isDigit(c)) {
				currNum = currNum * 10 + (c - '0');
			} else {
				if (c == '[') {
					stack.push(new Pair<>(currStr, currNum));
					// Initialize new values
					currStr = new StringBuilder();
					currNum = 0;
				} else if (c == ']') {
					final Pair<StringBuilder, Integer> pair = stack.pop();
					final StringBuilder prevStr = pair.getKey();
					final int n = pair.getValue();
					currStr = prevStr.append(getRepeatedStr(currStr, n));
				} else {
					currStr.append(c);
				}
			}

		return currStr.toString();
	}

	// s * n times
	private StringBuilder getRepeatedStr(StringBuilder s, int n) {
		StringBuilder sb = new StringBuilder();
		while (n-- > 0)
			sb.append(s);
		return sb;
	}

	// # Splution #2
	public String decodeString1(String s) {

		Stack<Object> stack = new Stack<Object>();

		int curNum = 0;
		StringBuilder curStr = new StringBuilder();

		for (char ch : s.toCharArray()) {

			if (ch >= '0' && ch <= '9') {
				curNum = curNum * 10 + ch - '0';

				if (curStr.length() > 0) {
					stack.push(curStr);
					curStr = new StringBuilder();
				}
			} else if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
				curStr.append(ch);
			} else if (ch == '[') {
				stack.push(curNum);
				curNum = 0;
			} else if (ch == ']') {

				while (!(stack.peek() instanceof Integer))
					curStr.insert(0, (StringBuilder) stack.pop());

				int k = (int) stack.pop();
				StringBuilder tmp = new StringBuilder(curStr);

				for (int i = 1; i < k; i++)
					tmp.append(curStr);

				stack.push(tmp);
				curStr = new StringBuilder();
			}
		}
		if (curStr.length() != 0)
			stack.push(curStr);

		StringBuilder ans = new StringBuilder();
		while (!stack.isEmpty())
			ans.insert(0, (StringBuilder) stack.pop());
		return ans.toString();
	}

	public static void main(String[] args) {
		String s = "3[a]2[bc]";

		DecodeString_394 ds = new DecodeString_394();
		System.out.println(ds.decodeString(s));
	}
}
