package com.ven.leetcode.week253;

public class CheckIfStringIsPrefixofArray {

	public boolean isPrefixString(String s, String[] words) {
		int i = 0;
		//int  = 0;
		int ind = 0;
		while(i < s.length() && ind < words.length) {
			String word = words[ind++];
			for (int j = 0; j < word.length(); j++) {
				if(i == s.length())
					return false;
				if(s.charAt(i) == word.charAt(j)) {
					i++;
				}else {
					return false;
				}
			}
		}
		
		return i == s.length();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CheckIfStringIsPrefixofArray c = new CheckIfStringIsPrefixofArray();
		/**
		 * "iloveleetcode"
["i","love","leetcode","apples"]
"iloveleetcode"
["apples","i","love","leetcode"]
"a"
["aa","aaaa","banana"]
		 */
		System.out.println(c.isPrefixString("iloveleetcode", new String[] {"i","love","leetcode","apples"}));
		System.out.println(c.isPrefixString("iloveleetcode", new String[] {"apples","i","love","leetcode"}));
		System.out.println(c.isPrefixString("iloveleetcode", new String[] {"i","love","leetcod"}));
		System.out.println(c.isPrefixString("a", new String[] {"aa","aaaa","banana"}));
	}
}
