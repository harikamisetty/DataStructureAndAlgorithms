package com.hari.dsal.trees;

public class BalancedBinaryTree_110 {
	public static final int UNBALANCED = -1;
	
	// LOGIC BASED ON HEIGHT OF THE TREE
	private int absHeight(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;

		int left = absHeight(root.left);

		if (left == UNBALANCED)
			return UNBALANCED;
		int right = absHeight(root.right);

		if (right == UNBALANCED)
			return UNBALANCED;

		if (Math.abs(left - right) > 1)
			return UNBALANCED;
		return Math.max(left, right) + 1;
	}

	public boolean isBalanced(TreeNode root) {
		return absHeight(root) != -1;
	}
}
