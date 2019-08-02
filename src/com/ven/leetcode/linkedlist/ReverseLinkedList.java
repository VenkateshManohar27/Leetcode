package com.ven.leetcode.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseLinkedList {

	public ListNode reverseIterative(ListNode head) {
		if (head == null)
			return null;
		ListNode newHead = head;
		head = head.next;
		newHead.next = null;
		while (head != null) {
			ListNode temp = head;
			head = head.next;
			temp.next = newHead;
			newHead = temp;
		}
		return newHead;
	}

	public ListNode reverseList(ListNode head) {
		if (head == null)
			return null;
		ListNode helper = new ListNode(0);
		ListNode res = helper;
		reverseList(head, res);
		return helper.next;
	}

	private void reverseList(ListNode curr, ListNode result) {
		if (curr == null) {
			return;
		}
		reverseList(curr.next, result);
		result.next = curr;
		result = result.next;
	}

	public static int[] stringToIntegerArray(String input) {
		input = input.trim();
		input = input.substring(1, input.length() - 1);
		if (input.length() == 0) {
			return new int[0];
		}

		String[] parts = input.split(",");
		int[] output = new int[parts.length];
		for (int index = 0; index < parts.length; index++) {
			String part = parts[index].trim();
			output[index] = Integer.parseInt(part);
		}
		return output;
	}

	public static ListNode stringToListNode(String input) {
		// Generate array from the input
		int[] nodeValues = stringToIntegerArray(input);

		// Now convert that list into linked list
		ListNode dummyRoot = new ListNode(0);
		ListNode ptr = dummyRoot;
		for (int item : nodeValues) {
			ptr.next = new ListNode(item);
			ptr = ptr.next;
		}
		return dummyRoot.next;
	}

	public static String listNodeToString(ListNode node) {
		if (node == null) {
			return "[]";
		}

		String result = "";
		while (node != null) {
			result += Integer.toString(node.val) + ", ";
			node = node.next;
		}
		return "[" + result.substring(0, result.length() - 2) + "]";
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = in.readLine()) != null) {
			ListNode head = stringToListNode(line);

			ListNode ret = new ReverseLinkedList().reverseIterative(head);

			String out = listNodeToString(ret);

			System.out.print(out);
		}
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}