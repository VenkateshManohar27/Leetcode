package com.ven.leetcode.jan2021.challenge;

/**
 * Suppose you have n integers from 1 to n. We define a beautiful arrangement as
 * an array that is constructed by these n numbers successfully if one of the
 * following is true for the ith position (1 <= i <= n) in this array:
 * 
 * The number at the ith position is divisible by i. i is divisible by the
 * number at the ith position. Given an integer n, return the number of the
 * beautiful arrangements that you can construct.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = 2 Output: 2 Explanation: The first beautiful arrangement is [1,
 * 2]: Number at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).
 * Number at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2). The
 * second beautiful arrangement is [2, 1]: Number at the 1st position (i=1) is
 * 2, and 2 is divisible by i (i=1). Number at the 2nd position (i=2) is 1, and
 * i (i=2) is divisible by 1. Example 2:
 * 
 * Input: n = 1 Output: 1
 * 
 * 
 * Constraints:
 * 
 * 1 <= n <= 15
 * 
 * @author Venkatesh Manohar
 *
 */
public class BeautifulArrangement {
	private int count = 0;
	public int countArrangement(int n) {
		count = 0;
        boolean[] visited =  new boolean[n+1];
        helper(1,n,visited);
        return count;
    }
	
	private void helper(int pos, int n, boolean[] visited) {
		if(pos > n) {
			count++;
			//System.out.println();
			return;
		}
		for(int i = 1; i<= n; i++) {
			if(!visited[i] && (pos % i ==0 || i % pos == 0)) {
				//System.out.print(" p:"+pos+" ,i:"+i);
				visited[i] = true;
				helper(pos+1, n, visited);
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) {
		BeautifulArrangement b = new BeautifulArrangement();
		System.out.println(b.countArrangement(1));
		System.out.println(b.countArrangement(2));
		System.out.println(b.countArrangement(3));
		System.out.println(b.countArrangement(4));
		System.out.println(b.countArrangement(5));
		System.out.println(b.countArrangement(6));
	}
	
	
}
