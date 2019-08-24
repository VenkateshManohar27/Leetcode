package com.ven.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
	public List<String> letterCasePermutation(String S) {
		List<String> li = new ArrayList<>();
		if(S == null || S.length()==0) {
			return li;
		}
		
		letterCasePermutation(S.toCharArray(), 0, li);
		return li;
	}

	private void letterCasePermutation(char[] charArray, int pos, List<String> li) {
		if(pos == charArray.length) {
			li.add(new String(charArray));
			return;
		}
		
		if(Character.isDigit(charArray[pos])) {
			letterCasePermutation(charArray, pos+1,li);
			return;
		}
		
		charArray[pos] = Character.toLowerCase(charArray[pos]);
		letterCasePermutation(charArray, pos+1,li);
		charArray[pos] = Character.toUpperCase(charArray[pos]);
		letterCasePermutation(charArray, pos+1,li);
	}
	
	public static void main(String[] args) {
		LetterCasePermutation lcp = new LetterCasePermutation();
		List<String> list =lcp.letterCasePermutation("a1b2");
		
		for(String s: list) {
			System.out.println(s);
		}
	}
}
