package com.hari.dsal.trees;

import java.util.ArrayList;
import java.util.List;

public class SearchInBST {

	public static void main(String[] args) {
		SearchInBST sbt = new SearchInBST();
		System.out.println(sbt.solve(sbt.initiateTree(), 35));

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

	public TreeNode searchBST(TreeNode root, int val) {
		TreeNode res = searchBSTHelper(root, val);
		return res;

	}

	private TreeNode searchBSTHelper(TreeNode root, int val) {

		if (root == null)
			return null;

		if (root.val == val)
			return root;

		// then recur on left sutree /
		TreeNode res1 = searchBSTHelper(root.left, val);
		if (null != res1 && res1.val == val)
			return res1; // node found, no need to look further

		// node is not found in left, so recur on right subtree /
		TreeNode res2 = searchBSTHelper(root.right, val);

		return res2;
	}
	
	 public boolean solve(TreeNode root, int val) {
	      List<Integer> res = new ArrayList<>();

	      solveHelper(root,val,res);

	      for(int cal : res){
	        if(cal == val)
	            return true;
	      }
	    
	         return false; 
	    }

	    private void solveHelper(TreeNode root, int val, List<Integer> res){

	        if(root != null){
	            res.add(root.val);
	            solveHelper(root.right,val,res);
	            solveHelper(root.left,val,res);
	        }
	    }
}
