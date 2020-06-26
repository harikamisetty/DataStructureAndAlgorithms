package com.hari.dsal.strings;

import java.util.Stack;

public class BasicCalculater {
	public int calculate(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		s = s.trim();
		s = s.replaceAll("[ ]+", "");

		Stack<Integer> numStack = new Stack<>();
		Stack<Character> opStack = new Stack<>();

		int ans = 0;

		int i = 0;
		while (i < s.length()) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				int num = 0;
				while (i < s.length() && Character.isDigit(s.charAt(i))) {
					int digit = Character.getNumericValue(s.charAt(i));
					num = num * 10 + digit;
					i++;
				}
				numStack.push(num);
			} else {
				if (opStack.isEmpty() || c == '(') {
					opStack.push(c);
					i++;
				} else if (c == '*' || c == '/') {
					if (opStack.peek() == '*' || opStack.peek() == '/') {
						compute(numStack, opStack);
					} else {
						opStack.push(c);
						i++;
					}
				} else if (c == '+' || c == '-') {
					compute(numStack, opStack);
				} else if (c == ')') {
					while (!opStack.isEmpty() && opStack.peek() != '(') {
						compute(numStack, opStack);
					}
					opStack.pop();
					i++;
				}
			}
		}

		while (!opStack.isEmpty()) {
			compute(numStack, opStack);
		}

		return numStack.pop();
	}

	private void compute(Stack<Integer> numStack, Stack<Character> opStack) {
		int num2 = numStack.pop();
		int num1 = numStack.pop();

		char op = opStack.pop();

		int ans = 0;

		switch (op) {
		case '+':
			ans = num1 + num2;
			break;
		case '-':
			ans = num1 - num2;
			break;
		case '*':
			ans = num1 * num2;
			break;
		case '/':
			ans = num1 / num2;
			break;
		}

		numStack.push(ans);
	}
	
	public static void main(String[] args) {
		BasicCalculater bc = new BasicCalculater();
		System.out.println(bc.calculate("2*3"));
	}

}
