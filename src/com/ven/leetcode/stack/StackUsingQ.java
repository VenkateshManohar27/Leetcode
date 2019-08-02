package com.ven.leetcode.stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQ {

	private Queue<Integer> stack = null;

	/** Initialize your data structure here. */
	public StackUsingQ() {
		this.stack = new LinkedList<>();
	}

	/** Push element x onto stack. */
	public void push(int x) {
		stack.add(x);
		int n = stack.size();
		while (n-- > 1) {
			stack.add(stack.poll());
		}
	}

	/** Removes the element on top of the stack and returns that element. */
	public int pop() {
		return stack.poll();
	}

	/** Get the top element. */
	public int top() {
		return stack.peek();
	}

	/** Returns whether the stack is empty. */
	public boolean empty() {
		return stack.isEmpty();
	}
}
