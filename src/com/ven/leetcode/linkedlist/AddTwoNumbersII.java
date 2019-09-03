package com.ven.leetcode.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddTwoNumbersII {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}

		if (l2 == null) {
			return l1;
		}
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		while (l1 != null) {
			sb1.append(l1.val);
			l1 = l1.next;
		}

		while (l2 != null) {
			sb2.append(l2.val);
			l2 = l2.next;
		}

		int length1 = sb1.length();
		int length2 = sb2.length();

		ListNode res = null;
		int carry = 0;
		while (length1 > 0 || length2 > 0) {
			int ch1 = (length1 > 0) ? sb1.charAt(--length1) - '0' : 0;
			int ch2 = (length2 > 0) ? sb2.charAt(--length2) - '0' : 0;
			int sum = ch1 + ch2 + carry;
			int digit = sum % 10;
			carry = sum / 10;
			ListNode temp = new ListNode((int) digit);
			temp.next = res;

			res = temp;
		}
		if (carry > 0) {
			ListNode temp = new ListNode((int) carry);
			temp.next = res;

			res = temp;
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
			ListNode l1 = stringToListNode(line);
			line = in.readLine();
			ListNode l2 = stringToListNode(line);

			ListNode ret = new AddTwoNumbersII().addTwoNumbers(l1, l2);

			String out = listNodeToString(ret);

			System.out.print(out);
		}
	}
}
