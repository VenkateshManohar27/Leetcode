package com.ven.leetcode.dp;

public class IsSubsequence {
	public boolean isSubsequence(String s, String t) {
		if (s == null || t == null) {
			return false;
		}

		return isSubsequence(s, t, 0, 0);
	}

	private boolean isSubsequence(String s, String t, int indexS, int indexT) {
		if(indexS == s.length()){
	        return true;
	    }else if(indexT == t.length()){
	        return false;
	    }

		if (s.charAt(indexS) == t.charAt(indexT)) {
			return isSubsequence(s, t, indexS + 1, indexT + 1);

		} else {
			return isSubsequence(s, t, indexS, indexT + 1);
		}

	}
	
	public boolean isSubsequenceOptimized(String s, String t) {
		if (s == null || t == null) {
			return false;
		}
		int index = 0;
		for(char c : s.toCharArray()) {
			index = t.indexOf(c, index);
			if(index < 0) {
				return false;
			}else {
				index++;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		IsSubsequence s = new IsSubsequence();
		System.out.println("s.isSubsequence(\"abc\", \"ahbgdc\") is " + s.isSubsequence("abc", "ahbgdc"));
		System.out.println("s.isSubsequence(\"\", \"ahbgdc\") is " + s.isSubsequence("", "ahbgdc"));
		System.out.println("s.isSubsequence(\"\", \"\") is " + s.isSubsequence("", ""));
		System.out.println("s.isSubsequence(\"abc\", \"ahbgdc\") is " + s.isSubsequence("abc", "ahbgdc"));
		System.out.println("s.isSubsequence(\"abc\", \"ahbgdc\") is " + s.isSubsequence("abc", "ahbgdc"));
	}
}
