package com.ven.leetcode.sep2021.challenge;

/**
 * Given a string s, reverse the string according to the following rules:
 * 
 * All the characters that are not English letters remain in the same position.
 * All the English letters (lowercase or uppercase) should be reversed. Return s
 * after reversing it.
 * 
 * Example 1:
 * 
 * Input: s = "ab-cd" Output: "dc-ba" Example 2:
 * 
 * Input: s = "a-bC-dEf-ghIj" Output: "j-Ih-gfE-dCba" Example 3:
 * 
 * Input: s = "Test1ng-Leet=code-Q!" Output: "Qedo1ct-eeLg=ntse-T!"
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 100 s consists of characters with ASCII values in the range
 * [33, 122]. s does not contain '\"' or '\\'.
 * 
 * @author Venkatesh Manohar
 *
 */
public class ReverseOnlyLetters {
	public String reverseOnlyLetters(String s) {
        char[] ch = s.toCharArray();
        int n = s.length();
        int i= 0, j = n-1;
        
        while(i < j){
            while(i < n && !((ch[i] >= 'a' && ch[i] <= 'z') || (ch[i] >= 'A' && ch[i] <= 'Z'))){
                i++;
            }
            if(i == n || i > j)
                break;
            while(j >= 0 && !((ch[j] >= 'a' && ch[j] <= 'z') || (ch[j] >= 'A' && ch[j] <= 'Z'))){
                j--;
            }
            if(j < 0 || i > j){
                break;
            }
            
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
            i++;
            j--;
        }
        
        return new String(ch);
    }
	
	public static void main(String[] args) {
		ReverseOnlyLetters r = new ReverseOnlyLetters();
		System.out.println(r.reverseOnlyLetters("?6C40E"));
		System.out.println(r.reverseOnlyLetters("7_28]"));
		System.out.println(r.reverseOnlyLetters("Test1ng-Leet=code-Q!"));
		System.out.println(r.reverseOnlyLetters("a-bC-dEf-ghIj"));
		System.out.println(r.reverseOnlyLetters("ab-cd"));
	}
}
