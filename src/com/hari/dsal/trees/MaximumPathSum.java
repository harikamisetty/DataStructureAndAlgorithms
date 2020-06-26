package com.hari.dsal.trees;

public class MaximumPathSum {
	
	private static void binaryTreeMaximumPathSum(TreeNode root) {
		maxPathSum(root);
	}
	
	private static int maxSum = Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxPathSumHelper(root);
        return maxSum;
    }
     
    private static int maxPathSumHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }
         
        int left = maxPathSumHelper(root.left);
        int right = maxPathSumHelper(root.right);
        
        // Logic to avoid negative values
        int arch = left + right + root.val;
        int pathSum = Math.max(root.val, Math.max(left, right) + root.val);                
        maxSum = Math.max(maxSum, Math.max(arch, pathSum));
         
        return pathSum;
    }
}
