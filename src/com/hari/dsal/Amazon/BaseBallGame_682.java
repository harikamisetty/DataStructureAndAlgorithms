package com.hari.dsal.Amazon;

import java.util.Stack;

public class BaseBallGame_682 {
	/*
	Input: ops = ["5","2","C","D","+"]
	Output: 30
	Explanation:
	"5" - Add 5 to the record, record is now [5].
	"2" - Add 2 to the record, record is now [5, 2].
	"C" - Invalidate and remove the previous score, record is now [5].
	"D" - Add 2 * 5 = 10 to the record, record is now [5, 10].
	"+" - Add 5 + 10 = 15 to the record, record is now [5, 10, 15].
	The total sum is 5 + 10 + 15 = 30.
*/
	

	public int calPoints(String[] ops) {
		Stack<Integer> stack = new Stack<>();
		int cpop =0;
		for (int i = 0; i < ops.length; i++) {
			if (ops[i].equalsIgnoreCase("+")) {
				int b= stack.pop();
				int a = stack.pop();
				stack.push(a);
				stack.push(b);
				stack.push(a + b);
			} else if (ops[i].equalsIgnoreCase("D")) {
				//stack.push(stack.pop() * stack.peek());
				stack.push(stack.peek() * 2);
			} else if (ops[i].equalsIgnoreCase("C")) {
				if (!stack.isEmpty())
					stack.pop();
			} else {
				if(isInteger(ops[i]))
				stack.push(Integer.parseInt(ops[i]));
			}
		}
		return getTotal(stack);
	}

	private int getTotal(Stack<Integer> stack) {
		int res = 0;
		while (!stack.isEmpty()) {
			res += stack.pop();
		}
		return res;
	}

	public boolean isInteger(String s) {
		if (s == null)
			return false;
		try {
			int in = Integer.parseInt(s);
			return true;

		} catch (Exception ex) {
			return false;
		}
	}

	public static void main(String[] args) {
		BaseBallGame_682 bb = new BaseBallGame_682();
		String[] ops = {"5","2","C","D","+" };
		System.out.println(bb.calPoints(ops));
	}

}
