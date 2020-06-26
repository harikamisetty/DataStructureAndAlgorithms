package com.hari.dsal.linkedlist;

public class ReOrderLinkedList {
	
	private void reOrderList(ListNode head) {
		
		if(head == null || head.next == null) return;
		
		// Find Middle of List
		ListNode slow = head;
		ListNode fast = head;
		
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		//Reverse the half after middle
		ListNode preMiddle = slow;
		ListNode preCurrent = slow.next;
		while(preCurrent.next !=null) {
			ListNode current = preCurrent.next;
			preCurrent.next = current.next;
			current.next = preMiddle.next;
			preMiddle.next = current;
		}
		
		// Start reorder one by one		
		slow = head;
		fast = preMiddle.next;
		while(slow != preMiddle) {
			preMiddle.next = fast.next;
			fast.next = slow.next;
			slow.next = fast;
			slow = fast.next;
			fast = preMiddle.next;
		}
	}
	public static void main(String[] args) {
		ListNode head = new ListNode(2);
		ListNode node1 = new ListNode(2);
		head.next = node1;

		ListNode node2 = new ListNode(3);
		node1.next = node2;

		node2.next = null;

		ReOrderLinkedList rll = new ReOrderLinkedList();
		rll.reOrderList(head);
		
		while(head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}	
}