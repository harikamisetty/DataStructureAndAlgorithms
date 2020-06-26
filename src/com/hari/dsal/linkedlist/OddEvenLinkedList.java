package com.hari.dsal.linkedlist;

public class OddEvenLinkedList {
	
	private ListNode getOddEvenList(ListNode head) {
		if(head !=null) {
			ListNode odd = head, even = head.next, evenHead = even;
			
			while(even != null && even.next != null) {
				odd.next = odd.next.next;
				even.next = even.next.next;
				odd = odd.next;
				even = even.next;
			}
			odd.next = evenHead;
		}
		return head;
	}
	public static void main(String[] args) {
		ListNode head = new ListNode(6);
		ListNode node1 = new ListNode(2);
		head.next = node1;

		ListNode node2 = new ListNode(3);
		node1.next = node2;

		node2.next = null;

		OddEvenLinkedList rll = new OddEvenLinkedList();
		ListNode resNode = rll.getOddEvenList(head);
		
		while(resNode != null) {
			System.out.println(resNode.val);
			resNode = resNode.next;
		}
	}
}