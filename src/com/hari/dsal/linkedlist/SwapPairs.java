package com.hari.dsal.linkedlist;

public class SwapPairs {
	public ListNode swappairNodes(ListNode head) {
		
		 final int length = getLength(head);
		    ListNode dummy = new ListNode(0);
		    dummy.next = head;
		    ListNode prev = dummy;
		    ListNode curr = head;

		    for (int i = 0; i < length / 2; ++i) {
		      ListNode next = curr.next;
		      curr.next = next.next;
		      next.next = curr;
		      prev.next = next;
		      prev = curr;
		      curr = curr.next;
		    }

		    return dummy.next;
		  }

		  private int getLength(ListNode head) {
		    int length = 0;
		    for (ListNode curr = head; curr != null; curr = curr.next)
		      ++length;
		    return length;
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
