package com.hari.dsal.trees;

public class ConstructBinaryTreefromPreorderandInorderTraversal_105 {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return helper(0, 0, inorder.length - 1, preorder, inorder);
	}

	public TreeNode helper(int prestart, int instart, int inend, int[] preorder, int[] inorder) {
		if (prestart > preorder.length - 1 || instart > inend)
			return null;
		TreeNode root = new TreeNode(preorder[prestart]);

		int inindex = 0;
		for (int i = instart; i <= inend; i++) {
			if (inorder[i] == root.val)
				inindex = i;
		}
		root.left = helper(prestart + 1, instart, inindex - 1, preorder, inorder);
		root.right = helper(prestart + inindex - instart + 1, inindex + 1, inend, preorder, inorder);
		return root;
	}

	private void inOrder(TreeNode root) {
		if (root == null)
			return;
		System.out.println(root.val);
		inOrder(root.right);

		inOrder(root.left);
	}

	public static void main(String[] args) {
		ConstructBinaryTreefromPreorderandInorderTraversal_105 cbt = new ConstructBinaryTreefromPreorderandInorderTraversal_105();
		int[] preorder = { 3, 9, 20, 15, 7 };
		int[] inorder = { 9, 3, 15, 20, 7 };
		TreeNode root = cbt.buildTree(preorder, inorder);
		cbt.inOrder(root);
	}
}
