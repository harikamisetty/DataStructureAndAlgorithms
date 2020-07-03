package com.hari.dsal.practice;

import java.util.Stack;

public class InOrderTraversalWithoutRecurtion {

	public static void main(String[] args) {
		InOrderTraversalWithoutRecurtion th = new InOrderTraversalWithoutRecurtion();
		th.printPreOrderTree(th.initiateTree());
		th.printInOrderOrderTree(th.initiateTree());
		// th.printPostOrderTree(th.initiateTree());
		th.postOrderData(th.initiateTree());
	}

	private TreeNode initiateTree() {

		TreeNode root = new TreeNode(20);
		root.left = new TreeNode(10);
		root.right = new TreeNode(30);

		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(8);

		root.right.left = new TreeNode(25);
		root.right.right = new TreeNode(35);

		return root;

	}

	// POSTORDER - LrR
	private void postOrderData(TreeNode root) {

		if (root == null)
			return;
		System.out.println("\n");
		TreeNode curr = root;
		Stack<TreeNode> stack = new Stack<>();

		while (curr != null || !stack.empty()) {
			if (curr != null) {
				stack.add(curr);
				curr = curr.left;
			} else {
				TreeNode temp = stack.peek().right;
				if (temp == null) {
					temp = stack.pop();
					System.out.print(temp.val + " ");

					while (!stack.empty() && temp == stack.peek().right) {
						temp = stack.pop();
						System.out.print(temp.val + " ");
					}
				} else {
					curr = temp;

				}
			}
		}
	}

	// INORDER - LRr
	private void printInOrderOrderTree(TreeNode root) {

		if (root == null) {
			return;
		}
		System.out.println(" \n");
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		TreeNode curr = root;

		while (stack.size() > 0 || curr != null) {

			while (curr != null) {
				stack.add(curr);
				curr = curr.left;
			}

			curr = stack.pop();
			System.out.print(curr.val + " ");
			curr = curr.right;
		}
	}

	// PRE ORder - RLr
	private void printPreOrderTree(TreeNode root) {

		if (root == null)
			return;

		Stack<TreeNode> stack = new Stack<>();
		stack.add(root);

		while (!stack.empty()) {
			TreeNode temp = stack.pop();
			System.out.print(temp.val + ", ");
			if (temp.right != null) {
				stack.add(temp.right);
			}
			if (temp.left != null) {
				stack.push(temp.left);
			}
		}
	}

}
