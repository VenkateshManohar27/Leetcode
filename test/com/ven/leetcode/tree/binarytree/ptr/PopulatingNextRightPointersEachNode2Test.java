package com.ven.leetcode.tree.binarytree.ptr;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PopulatingNextRightPointersEachNode2Test {
	static Node tree1 = null;
	static Node tree2 = null;
	PopulatingNextRightPointersEachNode2 pn = new PopulatingNextRightPointersEachNode2();
	@BeforeEach
	void setUpBeforeClass() throws Exception {
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node2 = new Node(2, node4, node5, null);
		Node node7 = new Node(7);
		Node node3= new Node(3, null, node7, null);
		tree1 = new Node(1, node2, node3, null); 
		
		//[1,2,3,4,5,null,6,7,null,null,null,null,8]
		node4.left = node7;
		node2 = new Node(2, node4, node5, null);
		Node node6 = new Node(6);
		Node node8 = new Node(8);
		node6.right = node8;
		node3= new Node(3, null, node6, null);
		tree2 =new Node(1, node2, node3, null); 
	}

	@Test
	void testHappyPath() {
		Node tree = pn.connect(tree1);
		assertEquals(1, tree.data);
		assertNull(tree.next);
		assertEquals(3, tree.left.next.data);
		assertNull(tree.right.next);
		assertEquals(5, tree.left.left.next.data);
		assertEquals(7, tree.left.right.next.data);
		assertNull(tree.right.right.next);
	}
	//[1,2,3,4,5,null,6,7,null,null,null,null,8]
	@Test
	void testLeetCodeEx1() {
		Node tree = pn.connect(tree2);
		assertEquals(1, tree.data);
		assertNull(tree.next);
		assertEquals(3, tree.left.next.data);
		assertNull(tree.right.next);
		assertEquals(5, tree.left.left.next.data);
		assertEquals(6, tree.left.right.next.data);
		assertNull(tree.right.right.next);
		assertEquals(8, tree.left.left.left.next.data);
	}
}
