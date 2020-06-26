package com.hari.dsal.leetcode;
/*
 * TODO :This code is wrong .. Need to change 
 * 
 * 
 */
public class MergeTwoLists {
	
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode l3 = dummy;
        
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                l3.next = l1;
                l1 = l1.next;
            } else {
                l3.next = l2;
                l2 = l2.next;
            }
            l3 = l3.next;
        }
        
        	while(l1 != null ) {
        		l3.next = l1;
        		l1 = l1.next;
        	}
        
        	while(l2!= null ) {
            l3.next = l2;
            l2=l2.next;
        	}
        
        return dummy.next;        
    }
	
	public static void main(String[] args) {
		
		ListNode l1 = new ListNode(10);
		ListNode l2 = new ListNode(20);
		l1.next = l2;
		ListNode l3 = new ListNode(30);
		l2.next=l3;
		ListNode l4 = new ListNode(40);
		l3.next = l4;
		ListNode l5 = new ListNode(50);
		l4.next=l5;
		
		ListNode l11 = new ListNode(15);
		ListNode l12 = new ListNode(25);
		l11.next = l12;
		ListNode l13 = new ListNode(35);
		l12.next = l13;
		ListNode l14 = new ListNode(45);
		l13.next = l14;
		ListNode l15 = new ListNode(55);
		l14.next = l15;
		ListNode l16 = new ListNode(65);
		l15.next = l16;
		
		ListNode listNode = mergeTwoLists(l1, l11);
		
		while(listNode.next != null) {
			System.out.println(listNode.val);
			listNode = listNode.next;
		}
		
	}
}
