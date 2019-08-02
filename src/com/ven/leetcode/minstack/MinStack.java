package com.ven.leetcode.minstack;

import java.util.Stack;

public class MinStack {
	private Stack<Integer> st = null;
    private Stack<Integer> minStack = null;

    /** initialize your data structure here. */
    public MinStack() {
        st = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int x) {
        st.push(x);
        int min = (minStack.isEmpty())?  Integer.MAX_VALUE: minStack.peek();
        if(x < min){
            minStack.push(x);
        }else{
            minStack.push(min);
        }
    }
    
    public void pop() {
    	st.pop();
        minStack.pop();
    }
    
    public int top() {
    	return st.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
