package com.hari.dsal.trees;

public class DiameterOfBinaryTree {
	public static void main(String[] args) {
		DiameterOfBinaryTree dbt = new DiameterOfBinaryTree();
		System.out.println(dbt.diameterOfBinaryTree(dbt.initiateTree()));
	}

	private int diameterOfBinaryTree(TreeNode root) {
		if (root == null)
			return 0;
		int ldepth = diameterOfBinaryTree(root.left);
		int rdepth = diameterOfBinaryTree(root.right);
		return ldepth + rdepth + 1;
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
}
