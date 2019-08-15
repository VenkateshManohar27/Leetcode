package com.ven.leetcode.greedy;

public class HuffmanNode { 
	  
    private int frequency; 
    private char c; 
  
    HuffmanNode left; 
    HuffmanNode right;
    
	public HuffmanNode( char c, int data) {
		super();
		this.frequency = data;
		this.c = c;
	}

	public int getFrequency() {
		return frequency;
	}

	public char getC() {
		return c;
	}
} 
