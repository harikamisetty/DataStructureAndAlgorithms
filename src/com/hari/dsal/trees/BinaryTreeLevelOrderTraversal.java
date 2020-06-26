package com.hari.dsal.trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
	
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
			retList.add(valueList);
		}
		return retList;
	}
}
