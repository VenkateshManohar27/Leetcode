package com.ven.leetcode.week4;

import java.util.HashMap;

/**
 * Given a positive integer n, you can apply one of the following operations:
 * 
 * If n is even, replace n with n / 2. If n is odd, replace n with either n + 1
 * or n - 1. Return the minimum number of operations needed for n to become 1.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = 8 Output: 3 Explanation: 8 -> 4 -> 2 -> 1 Example 2:
 * 
 * Input: n = 7 Output: 4 Explanation: 7 -> 8 -> 4 -> 2 -> 1 or 7 -> 6 -> 3 -> 2
 * -> 1 Example 3:
 * 
 * Input: n = 4 Output: 2
 * 
 * 
 * Constraints:
 * 
 * 1 <= n <= 231 - 1
 * 
 * @author Venkatesh Manohar
 *
 */
public class IntegerReplacement {
	public int integerReplacement(int n) {
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        map.put(1L, 0);
        return find(n, map);
    }
    
    private int find(long x, HashMap<Long, Integer> map){
        if(!map.containsKey(x)){
            if((x & 1) == 0)
                map.put(x, 1 + find(x >> 1, map));
            else{
                if(x == 1)
                    return 0;
                else
                    map.put(x, 1 + Math.min(find(x + 1, map), find(x - 1, map)));
            }
        }
        
        return map.get(x);
    }
    
    public int integerReplacement2(int n) {
        if(n < 2){
            return 0;
        }
        
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        
        for(int i = 3; i<=n; i++) {
            int op = 0;
            if(i % 2 == 0){
                op = 1+ dp[i/2];
            }else{
                op = 1+ Math.min(dp[i-1], 1+dp[(i+1)/2]);
            }
            dp[i] = op;
        }
        return dp[n];
        
    }
    
    public static void main(String[] args) {
    	IntegerReplacement i = new IntegerReplacement();
    	System.out.println(i.integerReplacement(65335));
    	System.out.println(i.integerReplacement2(65335));
    	System.out.println(i.integerReplacement(65535));
    	System.out.println(i.integerReplacement2(65535));
    	
	}
}
