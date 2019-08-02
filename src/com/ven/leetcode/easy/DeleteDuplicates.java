package com.ven.leetcode.easy;

public class DeleteDuplicates {
	public ListNode deleteDuplicates(ListNode head) {
        if(head == null ) return null;
        ListNode prev = head;
        ListNode next = head.next;
        while(prev!=null && next!=null){
            if(prev.val == next.val){
                prev.next = next.next;
                next = next.next;
            }else{
                prev = prev.next;
                next = next.next;
            }
        }
        return head;
    }
}
