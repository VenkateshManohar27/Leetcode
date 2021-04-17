package com.ven.leetcode.apr2021.challenge;

import java.util.Stack;

/**
 * You are given a string s and an integer k, a k duplicate removal consists of
 * choosing k adjacent and equal letters from s and removing them, causing the
 * left and the right side of the deleted substring to concatenate together.
 * 
 * We repeatedly make k duplicate removals on s until we no longer can.
 * 
 * Return the final string after all such duplicate removals have been made. It
 * is guaranteed that the answer is unique.
 * 
 * Example 1:
 * 
 * Input: s = "abcd", k = 2 Output: "abcd" Explanation: There's nothing to
 * delete. Example 2:
 * 
 * Input: s = "deeedbbcccbdaa", k = 3 Output: "aa" Explanation: First delete
 * "eee" and "ccc", get "ddbbbdaa" Then delete "bbb", get "dddaa" Finally delete
 * "ddd", get "aa" Example 3:
 * 
 * Input: s = "pbbcggttciiippooaais", k = 2 Output: "ps"
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 105 2 <= k <= 104 s only contains lower case English
 * letters.
 * 
 * @author Venkatesh Manohar
 *
 */
class Pair{
    private char c;
    private int count = 0;
    public Pair(char c){
        this.c = c;
        count = 1;
    }
    public char getChar(){
        return c;
    }
    
    public int getCount(){
        return count;
    }
    public void increaseCount(){
        count++;
    }
}
public class RemoveAllAdjacentDuplicatesStringII {
    public String removeDuplicates(String s, int k) {
        Stack<Pair> st = new Stack<>();
        //st.push(new Pair(s.charAt(0)));
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!st.isEmpty() && st.peek().getChar() == c){
                st.peek().increaseCount();
                if(st.peek().getCount() == k){
                    st.pop();
                }
            }else{
                st.push(new Pair(s.charAt(i)));
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            Pair p = st.pop();
            char c = p.getChar();
            int count = p.getCount(); 
            while(count > 0){
                sb.insert(0, c);
                count--;
            }
        }
        return sb.toString();
    }
}
