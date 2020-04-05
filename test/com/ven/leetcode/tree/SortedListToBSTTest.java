package com.ven.leetcode.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.ven.leetcode.linkedlist.ListNode;

class SortedListToBSTTest {
	SortedListToBST bst = new SortedListToBST();
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void test() {
		ListNode node = new ListNode(-10);
		node.next = new ListNode(-3);
		node.next.next = new ListNode(0);
		node.next.next.next = new ListNode(5);
		node.next.next.next.next = new ListNode(9);
		
		TreeNode tree = bst.sortedListToBST(node);
		assertEquals(tree.val, 0);
		assertEquals(tree.left.val, -10);
		assertEquals(tree.left.right.val, -3);
		assertEquals(tree.right.val, 5);
		assertEquals(tree.right.right.val, 9);
	}
	
	
}
