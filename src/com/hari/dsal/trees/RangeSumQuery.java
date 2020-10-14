package com.hari.dsal.trees;

import java.util.Stack;

public class RangeSumQuery {

	public int rangeSumBST(TreeNode root, int L, int R) {
		int ans = 0;
		Stack<TreeNode> stack = new Stack();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			if (node != null) {
				if (L <= node.val && node.val <= R)
					ans += node.val;
				if (L < node.val)
					stack.push(node.left);
				if (node.val < R)
					stack.push(node.right);
			}
		}
		return ans;
	}
	
	 int ans;
	    public int rangeSumBST1(TreeNode root, int L, int R) {
	        ans = 0;
	        dfs(root, L, R);
	        return ans;
	    }

	    public void dfs(TreeNode node, int L, int R) {
	        if (node != null) {
	            if (L <= node.val && node.val <= R)
	                ans += node.val;
	            if (L < node.val)
	                dfs(node.left, L, R);
	            if (node.val < R)
	                dfs(node.right, L, R);
	        }
	    }
	
	private TreeNode initiateTree() {

		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);

		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(7);
		
		root.left.left.left = new TreeNode(1);
		root.left.right.left = new TreeNode(6);

		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(18);

		return root;
	}
	
	public static void main(String[] args) {
		RangeSumQuery rsq = new RangeSumQuery();
		System.out.println(rsq.rangeSumBST(rsq.initiateTree(), 6, 10));
		System.out.println(rsq.rangeSumBST1(rsq.initiateTree(), 6, 10));
	}
}
