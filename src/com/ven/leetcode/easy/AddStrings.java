package com.ven.leetcode.easy;

public class AddStrings {
	public static String addStrings(String num1, String num2) {
		StringBuilder sb = new StringBuilder();
		int i = num1.length() - 1, j = num2.length() - 1;
		int carry = 0;
		while (i >= 0 || j >= 0) {
			int a = (i >= 0) ? (int) num1.charAt(i--) - '0' : 0;
			int b = (j >= 0) ? (int) num2.charAt(j--) - '0' : 0;
			int sum = a + b + carry;
			carry = sum / 10;

			sb.insert(0, sum % 10);
		}
		if(carry>0)sb.insert(0, carry);
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(addStrings("0","0"));
		System.out.println(addStrings("10","10"));
		System.out.println(addStrings("1","1"));
		System.out.println(addStrings("9","1"));
		System.out.println(addStrings("19","21"));
		System.out.println(addStrings("100","1"));
		System.out.println(addStrings("100","111"));
		System.out.println(addStrings("999","1"));
		System.out.println(addStrings("19990","10"));
		System.out.println(addStrings("9990","10"));
	}
}
