package com.hari.dsal.trees;

public class KthSmallestElement_230 {
	
	private int kthsamallelement(TreeNode root, int k) {
		int count = countNodes(root.left);
		
		if(k <= count) {
			return kthsamallelement(root.left, k);
		} else if(k > count + 1) {
			return kthsamallelement(root.right, k - 1 - count); //delete root and left node
		}
		return root.val;		
	}
	
	public int countNodes(TreeNode n) {
		if(n == null)
			return 0;
		return 1+countNodes(n.left) + countNodes(n.right);
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
		KthSmallestElement_230 vbst = new KthSmallestElement_230();
		System.out.println(vbst.kthsamallelement(vbst.initiateTree(),2));
	}
}
