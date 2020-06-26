package com.hari.dsal.trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
		List<List<Integer>> result = new LinkedList<List<Integer>>();
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
	private int pathSum(TreeNode root, int sum) {
		
		Map<Integer, Integer> preSum = new HashMap<Integer, Integer>();
		preSum.put(0, 1);
		return helper(root, 0, sum, preSum);
	}

	private int helper(TreeNode root, int currentSum, int target, Map<Integer, Integer> preSum) {
		
		if(root == null)
			return 0;
		
		currentSum = currentSum + root.val;
		int res = preSum.getOrDefault(currentSum-target, 0);
		preSum.put(currentSum, preSum.getOrDefault(currentSum, 0)+1);
		
		res= res +helper(root.left, currentSum, target, preSum) + helper(root.right, currentSum, target, preSum);
		preSum.put(currentSum, preSum.get(currentSum)-1);
		
		return res;
	}
}
