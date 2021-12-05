package com.ven.leetcode.sep2021.challenge;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * You are given a string s and an integer k. You can choose one of the first k
 * letters of s and append it at the end of the string..
 * 
 * Return the lexicographically smallest string you could have after applying
 * the mentioned step any number of moves.
 * 
 * Example 1:
 * 
 * Input: s = "cba", k = 1 Output: "acb" Explanation: In the first move, we move
 * the 1st character 'c' to the end, obtaining the string "bac". In the second
 * move, we move the 1st character 'b' to the end, obtaining the final result
 * "acb". Example 2:
 * 
 * Input: s = "baaca", k = 3 Output: "aaabc" Explanation: In the first move, we
 * move the 1st character 'b' to the end, obtaining the string "aacab". In the
 * second move, we move the 3rd character 'c' to the end, obtaining the final
 * result "aaabc".
 * 
 * Constraints:
 * 
 * 1 <= k <= s.length <= 1000 s consist of lowercase English letters.
 * 
 * @author Venkatesh Manohar
 *
 */
public class OrderlyQueue {
	public String orderlyQueue(String s, int k) {
		if(k > 1) {
			char[] c = s.toCharArray();
			Arrays.sort(c);
			
			return new String(c);
		}
		String res = s;
        for (int i = 0; i < s.length(); i++) {
            String tmp = s.substring(i) + s.substring(0, i);
            if (res.compareTo(tmp) > 0) res = tmp;
        }
        return res;
	}
	
	public static void main(String[] args) {
		
		OrderlyQueue q = new OrderlyQueue();
		System.out.println(q.orderlyQueue("cba", 1));
		System.out.println(q.orderlyQueue("baaca", 3));
		
	}
}
