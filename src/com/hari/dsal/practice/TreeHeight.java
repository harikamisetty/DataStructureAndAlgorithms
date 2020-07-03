package com.hari.dsal.practice;

public class TreeHeight {

	public static void main(String[] args) {
		TreeHeight th = new TreeHeight();
		System.out.println(th.getTreeHeight(th.initiateTree()));
	}

	private int getTreeHeight(TreeNode initiateTree) {

		if (initiateTree.left == null && initiateTree.right == null)
			return 0;
		int left = getTreeHeight(initiateTree.left);
		int right = getTreeHeight(initiateTree.right);

		if (left > right)
			return right + 1;
		else
			return left + 1;
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
