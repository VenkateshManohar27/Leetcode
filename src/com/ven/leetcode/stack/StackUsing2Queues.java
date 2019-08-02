package com.ven.leetcode.stack;

import java.util.LinkedList;
import java.util.Queue;
// Not a good appraoch
public class StackUsing2Queues {
	private Queue<Integer> inputStack = null;
	private Queue<Integer> outputStack = null;

	/** Initialize your data structure here. */
	public StackUsing2Queues() {
		this.inputStack = new LinkedList<>();
		this.outputStack = new LinkedList<>();
	}

	/** Push element x onto stack. */
	public void push(int x) {
		inputStack.add(x);
	}

	/** Removes the element on top of the stack and returns that element. */
	public int pop() {
		if(outputStack.isEmpty()) {
			while(!inputStack.isEmpty()) {
				outputStack.add(inputStack.poll());
			}
		}
		return outputStack.poll();
	}

	/** Get the top element. */
	public int top() {
		if(outputStack.isEmpty()) {
			while(!inputStack.isEmpty()) {
				outputStack.add(inputStack.poll());
			}
		}
		return outputStack.peek();
	}

	/** Returns whether the stack is empty. */
	public boolean empty() {
		return inputStack.isEmpty() && outputStack.isEmpty();
	}
}
