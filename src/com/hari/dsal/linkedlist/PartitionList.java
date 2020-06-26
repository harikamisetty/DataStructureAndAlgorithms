package com.hari.dsal.linkedlist;

public class PartitionList {
	
	private ListNode partitionList(ListNode head, int x) {
		ListNode dummy1 = new ListNode(0), dummy2 = new ListNode(0);
		ListNode curr1 = dummy1, curr2 = dummy2;
		
		while(head != null) {
			if(head.val < x) {
				curr1.next = head;
				curr1 = head;
			}else {
				curr2.next = head;
				curr2 = head;
			}
			head = head.next;
		}
		// Avoid Cycles in List
		curr2.next = null;
		curr1.next = dummy2.next;
		return dummy1.next;
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(6);
		ListNode node1 = new ListNode(2);
		head.next = node1;

		ListNode node2 = new ListNode(3);
		node1.next = node2;

		node2.next = null;

		PartitionList rll = new PartitionList();
		ListNode resNode = rll.partitionList(head,3);
		
		while(resNode != null) {
			System.out.println(resNode.val);
			resNode = resNode.next;
		}
	}	
}