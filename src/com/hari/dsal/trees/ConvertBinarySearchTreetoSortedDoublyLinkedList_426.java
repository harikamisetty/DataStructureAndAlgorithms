package com.hari.dsal.trees;

import java.util.Stack;

public class ConvertBinarySearchTreetoSortedDoublyLinkedList_426 {
	
	public Node_I treeToDoublyList(Node_I root) {
		if (root == null)
			return null;

		Stack<Node_I> stack = new Stack<>();
		Node_I first = null, pred = null;

		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}

			root = stack.pop();
			if (first == null)
				first = root;
			if (pred != null) {
				pred.right = root;
				root.left = pred;
			}

			pred = root;
			root = root.right;
		}

		pred.right = first;
		first.left = pred;

		return first;
	}
}
