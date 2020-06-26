package com.hari.dsal.linkedlist;

public class ReverseLinkedList {
	
	public ListNode reverseList(ListNode head) {
		
		if(head == null) return null;
		if(head.next == null) return head;
		
		ListNode newHead = null;
		
		while(head != null) { // head != null only
			ListNode next =head.next;
			head.next = newHead;
			newHead = head;
			head = next;			
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

		ReverseLinkedList rll = new ReverseLinkedList();
		ListNode resNode = rll.reverseList(head);
		
		while(resNode != null) {
			System.out.println(resNode.val);
			resNode = resNode.next;
		}
	}	
}
