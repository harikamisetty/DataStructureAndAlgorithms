package com.hari.dsal.linkedlist;

import java.util.HashMap;
import java.util.Map;

/*
 * Understand the problem:
The crux to understand the problem is the deep copy of the list. 
If the linked list has only next reference, copying could be quite straight-forward. 
However, with the existence of random pointer, the new copied linked list has no idea where 
it should point to, because the node pointed by the random pointer at the old linked 
list is not the same reference in the new linked list.

Solution:
One straight-forward solution to address this problem is to use a hashed map. 
The key and value is the old and new node in the linked list. 
So for the random pointer points to a old node, we can map it to the new node. 
 
 */
public class CopyListwithRandomPointer_138 {
	
	public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
         
        Map<RandomListNode, RandomListNode> hashMap = new HashMap<>();
         
        RandomListNode p = head;
        RandomListNode newHead = new RandomListNode(head.label);
        RandomListNode q = newHead;
         
        hashMap.put(head, newHead);
        p = p.next;
         
        while (p != null) {
            RandomListNode temp = new RandomListNode(p.label);
            q.next = temp;
            q = temp;
            hashMap.put(p, q);
             
            p = p.next;
        }
         
        p = head;
        q = newHead;
         
        while (p != null) {
            if (p.random != null) {
                q.random = hashMap.get(p.random);
            } else {
                q.random = null;
            }
            p = p.next;
            q = q.next;
        }
         
        return newHead;
    }
}
