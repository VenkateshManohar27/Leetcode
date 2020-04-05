package com.ven.leetcode.tree.binarytree.ptr;

public class Node {
	public int data;
	public Node left, right, next;

	public Node() {
		super();
	}

	public Node(int value) {
		this.data = value;
	}

	public Node(int data, Node left, Node right, Node next) {
		this.data = data;
		this.left = left;
		this.right = right;
		this.next = next;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", left=" + left + ", right=" + right + ", next=" + next + "]";
	}
	
	
}
