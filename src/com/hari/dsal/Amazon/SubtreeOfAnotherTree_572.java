package com.hari.dsal.Amazon;

import com.hari.dsal.trees.TreeNode;

public class SubtreeOfAnotherTree_572 {
	
	 public boolean isSubtree(TreeNode s, TreeNode t) {
	        return traverse(s,t);
	    }
	    public boolean equals(TreeNode x,TreeNode y)
	    {
	        if(x==null && y==null)
	            return true;
	        if(x==null || y==null)
	            return false;
	        return x.val==y.val && equals(x.left,y.left) && equals(x.right,y.right);
	    }
	    public boolean traverse(TreeNode s,TreeNode t)
	    {
	        return  s!=null && ( equals(s,t) || traverse(s.left,t) || traverse(s.right,t));
	    }
    
    
	private TreeNode initiateTree1() {

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
    	SubtreeOfAnotherTree_572 soa = new SubtreeOfAnotherTree_572();
    	System.out.println(soa.isSubtree(soa.initiateTree1(), soa.initiateTree1()));
	}

}
