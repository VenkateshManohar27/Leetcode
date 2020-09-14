package com.ven.leetcode.sepchallenge;

public class CompareVersionNumbers {
	public int compareVersion(String version1, String version2) {
		String[] charArray1 = version1.split("\\.");
        String[] charArray2 = version2.split("\\."); 
        
        for (int i = 0; i < charArray1.length || i < charArray2.length; i++) {
            String char1 = i >= charArray1.length ? "0" : charArray1[i];
            String char2 = i >= charArray2.length ? "0" : charArray2[i];
            
            int num1 = Integer.valueOf(char1);
            int num2 = Integer.valueOf(char2);
            
            if (num1 < num2) {
                return -1;
            } else if (num1 > num2) {
                return 1;
            }
        }
        
        return 0;
	}
}
