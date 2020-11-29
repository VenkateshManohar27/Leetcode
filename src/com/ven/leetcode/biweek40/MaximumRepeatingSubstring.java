package com.ven.leetcode.biweek40;

public class MaximumRepeatingSubstring {
	public int maxRepeating(String sequence, String word) {
		int count = 0;
        if(sequence.equals(word)){
            return 1;
        }
        String w = new String(word);
        while(w.length() <= sequence.length()){
            if(sequence.indexOf(w) == -1){
                return count;
            }
            count++;
            w = w + word;
        }
        return count;
	}

	public static void main(String[] args) {
		MaximumRepeatingSubstring m = new MaximumRepeatingSubstring();
		System.out.println(m.maxRepeating("ababc", "ab"));
		System.out.println(m.maxRepeating("ababc", "ba"));
		System.out.println(m.maxRepeating("ababc", "ac"));
		System.out.println(m.maxRepeating("baba", "b"));
		System.out.println(m.maxRepeating("aaa", "a"));
		System.out.println(m.maxRepeating(
				"bbaabaabaabaaabbbaaabaababbabbaabbabbbabbabbabbbbabaababbbaaaababbbabbaababababbabbbaabbaabbbb",
				"bba"));
	}
}
