package com.hari.dsal.linkedlist;

public class RemoveNthNode {
	public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) return null;
         
        ListNode slow = head;
        ListNode fast = head;
         
        // move fast pointer n steps ahead of slow
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
         
        // move slow and fast pointer one step a time
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
         
        // delete the node
        if (fast == null) {
            head = head.next;
        } else {
            slow.next = slow.next.next;
        }
        return head;
    }
}
