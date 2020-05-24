package com.ven.leetcode.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.onlineassesment.Solution;

/**
 * Given head which is a reference node to a singly-linked list. The value of
 * each node in the linked list is either 0 or 1. The linked list holds the
 * binary representation of a number.
 * 
 * Return the decimal value of the number in the linked list.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: head = [1,0,1] Output: 5 Explanation: (101) in base 2 = (5) in base 10
 * Example 2:
 * 
 * Input: head = [0] Output: 0 Example 3:
 * 
 * Input: head = [1] Output: 1 Example 4:
 * 
 * Input: head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0] Output: 18880 Example 5:
 * 
 * Input: head = [0,0] Output: 0
 * 
 * 
 * Constraints:
 * 
 * The Linked List is not empty. Number of nodes will not exceed 30. Each node's
 * value is either 0 or 1.
 * 
 * @author Venkatesh Manohar
 *
 */
public class ConvertBinaryNumber {
	public int getDecimalValue(ListNode head) {
		StringBuilder sb = new StringBuilder();
		while(head != null) {
			sb.append(head.val);
			head = head.next;
		}
		
		return Integer.parseInt(sb.toString(),2);
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

	public static void helper(String s) {
		ListNode head = stringToListNode(s);

		int ret = new ConvertBinaryNumber().getDecimalValue(head);

		String out = String.valueOf(ret);

		System.out.println(out);
	}
	public static void main(String[] args) throws IOException {
		
			helper("[1,0,1]");
			helper("[0]");
			helper("[1]");
			helper("[1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]");
			helper("[0,0,0]");
			
		
	}

}
