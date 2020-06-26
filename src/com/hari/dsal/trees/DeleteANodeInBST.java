package com.hari.dsal.trees;

public class DeleteANodeInBST {
	
	private TreeNode deleteNode(TreeNode root, int key) {
		
		if(root == null)
			return null;
		
		if( key < root.val) { // Less 
			root.left = deleteNode(root.left, key);
		} else if( key > root.val){// Greater
			root.right = deleteNode(root.right, key);
		} else {			// Equal 
			if(root.left == null) {
				return root.right;
			} else if(root.right == null) {
				return root.left;
			}
			
			TreeNode minNode = findMin(root.right);
			root.val = minNode.val; // Chnage the value
			root.right = deleteNode(root.right, root.val); // return from loop
		}		
		return root;
	}
	
	private TreeNode findMin(TreeNode node) {
		while(node.left != null) {
			node = node.left;
		}
		return node;
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
		DeleteANodeInBST vbst = new DeleteANodeInBST();
		vbst.deleteNode(vbst.initiateTree(),30);
	}
}
