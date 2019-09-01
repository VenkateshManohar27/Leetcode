package com.ven.leetcode.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class NextGreaterNode {

	public int[] nextLargerNodes(ListNode head) {
		if (head == null) {
			return new int[] {};
		}
		ArrayList<Integer> list = new ArrayList<>();
		while (head != null) {
			ListNode node = head;
			ListNode temp = node;
			int nextLargestValue = 0;

			while (temp.next != null) {
				temp = temp.next;
				if (temp.val > node.val) {
					nextLargestValue = temp.val;
					break;
				}
			}
			list.add(nextLargestValue);
			head = head.next;
		}
		return list.stream().mapToInt(Integer::intValue).toArray();
	}
	
	public int[] nextLargerNodesOptimized(ListNode head) {
		ArrayList<Integer> list = new ArrayList<>();
		for(ListNode node = head;node != null;node =node.next) {
			list.add(node.val);
		}
		int[] res = new int[list.size()];
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < list.size(); i++) {
			while(!st.isEmpty() && list.get(st.peek()) < list.get(i)) {
				res[st.pop()]= list.get(i);
			}
			
			st.push(i);
		}
		return res;
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

			int[] result = new NextGreaterNode().nextLargerNodesOptimized(head);

			for (int i = 0; i < result.length; i++) {
				System.out.print(result[i] + " ");
			}

		}
	}
}
