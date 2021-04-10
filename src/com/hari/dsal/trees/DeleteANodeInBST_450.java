package com.hari.dsal.trees;

public class DeleteANodeInBST_450 {
	
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
			root.right = deleteNode(root.right, root.val); // delete min value
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
		root.left.right = new TreeNode(15);
		
		root.left.right.left = new TreeNode(12);
		root.left.right.right = new TreeNode(18);

		root.right.left = new TreeNode(25);
		root.right.right = new TreeNode(35);

		return root;

	}

	public static void main(String[] args) {
		DeleteANodeInBST_450 vbst = new DeleteANodeInBST_450();
		vbst.deleteNode(vbst.initiateTree(),10);
	}
}
