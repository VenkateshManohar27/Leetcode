package com.ven.leetcode.queue;

import java.util.Stack;

public class QueueUsingStack {
	private Stack<Integer> input = null;
	private Stack<Integer> output = null;

	/** Initialize your data structure here. */
	public QueueUsingStack() {
		input = new Stack<Integer>();
		output = new Stack<Integer>();

	}

	/** Push element x to the back of queue. */
	public void push(int x) {
		input.push(x);
	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		if (output.isEmpty()) {
			while (!input.isEmpty()) {
				output.push(input.pop());
			}
		}
		return output.pop();
	}

	/** Get the front element. */
	public int peek() {
		if (output.isEmpty()) {
			while (!input.isEmpty()) {
				output.push(input.pop());
			}
		}
		return output.peek();
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		return input.isEmpty() && output.isEmpty();
	}
}
