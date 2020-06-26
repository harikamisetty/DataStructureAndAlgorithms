package com.hari.dsal.trees;

public class ValidateBinarySearchTree {
	
	private static void validateBinarySearchTree(TreeNode root) {
		System.out.println(isValidBST(root));
	}

	private static int min = Integer.MIN_VALUE;

	public static boolean isValidBST(TreeNode root) {
		if (root == null)
			return true;

		return inOrderTraverse(root);
	}

	public static boolean inOrderTraverse(TreeNode node) {
		if (node == null)
			return true;

		if (inOrderTraverse(node.left) == false)
			return false;

		if (node.val > min) {
			min = node.val;
		} else
			return false;

		if (inOrderTraverse(node.right) == false)
			return false;

		return true;
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

	public static void main(String[] args) {
		ValidateBinarySearchTree vbst = new ValidateBinarySearchTree();
		vbst.validateBinarySearchTree(vbst.initiateTree());
	}
}
