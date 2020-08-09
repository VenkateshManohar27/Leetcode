package com.ven.leetcode.julchallenge;

public class ReverseWordsString {
	public String reverseWords(String s) {
		if(s ==  null || s.length() == 0) {
			return s;
		}
		s = s.trim();
		String[] strs = s.split("\\s+");
		/*int i = 0;
		int j = strs.length - 1;

		while (i < j) {
			while(strs[i].equals(" ")) {
				i++;
			}
			while(strs[j].equals(" ")) {
				j--;
			}
			String temp = strs[i];
			strs[i] = strs[j];
			strs[j] = temp;
			i++;
			j--;
		}
		return String.join(" ", strs);*/
		
		StringBuilder sb = new StringBuilder();
		for (int k = strs.length -1; k >=0; k--) {
			sb.append(strs[k]+ " ");
			if(k != 0) {
				sb.append(" ");
			}
		}
		return sb.toString().trim();
	}

	public static void main(String[] args) {
		ReverseWordsString r = new ReverseWordsString();
		System.out.println(r.reverseWords(""));

		System.out.println(r.reverseWords("the sky is blue"));
		System.out.println(r.reverseWords("  hello world!  "));
		System.out.println(r.reverseWords("a good   example"));

	}
}
