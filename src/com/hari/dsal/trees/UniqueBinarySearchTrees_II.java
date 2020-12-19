package com.hari.dsal.trees;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTrees_II {
	public List<TreeNode> generateTrees(int n) {
        return generateTreesHelper(1, n);
    }
     
    private List<TreeNode> generateTreesHelper(int start, int end) {
        List<TreeNode> result = new ArrayList<TreeNode>();
         
        if (start > end) {
            result.add(null);
            return result;
        }
         
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = generateTreesHelper(start, i - 1);
            List<TreeNode> right = generateTreesHelper(i + 1, end);
             
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    result.add(root);
                }
            }
        }
         
        return result;
    }
    
    public static void main(String[] args) {
    	UniqueBinarySearchTrees_II ubs = new UniqueBinarySearchTrees_II();
    	List<TreeNode> res = ubs.generateTrees(3);
	}

}
