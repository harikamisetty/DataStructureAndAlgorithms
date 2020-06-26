package com.hari.dsal.trees;

public class SumOfLeftLeaves {
	
	private int getSumOfLeftLeaves(TreeNode root) {
		if (root == null)
			return 0;
		int sum = 0;
		
		if (root.left != null) {
			if (root.left.left == null && root.left.right == null) {
				sum += root.left.val;
			} else {
				sum += getSumOfLeftLeaves(root.left);
			}
		}
		sum += getSumOfLeftLeaves(root.right);

		return sum;
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
		SumOfLeftLeaves vbst = new SumOfLeftLeaves();
		System.out.println(vbst.getSumOfLeftLeaves(vbst.initiateTree()));
	}
}
