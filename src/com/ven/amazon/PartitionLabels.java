package com.ven.amazon;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
	public List<Integer> partitionLabels(String S) {
		List<Integer> sizeOfParts = new ArrayList<Integer>();
		if (S == null || S.length() == 0 || S.isEmpty()) {
			return sizeOfParts;
		}
		int[] lastIndexOf = new int[26];
		for (int k = 0; k < S.length(); k++) {
			lastIndexOf[S.charAt(k)-'a'] = k;
		}
		int i = 0;
		int start = 0;
		while (i < S.length()) {
			char c = S.charAt(i);
			int end = lastIndexOf[c-'a'];
			i++;
			while (i < end) {
				char ch = S.charAt(i);
				int endIndex = lastIndexOf[ch-'a'];
				if (endIndex > end) {
					end = endIndex;
				}
				i++;
			}
			i = end + 1;
			sizeOfParts.add(i - start);
			start = i;
		}
		return sizeOfParts;
	}

	public static void main(String[] args) {
		PartitionLabels pl = new PartitionLabels();
		List<Integer> list = pl.partitionLabels("ababcbacadefegdehijhklij");
		System.out.println(list);
	}
}
