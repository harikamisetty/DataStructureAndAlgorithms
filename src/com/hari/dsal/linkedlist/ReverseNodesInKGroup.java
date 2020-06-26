package com.hari.dsal.linkedlist;

import java.util.ArrayList;
import java.util.List;

/*
 * For example,
Given this linked list: 1->2->3->4->5
For k = 2, you should return: 2->1->4->3->5
For k = 3, you should return: 3->2->1->4->5

Understand the problem:
The problem is an extension of last problem, where now k is an input along with the linked list. Again, the solution needs to be in-place and only nodes itself may be changed.

Solution:
The basic idea is to iterate the linked list and increase a counter. If the counter equals to the times of k, we reverse the range of linked list. 
 * 
 * 
 */

public class ReverseNodesInKGroup {
	
	public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1)
            return head;
         
        ListNode helper = new ListNode(0);
        helper.next = head;
         
        ListNode pre = helper;
        ListNode cur = head;
         
        int counter = 0;
         
        while (cur != null) {
            counter++;
             
            if (counter % k == 0) {
                pre = reverseRange(pre, cur.next);
                cur = pre.next;
            } else {
                cur = cur.next;
            }
        }
         
        return helper.next;
    }
     
    // Reverse the linked list from pre to end, exclusively
    private ListNode reverseRange(ListNode prev, ListNode end) {
        ListNode head = prev.next;
        ListNode curr = head.next;
         
        while (curr != end) {
            ListNode temp = curr.next;
            curr.next = prev.next;
            prev.next = curr;
             
            curr = temp;
        }
         
        head.next = end;
        return head;
    }
    
    // #2
    public ListNode reverseKGroup2(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) {
            return head;
        }
         
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
         
        ListNode prev = dummyNode;
        ListNode curr = head;
         
        int count = 0;
        while (curr != null) {
            count++;
            if (count % k != 0) {
                curr = curr.next;
            } else {
                ListNode next = curr.next;
                 
                // Reverse the list
                curr.next = null;
                List<ListNode> result = reverseList(prev.next);
                 
                prev.next = result.get(0);
                ListNode tail = result.get(1);
                tail.next = next;
                prev = tail;
                curr = next;
            }
        }
         
        return dummyNode.next;
    }
     
    private List<ListNode> reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode tail = head;
         
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
         
        List<ListNode> result = new ArrayList<>();
        result.add(prev);
        result.add(tail);
         
        return result;         
    }
    
    private ListNode reverseNodeRecursive(ListNode head, int k) {
    	ListNode curr = head;
    	int count  =0;
    	while(curr != null && count != k) {
    		curr = curr.next;
    		count++;
    	}
    	
    	if(count ==k) { // If K+1 node found
    		curr = reverseNodeRecursive(curr, k);
    		
    		while(count-- >0) {
    			ListNode tmp = curr;
    			curr = head;
    			head = tmp;
    		}
    		head = curr;
    	}
    	return head;
    }

}
