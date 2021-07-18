package com.ven.utility;

import com.ven.leetcode.linkedlist.ListNode;

public class ListUtility {
	
	public static void print(ListNode node) {
		while(node != null) {
			System.out.print(node.val +"->");
			node = node.next;
		}
		
		System.out.println();
	}

}
