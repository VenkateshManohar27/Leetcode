package com.ven.leetcode.easy;

/**
 * Write a function that takes a string as input and reverse only the vowels of
 * a string.
 * 
 * Example 1:
 * 
 * Input: "hello" Output: "holle"
 * 
 * Example 2:
 * 
 * Input: "leetcode" Output: "leotcede"
 * 
 * Note: The vowels does not include the letter "y".
 * 
 * @author Venkatesh Manohar
 *
 */
public class ReverseVowels {
	public String reverseVowels(String s) {
		char[] chars = s.toCharArray();
		int i = 0, j = chars.length - 1;
		while (i < j) {

			while (!isVowel(chars[i]) && i < j) {
				i++;
			}

			while (!isVowel(chars[j]) && i < j) {
				j--;
			}

			char temp = chars[i];
			chars[i++] = chars[j];
			chars[j--] = temp;
		}

		return String.valueOf(chars);
	}
	
	public String reverseVowelsOptimized(String s) {
		int i = 0, j = s.length() - 1;
		while (i < j) {

			while (!isVowel(s.charAt(i)) && i < j) {
				i++;
			}

			while (!isVowel(s.charAt(j)) && i < j) {
				j--;
			}

			char temp = s.charAt(i);
			s = s.replace(s.charAt(i), s.charAt(j)).replace(s.charAt(j), temp);
			i++;
			j--;
		}
		return s;
	}

	public boolean isVowel(char c) {
		if (c == 'A' || c == 'a' || c == 'E' || c == 'e' || c == 'I' || c == 'i' || c == 'O' || c == 'o' || c == 'U'
				|| c == 'u') {
			return true;
		}
		return false;
	}
}
