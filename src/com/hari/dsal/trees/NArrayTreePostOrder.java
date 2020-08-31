package com.hari.dsal.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NArrayTreePostOrder {
	
	public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        postOrderTraversal(res,root);
        return res;
    }
    
    private void postOrderTraversal(List<Integer> res, Node root){
        Stack<Node> stack = new Stack<>();
        
        if(root != null)
            stack.push(root);
        while(!stack.empty()){
           root = stack.pop();
            res.add(0,root.val);
            if(root.children != null){
               // Collections.reverse(root.children);
                
               for(Object temp: root.children){
                   stack.push((Node)temp);
               }                
            }                
        }        
    }
    
    public static void main(String[] args) {
    	NArrayTreePostOrder narray = new NArrayTreePostOrder();
    	narray.postorder(narray.initiateTree());
	}
    
    private Node initiateTree() {

		Node root = new Node();
		root.val =1;
		List<Node> nodeList = new ArrayList<>();
		Node node1 = new Node();
		node1.val = 3;
		nodeList.add(node1);
		Node node2 = new Node();
		node2.val = 2;
		nodeList.add(node2);
		Node node3 = new Node();
		node3.val = 4;
		nodeList.add(node3);
		root.children = nodeList;
		
		List<Node> nodeList2 = new ArrayList<>();
		Node node4 = new Node();
		node4.val = 5;
		nodeList2.add(node4);
		Node node5 = new Node();
		node5.val =6;
		nodeList2.add(node5);
		node1.children = nodeList2;

		return root;

	}
    class Node{
    	int val;
    	List<Node> children; 
    	
    }
}
