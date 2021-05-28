package com.hari.dsal.strings;

public class LowestCommonAncestor_236 {
	
	private TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
	}
	
	public static void main(String[] args) {
		LowestCommonAncestor_236 lc = new LowestCommonAncestor_236();
		TreeNode a = new TreeNode(20);
		TreeNode b = new TreeNode(30);
		System.out.println(lc.lowestCommonAncestor(lc.initiateTree(),a ,b));
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
class TreeNode {

	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int x) {
		val = x;
	}
}
