package com.ven.leetcode.augchallenge;

/**
 * Given a word, you need to judge whether the usage of capitals in it is right
 * or not.
 * 
 * We define the usage of capitals in a word to be right when one of the
 * following cases holds:
 * 
 * All letters in this word are capitals, like "USA". All letters in this word
 * are not capitals, like "leetcode". Only the first letter in this word is
 * capital, like "Google". Otherwise, we define that this word doesn't use
 * capitals in a right way.
 * 
 * 
 * Example 1:
 * 
 * Input: "USA" Output: True
 * 
 * 
 * Example 2:
 * 
 * Input: "FlaG" Output: False
 * 
 * 
 * Note: The input will be a non-empty word consisting of uppercase and
 * lowercase latin letters.
 * 
 * @author Venkatesh Manohar
 *
 */
public class DetectCapital {
	public boolean detectCapitalUse(String word) {
		String UPPERCASE = word.toUpperCase();
		String LOWERCASE = word.toLowerCase();
		StringBuilder camelCase = new StringBuilder();
		camelCase.append(Character.toUpperCase(word.charAt(0)));
		camelCase.append(word.substring(1).toLowerCase());

		return UPPERCASE.equals(word) || LOWERCASE.equals(word) || camelCase.toString().equals(word);
	}

	public static void main(String[] args) {
		DetectCapital dc = new DetectCapital();
		System.out.println(dc.detectCapitalUse("USA"));
		System.out.println(dc.detectCapitalUse("FlaG"));
		System.out.println(dc.detectCapitalUse("Growth"));
		System.out.println(dc.detectCapitalUse("test"));
		
	}
}
