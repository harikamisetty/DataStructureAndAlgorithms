package com.hari.dsal.implementations;

import java.util.Iterator;
import java.util.Stack;

public class MaxStack_716 {

	private int max;
	private Stack<Integer> stack;

	/**
	 * initialize your data structure here.
	 */
	public MaxStack_716() {
		max = Integer.MIN_VALUE;
		stack = new Stack<>();
	}

	public void push(int x) {
		if (x > max) {
			max = x;
		}
		stack.push(x);
	}

	public int pop() {
		if (stack.peek() == max) {
			int result = stack.pop();
			max = findMax();
			return result;
		} else {
			return stack.pop();
		}
	}

	private int findMax() {
		if (!stack.isEmpty()) {
			Iterator<Integer> iterator = stack.iterator();
			int max = stack.peek();
			while (iterator.hasNext()) {
				max = Math.max(max, iterator.next());
			}
			return max;
		} else {
			max = Integer.MIN_VALUE;
			return max;
		}
	}

	public int top() {
		return stack.peek();
	}

	public int peekMax() {
		return max;
	}

	public int popMax() {
		Stack<Integer> tmp = new Stack<>();
		int result = 0;
		while (!stack.isEmpty()) {
			if (stack.peek() != max) {
				tmp.push(stack.pop());
			} else {
				result = stack.pop();
				break;
			}
		}
		while (!tmp.isEmpty()) {
			stack.push(tmp.pop());
		}
		max = findMax();
		return result;
	}
	
	public static void main(String[] args) {
		
	}
}
