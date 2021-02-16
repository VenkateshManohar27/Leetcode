package com.ven.leetcode.feb2021.challenge;

import java.util.HashMap;

public class CountNumberHomogenousSubstrings {
	/*public int countHomogenous(String s) {
		int mod  = 1000000007;
		HashMap<String, Integer> m = new HashMap<>();
		char[] a = s.toCharArray();
		for (int i = 0; i < a.length; i++) {
			for (int j = i; j < a.length; j++) {
				if (a[i] != a[j])
					break;
				String sub = new String(a, i, j - i + 1);

				m.put(sub, m.getOrDefault(sub, 0) + 1);
			}
		}
		int count = 0;
		for (int n : m.values()) {
			count += n;
			count = count%mod;
		}
		//System.out.println(m);
		return count;

	}*/

	public static void main(String[] args) {
		CountNumberHomogenousSubstrings c = new CountNumberHomogenousSubstrings();
		System.out.println(c.countHomogenous("abbcccaa"));
		System.out.println(c.countHomogenous("xy"));
		System.out.println(c.countHomogenous("zzzzz"));
	}

	public int countHomogenous(String s) {
		int mod =  1000000007;
		 // Size of the string  
        int n = s.length();  
      
        // Initialize count to 1  
        int count = 1;  
        int result = 0;  
      
        // Initialize left to 0 and  
        // right to 1 to traverse the  
        // string  
        int left = 0;  
        int right = 1;  
      
        while (right < n) 
        {  
      
            // Checking if consecutive  
            // characters are same and  
            // increment the count  
            if (s.charAt(left) == s.charAt(right)) 
            {  
                count++;  
            }  
      
            // When we encounter a  
            // different characters  
            else 
            {  
      
                // Increment the result  
                result += (count * (count + 1) / 2) %mod;  
               // result = result %mod;
                // To repeat the whole  
                // process set left equals  
                // right and count variable to 1  
                left = right;  
                count = 1;  
            }  
      
            right++;  
        }  
      
        // Store the final  
        // value of result  
        result +=(count * (count + 1) / 2) %mod;  
       // result = result %mod;
        return result;
	}
}
