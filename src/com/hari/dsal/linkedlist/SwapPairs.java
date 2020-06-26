package com.hari.dsal.linkedlist;

public class SwapPairs {
	public ListNode swappairNodes(ListNode head) {
		
		if(head == null) return null;
		if(head.next == null) return head;
		
		ListNode newHead = head.next;
		
		while(head != null && head.next != null) {
			ListNode first = head;
			ListNode second = head.next;
			
			head = second.next;
			first.next = second.next;
			second.next = first;					
		}
		return newHead;
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
