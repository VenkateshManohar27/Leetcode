package com.ven.leetcode.augchallenge;

import java.util.HashSet;

/**
 * A sentence S is given, composed of words separated by spaces. Each word
 * consists of lowercase and uppercase letters only.
 * 
 * We would like to convert the sentence to "Goat Latin" (a made-up language
 * similar to Pig Latin.)
 * 
 * The rules of Goat Latin are as follows:
 * 
 * If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of
 * the word. For example, the word 'apple' becomes 'applema'.
 * 
 * If a word begins with a consonant (i.e. not a vowel), remove the first letter
 * and append it to the end, then add "ma". For example, the word "goat" becomes
 * "oatgma".
 * 
 * Add one letter 'a' to the end of each word per its word index in the
 * sentence, starting with 1. For example, the first word gets "a" added to the
 * end, the second word gets "aa" added to the end and so on. Return the final
 * sentence representing the conversion from S to Goat Latin.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: "I speak Goat Latin" Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
 * Example 2:
 * 
 * Input: "The quick brown fox jumped over the lazy dog" Output: "heTmaa
 * uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa
 * azylmaaaaaaaaa ogdmaaaaaaaaaa"
 * 
 * 
 * Notes:
 * 
 * S contains only uppercase, lowercase and spaces. Exactly one space between
 * each word. 1 <= S.length <= 150.
 * 
 * @author Venkatesh Manohar
 *
 */
public class GoatLatin {
	public String toGoatLatin(String S) {
		if (S == null || S.length() == 0) {
			return "";
		}
		HashSet<Character> set = new HashSet<>();
		set.add('A');
		set.add('E');
		set.add('I');
		set.add('O');
		set.add('U');
		set.add('a');
		set.add('e');
		set.add('i');
		set.add('o');
		set.add('u');

		S = S.trim();
		String[] strs = S.split(" ");
		StringBuilder a = new StringBuilder();
		for (int i = 0; i < strs.length; i++) {
			a.append("a");
			StringBuilder sb = new StringBuilder(strs[i]);
			if (set.contains(sb.charAt(0))) {
				sb.append("ma");
				sb.append(a.toString());
			} else {
				char firstchar = sb.charAt(0);
				sb.delete(0, 1);
				sb.append(firstchar).append("ma").append(a.toString());
			}
			strs[i] = sb.toString();

		}
		return String.join(" ", strs);
	}

	public static void main(String[] args) {
		GoatLatin g = new GoatLatin();
		System.out.println(g.toGoatLatin("I speak Goat Latin"));
		System.out.println(g.toGoatLatin("The quick brown fox jumped over the lazy dog"));
	}
}
