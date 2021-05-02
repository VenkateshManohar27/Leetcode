package com.ven.leetcode.apr2021.challenge;

import java.util.Arrays;
import java.util.Scanner;

class Item {
	public int si, v;
}

public class ProblemB {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			Item[] ans = null;
			int[][] mp = new int[12][12];
			int n = scan.nextInt();
			if (n == 0)
				break;

			String[] str = new String[n];
			for (int i = 0; i < str.length; i++) {
				str[i] = scan.next();
			}
			int mx = Integer.MIN_VALUE;
			int mxnum = Integer.MIN_VALUE;
			for (int i = 0; i < n - 1; i++) {
				String lines = scan.next();
				scan.next();
				int conv = scan.nextInt();
				String text = scan.next();
				int ta = -1;
				int tb = -1;
				for (int j = 0; j < n; j++) {
					if (str[j].equals(lines)) {
						ta = j;
						break;
					}
				}
				for (int j = 0; j < n; j++) {
					if (str[j].equals(text)) {
						tb = j;
						break;
					}
				}
				mp[ta][tb] = conv;
			}
			int tt = 1;
			while (tt-- > 0) {
				for (int k = 0; k < n; k++) {
					for (int i = 0; i < n; i++)
						for (int j = 0; j < n; j++) {
							if (mp[i][k] != 0 && mp[k][j] != 0) {
								mp[i][j] = mp[i][k] * mp[k][j];
							}
							if (mp[i][k] != 0 && mp[j][k] != 0) {
								if (mp[i][k] > mp[j][k]) {
									mp[i][j] = mp[i][k] / mp[j][k];
								} else {
									mp[j][i] = mp[j][k] / mp[i][k];
								}
							}
							if (mp[k][i] != 0 && mp[k][j] != 0) {
								if (mp[k][i] > mp[k][j])
									mp[j][i] = mp[k][i] / mp[k][j];
								else
									mp[i][j] = mp[k][j] / mp[k][i];
							}
							if (mp[i][j] > mx) {
								mx = mp[i][j];
								mxnum = i;
							}
						}
				}
			}
			ans = new Item[n];
			for (int i = 0; i < n; i++) {
				Item it = new Item();
				it.si = i;
				it.v = mp[mxnum][i];
				ans[i] = it;
			}
			Arrays.sort(ans, (a, b) -> {
				return a.v - b.v;
			});
			System.out.print("1" + str[mxnum]);
			for (int i = 1; i < n; i++)
				System.out.print(" = " + ans[i].v + "" + str[ans[i].si]);
			System.out.println();
		}

	}
}
