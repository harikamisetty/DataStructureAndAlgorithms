package com.hari.dsal.trees;

public class DiameterOfBinaryTree_543 {
	public static void main(String[] args) {
		DiameterOfBinaryTree_543 dbt = new DiameterOfBinaryTree_543();
		System.out.println(dbt.diameterOfBinaryTree(dbt.initiateTree()));
	}

	private int diameterOfBinaryTree(TreeNode root) {
		depth(root);
		return ans;
	}

	private int ans = 0;

	private int depth(TreeNode node) {
		if (node == null)
			return 0;
		int L = depth(node.left);
		int R = depth(node.right);
		ans = Math.max(ans, L + R + 1);
		return Math.max(L, R) + 1;
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
