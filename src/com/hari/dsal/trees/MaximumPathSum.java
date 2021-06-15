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
    
    // Solution 2
    int maxsum = Integer.MIN_VALUE;

    public int solve(Tree root) {
        if(root == null)
            return 0;
           maxpathsum(root);
           return  maxsum;        
    }

    private int maxpathsum(Tree root){
        if(root == null)
            return 0;

        int left = maxpathsum(root.left);
        int right = maxpathsum(root.right);      
        maxsum= Math.max(left,right)+root.val;

        return maxsum;
    }
}
