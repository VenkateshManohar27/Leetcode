package com.ven.leetcode.linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * A linked list is given such that each node contains an additional random
 * pointer which could point to any node in the list or null.
 * 
 * Return a deep copy of the list.
 * 
 * The Linked List is represented in the input/output as a list of n nodes. Each
 * node is represented as a pair of [val, random_index] where:
 * 
 * val: an integer representing Node.val random_index: the index of the node
 * (range from 0 to n-1) where random pointer points to, or null if it does not
 * point to any node.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]] Output:
 * [[7,null],[13,0],[11,4],[10,2],[1,0]] Example 2:
 * 
 * 
 * Input: head = [[1,1],[2,1]] Output: [[1,1],[2,1]] Example 3:
 * 
 * 
 * 
 * Input: head = [[3,null],[3,0],[3,null]] Output: [[3,null],[3,0],[3,null]]
 * Example 4:
 * 
 * Input: head = [] Output: [] Explanation: Given linked list is empty (null
 * pointer), so return null.
 * 
 * 
 * Constraints:
 * 
 * -10000 <= Node.val <= 10000 Node.random is null or pointing to a node in the
 * linked list. Number of Nodes will not exceed 1000.
 * 
 * @author Venkatesh Manohar
 *
 */
class CopyListRandomPointerTest {
	CopyListRandomPointer crp = new CopyListRandomPointer();
	static Node node, node1, node2, node3;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		//head = [[7,null],[13,0],[11,4],[10,2],[1,0]] 
		node = new Node(7);
		node.next = new Node(13);
		node.next.next = new Node(11);
		node.next.next.next = new Node(10);
		node.next.next.next.next = new Node(1);
		node.next.random = node;
		node.next.next.random = node.next.next.next.next;
		node.next.next.next.random = node.next.next.next;
		node.next.next.next.next.random = node;
		
		//head = [[1,1],[2,1]]
		node1  =  new Node(1);
		node1.next = new Node(2);
		node1.random = node1.next;
		node1.next.random = node1.next;
		
		//head = [[3,null],[3,0],[3,null]]
		node2 = new Node(3);
		node2.next = new Node(3);
		node2.next.next = new Node(3);
		node2.next.random = node2;
	}

	@Test
	void testNull() {
		assertNull(crp.copyRandomList(null));
	}
	
	
	@Test
	void testList1() {
		Node li = crp.copyRandomList(node);
		assertEquals(7, li.val);
		assertNull(li.random);
		assertEquals(13, li.next.val);
		assertEquals(7, li.val);
		assertEquals(11, li.next.next.val);
		assertEquals(1, li.next.next.next.next.val);
		assertEquals(10, li.next.next.next.val);
		assertEquals(11, li.next.next.val);
		assertEquals(1, li.next.next.next.next.val);
		assertEquals(7, li.val);
	}
	
	@Test
	void testList2() {
		Node li = crp.copyRandomList(node1);
		assertEquals(1, li.val);
		assertEquals(2, li.random.val);
		assertEquals(2, li.next.val);
		assertEquals(2, li.next.random.val);
		assertNull(li.next.next);
	}
	
	@Test
	void testList3() {
		Node li = crp.copyRandomList(node2);
		assertEquals(3, li.val);
		assertNull(li.random);
		assertEquals(3, li.next.val);
		assertEquals(3, li.next.random.val);
		assertEquals(3, li.next.next.val);
		assertNull(li.next.next.random);
	}
}
