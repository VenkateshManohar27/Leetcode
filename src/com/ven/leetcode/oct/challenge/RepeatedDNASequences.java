package com.ven.leetcode.oct.challenge;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * All DNA is composed of a series of nucleotides abbreviated as 'A', 'C', 'G',
 * and 'T', for example: "ACGAATTCCG". When studying DNA, it is sometimes useful
 * to identify repeated sequences within the DNA.
 * 
 * Write a function to find all the 10-letter-long sequences (substrings) that
 * occur more than once in a DNA molecule.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT" Output:
 * ["AAAAACCCCC","CCCCCAAAAA"] Example 2:
 * 
 * Input: s = "AAAAAAAAAAAAA" Output: ["AAAAAAAAAA"]
 * 
 * 
 * Constraints:
 * 
 * 0 <= s.length <= 105 s[i] is 'A', 'C', 'G', or 'T'.
 * 
 * @author Venkatesh Manohar
 *
 */
public class RepeatedDNASequences {
	public List<String> findRepeatedDnaSequences(String s) {
        List<String> li = null;
        if(s == null || s.length() <=10){
            return new ArrayList<String>();
        }
        
        Set<String> patterns = new HashSet<>(); 
        Set<String> duplicates = new HashSet<>(); 
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            sb.append(s.charAt(i));
            if(i >= 9){
                if(patterns.contains(sb.toString())) {
                	duplicates.add(sb.toString());
                }
                patterns.add(sb.toString());
                sb.deleteCharAt(0);
            }
        }
        li = new ArrayList<>(duplicates);
        return li;
    }
	
	public static void main(String[] args) {
		RepeatedDNASequences r = new RepeatedDNASequences();
		System.out.println(r.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
		System.out.println(r.findRepeatedDnaSequences("AAAAAAAAAAAAA"));
	}
}
