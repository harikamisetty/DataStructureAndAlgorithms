package com.hari.dsal.linkedlist;

public class SwapPairs {
	public ListNode swappairNodes(ListNode head) {

		ListNode fakeHead = new ListNode(-1);
		fakeHead.next = head;
		ListNode node = fakeHead;

		while (node != null & node.next != null && node.next.next != null) {
			
			ListNode first = node;
			ListNode second = node.next;
			ListNode third = node.next.next;
			
			first.next = third;
			second.next = third.next;
			third.next = second;
			
			node = second;
		}
		return fakeHead.next;
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

		while (resNode != null) {
			System.out.println(resNode.val);
			resNode = resNode.next;
		}
	}
}
