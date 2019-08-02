package com.ven.leetcode.minstack;

import java.util.Stack;

public class MinStackSpaceEfficient {
	private Stack<StackElement> st = null;
	
    /** initialize your data structure here. */
    public MinStackSpaceEfficient() {
        st = new Stack<>();
    }
    
    public void push(int x) {
    	int min = (st.isEmpty())? x: (st.peek().min>x)?x:st.peek().min;
    	
    	StackElement se = new StackElement(x, min);
        st.push(se);
       
    }
    
    public void pop() {
    	st.pop();
       
    }
    
    public int top() {
    	return st.peek().val;
    }
    
    public int getMin() {
        return st.peek().min;
    }
}

class StackElement{
	int val;
	int min;
	public StackElement(int val, int min) {
		super();
		this.val = val;
		this.min = min;
	}
	
}