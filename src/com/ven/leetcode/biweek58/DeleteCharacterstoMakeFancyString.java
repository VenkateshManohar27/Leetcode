package com.ven.leetcode.biweek58;

public class DeleteCharacterstoMakeFancyString {

	public String makeFancyString(String s) {
		//char[] chr = s.toCharArray();

		if (s.length() < 3) {
			return s;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(s.charAt(0));
		sb.append(s.charAt(1));
		for (int i = 2; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == sb.charAt(sb.length()-1) && c ==  sb.charAt(sb.length()-2)) {
				continue;
			}
			sb.append(c);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		DeleteCharacterstoMakeFancyString a = new DeleteCharacterstoMakeFancyString();
		System.out.println(a.makeFancyString("leeetcode"));
		System.out.println(a.makeFancyString("aaabaaaa"));
		System.out.println(a.makeFancyString("aab"));

	}

}
