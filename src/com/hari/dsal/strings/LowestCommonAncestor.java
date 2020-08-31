package com.hari.dsal.strings;

public class LowestCommonAncestor {
	
	private TreeNode lca(TreeNode root, int node1, int node2) {
	    while (true) {
	        if (root.val > node1 && root.val > node2) {
	            root = root.left;
	        } else if (root.val < node1 && root.val < node2) {
	            root = root.right;
	        } else {
	            return root;
	        }
	    }
	}
	
	public static void main(String[] args) {
		LowestCommonAncestor lc = new LowestCommonAncestor();
		System.out.println(lc.lca(lc.initiateTree(), 20, 30).val);
	}
	class TreeNode {

		public int val;
		public TreeNode left;
		public TreeNode right;

		public TreeNode(int x) {
			val = x;
		}
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
