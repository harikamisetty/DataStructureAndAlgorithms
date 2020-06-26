package com.hari.dsal.linkedlist;

public class ConvertSortedListToBinarySearchTree {
	
	private TreeNode converrtListToBinaryTree(ListNode head) {
		if(head == null) return null;
		
		TreeNode root = constructBST(head, null);
		return root;	
	}

	private TreeNode constructBST(ListNode head, ListNode tail) {
		TreeNode node = null;
		if(head != tail) {
			ListNode fast = head;
			ListNode slow = head;
			
			while(fast.next != null && fast.next.next != null) {
				slow = slow .next;
				fast = fast.next.next;
			}
			
			node = new TreeNode(slow.val);
			// Construct LEFT and RIGHT nodes
			node.left = constructBST(head, slow);
			node.right = constructBST(slow.next, tail);			
		}		
		return node;
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(2);
		ListNode node1 = new ListNode(2);
		head.next = node1;

		ListNode node2 = new ListNode(3);
		node1.next = node2;

		node2.next = null;

		ConvertSortedListToBinarySearchTree rll = new ConvertSortedListToBinarySearchTree();
		TreeNode root = rll.converrtListToBinaryTree(head);
		
		while(head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}	
}
