package com.ven.leetcode.feb2021.challenge;

import com.ven.utility.ArrayUtility;

/**
 * Given a string s and a character c that occurs in s, return an array of
 * integers answer where answer.length == s.length and answer[i] is the shortest
 * distance from s[i] to the character c in s.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "loveleetcode", c = "e" Output: [3,2,1,0,1,0,0,1,2,2,1,0] Example
 * 2:
 * 
 * Input: s = "aaab", c = "b" Output: [3,2,1,0]
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 104 s[i] and c are lowercase English letters. c occurs at
 * least once in s.
 * 
 * @author Venkatesh Manohar
 *
 */
public class ShortestDistancetoCharacter {
	public int[] shortestToChar(String s, char c) {
        int prevIndex = Integer.MAX_VALUE;
        int nextIndex = 0;
        int[] res = new int[s.length()];
        for(int i = 0; i<s.length(); i++){
            if(i == nextIndex){
                if(i > 0 || s.charAt(i) == c){
                    prevIndex = nextIndex;
                }
                nextIndex = s.indexOf(c, nextIndex+1);
                
            }
            
            res[i] = Math.min(Math.abs(nextIndex - i), Math.abs(i-prevIndex));
            
        }
        return res;
    }
	
	public static void main(String[] args) {
		ShortestDistancetoCharacter s = new ShortestDistancetoCharacter();
		ArrayUtility.print(s.shortestToChar("bb", 'b'));
	}
}
