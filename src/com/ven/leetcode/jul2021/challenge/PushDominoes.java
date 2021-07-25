package com.ven.leetcode.jul2021.challenge;

/**
 * There are n dominoes in a line, and we place each domino vertically upright.
 * In the beginning, we simultaneously push some of the dominoes either to the
 * left or to the right.
 * 
 * After each second, each domino that is falling to the left pushes the
 * adjacent domino on the left. Similarly, the dominoes falling to the right
 * push their adjacent dominoes standing on the right.
 * 
 * When a vertical domino has dominoes falling on it from both sides, it stays
 * still due to the balance of the forces.
 * 
 * For the purposes of this question, we will consider that a falling domino
 * expends no additional force to a falling or already fallen domino.
 * 
 * You are given a string dominoes representing the initial state where:
 * 
 * dominoes[i] = 'L', if the ith domino has been pushed to the left, dominoes[i]
 * = 'R', if the ith domino has been pushed to the right, and dominoes[i] = '.',
 * if the ith domino has not been pushed. Return a string representing the final
 * state.
 * 
 * Example 1:
 * 
 * Input: dominoes = "RR.L" Output: "RR.L" Explanation: The first domino expends
 * no additional force on the second domino. Example 2:
 * 
 * 
 * Input: dominoes = ".L.R...LR..L.." Output: "LL.RR.LLRRLL.."
 * 
 * 
 * Constraints:
 * 
 * n == dominoes.length 1 <= n <= 105 dominoes[i] is either 'L', 'R', or '.'.
 * 
 * @author Venkatesh Manohar
 *
 */
public class PushDominoes {
	public String pushDominoes(String d) {
		d = 'L' + d + 'R';
		StringBuilder res = new StringBuilder();
		for (int i = 0, j = 1; j < d.length(); ++j) {
			if (d.charAt(j) == '.')
				continue;
			int middle = j - i - 1;
			if (i > 0)
				res.append(d.charAt(i));
			if (d.charAt(i) == d.charAt(j))
				for (int k = 0; k < middle; k++)
					res.append(d.charAt(i));
			else if (d.charAt(i) == 'L' && d.charAt(j) == 'R')
				for (int k = 0; k < middle; k++)
					res.append('.');
			else {
				for (int k = 0; k < middle / 2; k++)
					res.append('R');
				if (middle % 2 == 1)
					res.append('.');
				for (int k = 0; k < middle / 2; k++)
					res.append('L');
			}
			i = j;
		}
		return res.toString();
	}
}
