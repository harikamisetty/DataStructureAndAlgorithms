package com.hari.dsal.trees;

public class NaryTreeTraversal {
	 static class Node { 
	        int data; 
	  
	        // List of children 
	        Node children[]; 
	  
	        Node(int n, int data) 
	        { 
	            children = new Node[n]; 
	            this.data = data; 
	        } 
	    } 
	
	 public static void main(String[] args) 
	    { 
	  
	        /* Create the following tree  
	                   1 
	                /  |  \ 
	               2   3   4 
	             / | \ 
	            5  6  7 
	        */
	        int n = 3; 
	        Node root = new Node(n, 1); 
	        root.children[0] = new Node(n, 2); 
	        root.children[1] = new Node(n, 3); 
	        root.children[2] = new Node(n, 4); 
	        root.children[0].children[0] = new Node(n, 5); 
	        root.children[0].children[1] = new Node(n, 6); 
	        root.children[0].children[2] = new Node(n, 7); 
	  
	        inorder(root); 
	    } 
	 
	 static void inorder(Node node) 
	    { 
	        if (node == null) 
	            return; 
	  
	        // Total children count 
	        int total = node.children.length; 
	        // All the children except the last 
	        for (int i = 0; i < total ; i++) 
	            inorder(node.children[i]); 
	  
	        // Print the current node's data 
	        System.out.print("" + node.data + " "); 
	  
	        // Last child 
	       // inorder(node.children[total - 1]); 
	    } 

}
