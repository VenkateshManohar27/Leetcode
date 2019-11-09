package com.vm.practice;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 * 
 * Example 1:
 * 
 * Input: 123 Output: 321 Example 2:
 * 
 * Input: -123 Output: -321 Example 3:
 * 
 * Input: 120 Output: 21
 * 
 * @author Venkatesh Manohar
 *
 */
public class ReverseInteger {
	public int reverse(int x) {
		int reverse = 0;
		while(x != 0) {
			if(reverse > Integer.MAX_VALUE /10 || reverse < Integer.MIN_VALUE /10)
                return 0;
			reverse *=10;
			reverse += x % 10;
			x/=10;
		}
		return reverse;
	}

	public static void main(String[] args) {
		ReverseInteger ri = new ReverseInteger();
		System.out.println(ri.reverse(123));
		System.out.println(ri.reverse(-123));
		System.out.println(ri.reverse(120));
		System.out.println(ri.reverse(1534236469));
	}
}
