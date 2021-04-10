package com.hari.dsal.trees;

/*
 * Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.
 */
public class BinaryTreeUpsideDown_156 {
	public TreeNode upsideDownBinaryTree(TreeNode root) {
		if (root == null) {
			return null;
		}

		return upsideDownBinaryTreeHelper(root, null);
	}

	private TreeNode upsideDownBinaryTreeHelper(TreeNode root, TreeNode parent) {
		if (root == null) {
			return parent;
		}

		TreeNode newNode = upsideDownBinaryTreeHelper(root.left, root);

		root.left = parent == null ? null : parent.right;
		root.right = parent;

		return newNode;
	}

	// #2
	public TreeNode upsideDownBinaryTree2(TreeNode root) {
		if (root == null) {
			return null;
		}

		TreeNode parent = null;
		TreeNode parentRightChild = null;
		TreeNode p = root;

		while (p != null) {
			TreeNode next = p.left;
			p.left = parentRightChild;
			parentRightChild = p.right;

			p.right = parent;

			parent = p;
			p = next;
		}

		return parent;
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
		
		BinaryTreeUpsideDown_156 btud = new BinaryTreeUpsideDown_156();
		TreeNode res = btud.upsideDownBinaryTree(btud.initiateTree());
		
		btud.preOrder(res);
	}

	private void preOrder(TreeNode root) {
		
		if(root == null)
			return;
		System.out.print(root.val+ " ");
		
		preOrder(root.left);
		preOrder(root.right);
	}
}
