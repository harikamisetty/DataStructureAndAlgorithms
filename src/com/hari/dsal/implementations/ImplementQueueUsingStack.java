package com.hari.dsal.implementations;

import java.util.Stack;

public class ImplementQueueUsingStack {
	Stack<Integer> input = new Stack<>();
	Stack<Integer> output = new Stack<>();
	
	public void push(int x) {
		input.push(x);
	}
	
	public void pop() {
		peek();
		System.out.println(output.pop());
	}
	
	public int peek() {
		if (output.empty()) {
			while (!input.empty()) {
				output.push(input.pop());
			}
		}
		return output.peek();
	}
	
	public boolean empty() {
		return input.empty() && output.empty();
	}
	
	public static void main(String[] args) {
		ImplementQueueUsingStack iqs = new ImplementQueueUsingStack();
		iqs.push(10);
		iqs.push(20);
		iqs.push(30);
		iqs.push(40);
		iqs.push(50);
		iqs.pop();
		iqs.pop();
	}

}
