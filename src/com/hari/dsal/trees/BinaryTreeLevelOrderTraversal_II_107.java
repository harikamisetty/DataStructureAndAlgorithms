package com.hari.dsal.trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal_II_107 {

	
	public List<List<Integer>> levelOrder(TreeNode root){
		
		Queue<TreeNode> q = new LinkedList<>();
		List<List<Integer>> retList = new LinkedList<List<Integer>>();
		
		if(root == null)
			return retList;
		
		q.add(root);
		
		while(!q.isEmpty()) {
			// Get Queue Size
			int nodeCount = q.size();
			List<Integer> valueList = new LinkedList<Integer>();
			
			for(int i = 0; i < nodeCount; i++) {
				TreeNode node = q.remove();
				valueList.add(node.val);
				
				// Add left and right to Queue back
				if(node.left != null)
					q.add(node.left);
				if(node.right != null)
					q.add(node.right);
			}
			// This is the only change from program I , it will show tree from upside down.
			retList.add(0,valueList);
		}
		return retList;
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
		BinaryTreeLevelOrderTraversal_II_107 btl = new BinaryTreeLevelOrderTraversal_II_107();
		List<List<Integer>> retList =btl.levelOrder(btl.initiateTree());
		
		retList.forEach(list -> {
			System.out.println("\n");
			list.forEach(ele-> {
				System.out.print(ele + ",");
			});
		});
	}
}
