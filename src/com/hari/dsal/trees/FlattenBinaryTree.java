package com.hari.dsal.trees;

import java.util.Stack;

public class FlattenBinaryTree {

	public static void main(String[] args) {
		System.out.println("ZigZag Order traversal of binary tree is");
		FlattenBinaryTree fb = new FlattenBinaryTree();

		fb.flattenTheTreeStack(fb.initiateTree());
		fb.recursiveFlatTree(fb.initiateTree());

	}

	private TreeNode processnode = null;

	private void flattenTheTree(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;

		while (p != null || !stack.empty()) {

			if (p.right != null) {
				stack.push(p.right);
			}

			if (p.left != null) {
				p.right = p.left;
				p.left = null;
			} else if (!stack.empty()) {
				TreeNode temp = stack.pop();
				p.right = temp;
			}

			p = p.right;
		}
	}

	private void flattenTheTreeStack(TreeNode root) {
		flattenTheTree(root);
		TreeBFS pan = new TreeBFS();
		pan.BFT(root);
	}

	private void flatTree(TreeNode root) {
		if (root == null)
			return;
		flatTree(root.right);
		flatTree(root.left);

		root.right = processnode;
		root.left = null;

		processnode = root;
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

	private void recursiveFlatTree(TreeNode root) {
		flatTree(root);
		TreeBFS pan = new TreeBFS();
		pan.BFT(root);
	}
}
