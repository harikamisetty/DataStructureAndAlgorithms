package com.hari.dsal.linkedlist;

/*
 * Given a binary tree where all the right nodes are either leaf nodes with a sibling 
 * (a left node that shares the same parent node) or empty, flip it upside down and turn it into a tree where the original 
 * right nodes turned into left leaf nodes. Return the new root.
 */

public class BinaryTreeUpsideDown {
	public TreeNode upsideDownBinaryTree(TreeNode root) {
		if (root == null) {
			return null;
		}

		return upsideDownBinaryTreeHelper(root, null);
	}

	private TreeNode upsideDownBinaryTreeHelper(TreeNode root, TreeNode parent) {
		if (root == null) {
			return parent;
		}

		TreeNode newNode = upsideDownBinaryTreeHelper(root.left, root);

		root.left = parent == null ? null : parent.right;
		root.right = parent;

		return newNode;
	}

	// #2
	public static TreeNode upsideDownBinaryTree2(TreeNode root) {
		if (root == null) {
			return null;
		}

		TreeNode parent = null;
		TreeNode parentRightChild = null;
		TreeNode p = root;

		while (p != null) {
			TreeNode next = p.left;
			p.left = parentRightChild;
			parentRightChild = p.right;

			p.right = parent;

			parent = p;
			p = next;
		}

		return parent;
	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(50);
		root.right = new TreeNode(100);
		root.left = new TreeNode(20);

		preOrderData(root);

		TreeNode resNode = upsideDownBinaryTree2(root);

		preOrderData(resNode);
	}

	private static void preOrderData(TreeNode root) {

		if (root == null)
			return;
		preOrderData(root.left);
		System.out.println(root.val);
		preOrderData(root.right);

	}

}
