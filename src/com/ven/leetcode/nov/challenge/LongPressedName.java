package com.ven.leetcode.nov.challenge;

/**
 * Your friend is typing his name into a keyboard. Sometimes, when typing a
 * character c, the key might get long pressed, and the character will be typed
 * 1 or more times.
 * 
 * You examine the typed characters of the keyboard. Return True if it is
 * possible that it was your friends name, with some characters (possibly none)
 * being long pressed.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: name = "alex", typed = "aaleex" Output: true Explanation: 'a' and 'e'
 * in 'alex' were long pressed. Example 2:
 * 
 * Input: name = "saeed", typed = "ssaaedd" Output: false Explanation: 'e' must
 * have been pressed twice, but it wasn't in the typed output. Example 3:
 * 
 * Input: name = "leelee", typed = "lleeelee" Output: true Example 4:
 * 
 * Input: name = "laiden", typed = "laiden" Output: true Explanation: It's not
 * necessary to long press any character.
 * 
 * 
 * Constraints:
 * 
 * 1 <= name.length <= 1000 1 <= typed.length <= 1000 The characters of name and
 * typed are lowercase letters.
 * 
 * @author Venkatesh Manohar
 *
 */
public class LongPressedName {
	public boolean isLongPressedName(String name, String typed) {
        int n = 0;
        int t = 0;
        if(name.equals(typed)){
            return true;
        }
        while(n < name.length() && t < typed.length()){
            while(n < name.length() && t < typed.length() && name.charAt(n) == typed.charAt(t)){
                n++;
                t++;
            }
            while(t < typed.length() && n> 0 && typed.charAt(t) == name.charAt(n-1)){
                t++;
            }
            if(n < name.length() && t < typed.length() && name.charAt(n) != typed.charAt(t)){
                return false;
            }
        }
        return n == name.length() && t == typed.length();
    }
	
	public static void main(String[] args) {
		LongPressedName l = new LongPressedName();
		System.out.println(l.isLongPressedName("alex", "aaleex"));
		System.out.println(l.isLongPressedName("saeed", "ssaaedd"));
		System.out.println(l.isLongPressedName("leelee", "lleeelee"));
		System.out.println(l.isLongPressedName("laiden", "laiden"));
		System.out.println(l.isLongPressedName("test", "aest"));
		System.out.println(l.isLongPressedName("pyplrz", "ppyypllr"));
	}
}
