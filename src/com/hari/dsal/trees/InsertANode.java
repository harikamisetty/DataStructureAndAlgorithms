package com.hari.dsal.trees;

public class InsertANode {

	private static Node_I deleteNode_I(Node_I root, int num) {

		if (root == null)
			return null;

		if (num > root.data) {
			root.right = deleteNode_I(root.right, num);
		} else if (num < root.data) {
			root.left = deleteNode_I(root.left, num);

		} else {
			if (root.left == null)
				return root.right;
			if (root.right == null)
				return root.left;

			Node_I minNode_I = findMin(root);
			root.data = minNode_I.data;
			root.right = deleteNode_I(root.right, root.data);
		}
		return root;
	}

	private static Node_I findMin(Node_I root) {

		while (root.left != null) {
			root = root.left;
		}

		return root;
	}

	private static Node_I initiateTree() {

		Node_I root = new Node_I(20);
		root.left = new Node_I(10);
		root.right = new Node_I(30);

		root.left.left = new Node_I(5);
		root.left.right = new Node_I(8);

		root.right.left = new Node_I(25);
		root.right.right = new Node_I(35);

		return root;
	}

	private static void inOrder(Node_I root) {
		if (root != null) {
			inOrder(root.left);
			System.out.println(root.data);
			inOrder(root.right);
		}
	}

	private static Node_I insertNode_I(Node_I root, Integer data) {

		Node_I tmpNode_I = null;
		System.out.print(" ->" + root.data);
		if (root.data >= data) {
			System.out.print(" [L]");
			if (root.left == null) {
				root.left = (new Node_I(data));
				return root.left;
			} else {
				tmpNode_I = root.left;
			}
		} else {
			System.out.print(" [R]");
			if (root.right == null) {
				root.right = (new Node_I(data));
				return root.right;
			} else {
				tmpNode_I = root.right;
			}
		}
		return insertNode_I(tmpNode_I, data);
	}

	public static void main(String[] args) {
		Node_I resNode_I = insertNode_I(initiateTree(), 7);
		inOrder(initiateTree());

		deleteNode_I(initiateTree(), 5);
	}
}
