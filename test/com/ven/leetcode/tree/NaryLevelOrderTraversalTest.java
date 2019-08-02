package com.ven.leetcode.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class NaryLevelOrderTraversalTest {
	static Node tree1 = null;
	NaryLevelOrderTraversal lot = new NaryLevelOrderTraversal();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		Node node5 = new Node(5, null);
		Node node6 = new Node(6, null);
		ArrayList<Node> list3 = new ArrayList<>();
		list3.add(node5);
		list3.add(node6);
		Node node3 = new Node(3, list3);
		Node node2 = new Node(2, null);
		Node node4 = new Node(4, null);
		ArrayList<Node> list1 = new ArrayList<>();
		list1.add(node3);
		list1.add(node2);
		list1.add(node4);
		tree1 = new Node(1, list1);
	}

	@Test
	void test() {
		List<List<Integer>> result = lot.levelOrder(tree1);
		assertEquals(1, result.get(0).get(0));
		assertEquals(3, result.get(1).get(0));
		assertEquals(2, result.get(1).get(1));
		assertEquals(4, result.get(1).get(2));
		assertEquals(5, result.get(2).get(0));
		assertEquals(6, result.get(2).get(1));
	}
	@Test
	void testNull() {
		List<List<Integer>> result = lot.levelOrder(null);
		assertEquals(0, result.size());
	}
	
	@Test
	void testlevelOrder2() {
		List<List<Integer>> result = lot.levelOrder2(tree1);
		assertEquals(1, result.get(0).get(0));
		assertEquals(3, result.get(1).get(0));
		assertEquals(2, result.get(1).get(1));
		assertEquals(4, result.get(1).get(2));
		assertEquals(5, result.get(2).get(0));
		assertEquals(6, result.get(2).get(1));
	}
	@Test
	void testlevelOrder2Null() {
		List<List<Integer>> result = lot.levelOrder2(null);
		assertEquals(0, result.size());
	}
}
