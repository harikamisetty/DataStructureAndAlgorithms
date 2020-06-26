package com.hari.dsal.linkedlist;

public class LinkedListCycle {
	
	public boolean isLinkedListHasCucle(ListNode head) {
		
		if(head == null) return false;
		if(head.next == null) return false;
		
		ListNode slow = head;
		ListNode fast = head;
		
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow == fast) return true;
		}
		return false;
	}

	
	public static void main(String[] args) {
		ListNode head = new ListNode(2);
		ListNode node1 = new ListNode(4);
		head.next = node1;

		ListNode node2 = new ListNode(3);
		node1.next = node2;

		node2.next = null;

		SwapPairs rll = new SwapPairs();
		ListNode resNode = rll.swappairNodes(head);
		
		while(resNode != null) {
			System.out.println(resNode.val);
			resNode = resNode.next;
		}
	}	
}
