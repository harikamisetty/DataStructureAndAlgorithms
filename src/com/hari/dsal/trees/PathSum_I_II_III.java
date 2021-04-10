package com.hari.dsal.trees;

import java.util.LinkedList;
import java.util.List;

public class PathSum_I_II_III {	
	// PathSum I
	private boolean hasPathSum(TreeNode root, int sum) {
		
		if(root == null) return false;
		
		if(root.left == null && root.right == null && sum - root.val ==0)
			return true;
		
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val); 
	}
	
	// Path Sum II
	private List<List<Integer>> pathSumList(TreeNode root, int sum){
		List<List<Integer>> result = new LinkedList<>();
		List<Integer> currentResult = new LinkedList<Integer>();
		
		pathSum(root, sum, currentResult, result);
		
		return result;		
	}

	private void pathSum(TreeNode root, int sum, List<Integer> currentResult, List<List<Integer>> result) {
		
		if(root == null)
			return;
		currentResult.add(root.val);
		
		if(root.left ==null && root.right == null && sum == root.val) {
			result.add(currentResult);
			// Remove the last element to get the next combination.
			currentResult.remove(currentResult.size() -1);
			return;
		}
		
		pathSum(root.left, sum-root.val, currentResult, result);
		pathSum(root.right, sum-root.val, currentResult, result);
		// Remove from the list to get Next List
		currentResult.remove(currentResult.size() -1);
	}
	
	// Path Sum III
	int count = 0;

	public int pathSum(TreeNode root, int sum) {
		if (root == null)
			return 0;
		helper(root, sum);
		
		pathSum(root.left, sum);
		pathSum(root.right, sum);
		
		return count;
	}

	public void helper(TreeNode root, int sum) {
		if (root == null)
			return;
		
		if (root.val - sum == 0)
			count++;
		
		helper(root.left, sum - root.val);
		helper(root.right, sum - root.val);
	}
}
