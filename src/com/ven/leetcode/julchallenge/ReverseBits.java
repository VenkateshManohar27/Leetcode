package com.ven.leetcode.julchallenge;

/**
 * Reverse bits of a given 32 bits unsigned integer.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: 00000010100101000001111010011100 Output:
 * 00111001011110000010100101000000 Explanation: The input binary string
 * 00000010100101000001111010011100 represents the unsigned integer 43261596, so
 * return 964176192 which its binary representation is
 * 00111001011110000010100101000000. Example 2:
 * 
 * Input: 11111111111111111111111111111101 Output:
 * 10111111111111111111111111111111 Explanation: The input binary string
 * 11111111111111111111111111111101 represents the unsigned integer 4294967293,
 * so return 3221225471 which its binary representation is
 * 10111111111111111111111111111111.
 * 
 * 
 * Note:
 * 
 * Note that in some languages such as Java, there is no unsigned integer type.
 * In this case, both input and output will be given as signed integer type and
 * should not affect your implementation, as the internal binary representation
 * of the integer is the same whether it is signed or unsigned. In Java, the
 * compiler represents the signed integers using 2's complement notation.
 * Therefore, in Example 2 above the input represents the signed integer -3 and
 * the output represents the signed integer -1073741825.
 * 
 * @author Venkatesh Manohar
 *
 */
public class ReverseBits {
	public int reverseBits(int n) {
		char[] bits = new char[32];

		for (int i = 31; i >= 0; i--) {
			int mask = 1 << i;
			bits[31 - i] = ((n & mask) != 0) ? '1' : '0';
		}
		int i = 0;
		int j = bits.length - 1;
		while (i < j) {
			char c = bits[i];
			bits[i] = bits[j];
			bits[j] = c;

			i++;
			j--;
		}

		return (int) Long.parseLong(String.copyValueOf(bits), 2);
	}

	public int reverseBitsOptimized(int n) {
		int ans = 0;
		for (int i = 0; i < 32; i++) {
			ans <<= 1;
			ans = ans | (n & 1);
			n >>= 1;
		}
		return ans;
	}

	public static void main(String[] args) {
		ReverseBits r = new ReverseBits();
		System.out.println(r.reverseBits(0));
		System.out.println(r.reverseBits(1));
		System.out.println(r.reverseBits(3));
		System.out.println(r.reverseBits(8));
		System.out.println(r.reverseBits(27));
		System.out.println(r.reverseBits(Integer.MAX_VALUE));
		System.out.println(r.reverseBits(-3));
		System.out.println(r.reverseBits(43261596));
		System.out.println("----------------------------------------------------------------");
		System.out.println(r.reverseBitsOptimized(0));
		System.out.println(r.reverseBitsOptimized(1));
		System.out.println(r.reverseBitsOptimized(3));
		System.out.println(r.reverseBitsOptimized(8));
		System.out.println(r.reverseBitsOptimized(27));
		System.out.println(r.reverseBitsOptimized(Integer.MAX_VALUE));
		System.out.println(r.reverseBitsOptimized(-3));
		System.out.println(r.reverseBitsOptimized(43261596));
	}
}
