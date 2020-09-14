package com.ven.leetcode.sepchallenge;

/**
 * You are playing the following Bulls and Cows game with your friend: You write
 * down a number and ask your friend to guess what the number is. Each time your
 * friend makes a guess, you provide a hint that indicates how many digits in
 * said guess match your secret number exactly in both digit and position
 * (called "bulls") and how many digits match the secret number but locate in
 * the wrong position (called "cows"). Your friend will use successive guesses
 * and hints to eventually derive the secret number.
 * 
 * Write a function to return a hint according to the secret number and friend's
 * guess, use A to indicate the bulls and B to indicate the cows.
 * 
 * Please note that both secret number and friend's guess may contain duplicate
 * digits.
 * 
 * Example 1:
 * 
 * Input: secret = "1807", guess = "7810"
 * 
 * Output: "1A3B"
 * 
 * Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.
 * Example 2:
 * 
 * Input: secret = "1123", guess = "0111"
 * 
 * Output: "1A1B"
 * 
 * Explanation: The 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a
 * cow. Note: You may assume that the secret number and your friend's guess only
 * contain digits, and their lengths are always equal.
 * 
 * @author Venkatesh Manohar
 *
 */
public class BullsCows {
	public String getHint(String secret, String guess) {
        if(secret == null || secret.length() == 0){
            return "";
        }
        int bulls = 0;
        int cows = 0;
        int[] nums = new int[10];
        for(int i = 0;i <secret.length(); i++){
            nums[secret.charAt(i)-'0']++;
           // System.out.println(nums[secret.charAt(i)-'0']);
        }
        for(int i = 0;i <secret.length(); i++){
            if(secret.charAt(i) == guess.charAt(i) ){
                nums[guess.charAt(i)-'0']--;
                bulls++;
            }
        }
        
        for(int i = 0;i <secret.length(); i++){
            if(secret.charAt(i) != guess.charAt(i) ){
                if(nums[guess.charAt(i)-'0'] > 0){
                    nums[guess.charAt(i)-'0']--;  
                    cows++;
                }
            }
        }
        StringBuilder sb = new StringBuilder("");
        sb.append(bulls);
        sb.append("A");
        sb.append(cows);
        sb.append("B");
        
        return sb.toString();
    }
	
	public static void main(String[] args) {
		BullsCows b = new BullsCows();
		System.out.println(b.getHint("1807", "7801"));
		System.out.println(b.getHint("1123", "0111"));
	}
}
