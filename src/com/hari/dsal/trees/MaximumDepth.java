package com.hari.dsal.trees;

public class MaximumDepth {
	private static int heightOfTree(TreeNode root) {
		if (root == null)
			return -1;

		int leftHeight = heightOfTree(root.left);
		int rightHeight = +heightOfTree(root.right);

		if (leftHeight > rightHeight)
			return leftHeight + 1;
		else
			return rightHeight + 1;
	}
}
