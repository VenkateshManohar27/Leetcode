package com.ven.leetcode.biweek58;

import java.util.ArrayList;
import java.util.Vector;

public class MinimumNumberofSwapstoMaketheStringBalanced {
	// public int minSwaps(String s) {
	public int minSwaps(String s) {
		Vector<Integer> pos = new Vector<>();
		char[] str = s.toCharArray();
		for (int i = 0; i < str.length; ++i) {
			if (str[i] == '[') {
				pos.add(i);
			}
		}

		int count = 0; // required count number of encountered '['
		int p = 0; // used to track position of next '[' in pos
		int result = 0; // used to store result

		for (int i = 0; i < str.length; ++i) {
			// When '[' is encountered,
			// increment count and move p to next position

			if (str[i] == '[') {
				++count;
				++p;
			} else if (str[i] == ']')
				--count;

			if (count < 0) {
				result += pos.get(p) - i;
				swap(i, pos.get(p), str);
				++p;

				// reset count to 1
				count = 1;
			}
		}
		return result;
	}

	private void swap(int c, int d, char[] ch) {
		// TODO Auto-generated method stub
		char temp = ch[c];
		ch[c] = ch[d];
		ch[d] = temp;
	}

	public static void main(String[] args) {
		MinimumNumberofSwapstoMaketheStringBalanced m = new MinimumNumberofSwapstoMaketheStringBalanced();

		System.out.println(m.minSwaps("][]["));
		System.out.println(m.minSwaps("]]][[["));
		System.out.println(m.minSwaps("[]"));
	}
}
