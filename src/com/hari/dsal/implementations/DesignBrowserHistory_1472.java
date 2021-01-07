package com.hari.dsal.implementations;

import java.util.Stack;

public class DesignBrowserHistory_1472 {

	Stack<String> back = new Stack<>();
	Stack<String> forward = new Stack<>();
	String current;

	public DesignBrowserHistory_1472(String homepage) {
		current = homepage;
	}

	public void visit(String url) {
		forward.clear();
		back.push(current);
		current = url;
	}

	public String back(int steps) {
		while (steps > 0 && back.size() > 0) {
			forward.push(current);
			current = back.pop();
			steps--;
		}
		return current;
	}

	public String forward(int steps) {
		while (steps > 0 && forward.size() > 0) {
			back.push(current);
			current = forward.pop();
			steps--;
		}
		return current;
	}
}
