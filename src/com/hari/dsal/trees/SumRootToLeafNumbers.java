package com.hari.dsal.trees;

public class SumRootToLeafNumbers {
	
	private int sumNumbers(TreeNode root) {
		return sum(root, 0);
	}

	private int sum(TreeNode root, int sum) {
		
		if(root == null)
			 return 0;
		
		if(root.right == null && root.left == null) {
			return sum * 10 + root.val;
		}
		
		return sum(root.left, sum * 10 + root.val) + sum(root.right, sum * 10 + root.val); 
	}
}