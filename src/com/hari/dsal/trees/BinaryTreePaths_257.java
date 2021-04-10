package com.hari.dsal.trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths_257 {
	
	private List<String> listOfBinaryTreePaths(TreeNode root){
		
		if(root == null)
			return null;
		
		List<String> answer = new ArrayList<>();
		searchBST(root,"",answer);
		return answer;
	}

	private void searchBST(TreeNode root, String path, List<String> answer) {
		
		if(root.left == null && root.right ==null)
			answer.add(path + root.val); // Path + root.val
		if(root.left != null)
			searchBST(root.left, path+root.val+"->", answer);// Path + root.val
		if(root.right != null)
			searchBST(root.right, path+root.val+"->", answer);// Path + root.val
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
		BinaryTreePaths_257 vbst = new BinaryTreePaths_257();
		List<String> reslist = vbst.listOfBinaryTreePaths(vbst.initiateTree());
		
		reslist.forEach(item -> {
			System.out.println(item);
		});
	}
}
