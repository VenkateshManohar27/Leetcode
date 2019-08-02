package com.ven.leetcode.easy;

public class RemoveElementLinkedList {
	public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;
        ListNode helper = new ListNode(0);
        helper.next = head;
        ListNode prev = helper;
        while(head != null){
            if(head.val == val){
                prev.next = head.next;
                head = head.next;
            }else{
                prev= prev.next;
                head = head.next;
            }
        }
        
        return helper.next;
    }
}
