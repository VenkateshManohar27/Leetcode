package com.ven.leetcode.greedy;

public class HuffmanNode { 
	  
    private int data; 
    private char c; 
  
    HuffmanNode left; 
    HuffmanNode right;
    
	public HuffmanNode( char c, int data) {
		super();
		this.data = data;
		this.c = c;
	}

	public int getData() {
		return data;
	}

	public char getC() {
		return c;
	}
} 
