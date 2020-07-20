package com.hari.dsal.leetcode;

import com.hari.dsal.linkedlist.ListNode;

public class MiddleOfLinkedList {

	public ListNode middleNode(ListNode head) {
		if(head == null)
			return null;
		ListNode slow = head.next;
		ListNode fast = head.next.next;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast= fast.next.next;
		}
		return slow;
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(2);
		ListNode node1 = new ListNode(4);
		head.next = node1;

		ListNode node2 = new ListNode(3);
		node1.next = node2;

		node2.next = null;
		
		MiddleOfLinkedList mol = new MiddleOfLinkedList();
		System.out.println(mol.middleNode(head).val);
	}
}
