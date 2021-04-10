package com.hari.dsal.trees;

public class CountCompleteTreeNodes_222 {
	private int height(TreeNode root) {
		return root == null ? -1 : 1 + height(root.left);
	}

	private int countNodes(TreeNode root) {
		int h = height(root);

		return h < 0 ? 0
				: height(root.right) == h - 1 ? (1 << h) + countNodes(root.right)
						: (1 << h - 1) + countNodes(root.left);
	}
	
	private int count(TreeNode root) {
		if(root == null)
			return 0;
		return 1+count(root.right)+count(root.left);
	}
	
	public static void main(String args[]) {
		CountCompleteTreeNodes_222 tree = new CountCompleteTreeNodes_222();
	
		System.out.println("Level order traversal of binary tree is ");
		System.out.println(tree.countNodes(tree.initiateTree()));
		System.out.println(tree.count(tree.initiateTree()));
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
