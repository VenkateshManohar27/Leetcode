package com.ven.leetcode.oct.challenge;

import java.util.Arrays;
import java.util.List;

public class BinarySearchGoogle {
	public int findCount(final List<Integer> A, int B) {
		int start = 0;
		int end = A.size() - 1;
		int index = -1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (A.get(mid) == B) {
				index = mid;
				break;
			} else if (A.get(mid) < B) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}

		}
		//System.out.println("I am out");
		if (index == -1)
			return 0;
		int i = index-1, j = index+1;
		int count  = 1;
		while (i >= 0) {
			if(A.get(i) != B){
	            break;
	        }
			if (A.get(i) == B) {
				count++;
			}
			i--;
		}
		while (j < A.size()) {
			if(A.get(j) != B){
	            break;
	        }
			if (A.get(j) == B) {
				
				count++;
			}
			j++;
		}
		
		return count;
	}

	public static void main(String[] args) {
		BinarySearchGoogle g = new BinarySearchGoogle();
		// int[] arr = new int[]{1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 5, 5, 5,
		// 5, 5, 6, 6, 6, 7, 7, 8, 8, 8, 8, 9, 9, 10, 10, 10};
		int res = g.findCount(Arrays.asList(1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 7, 7,
				8, 8, 8, 8, 9, 9, 10, 10, 10), 1);
		System.out.println(res);
		res = g.findCount(Arrays.asList(5, 7, 7, 8, 8, 10), 8);
		System.out.println(res);
		res = g.findCount(Arrays.asList(5, 7, 7, 8, 8, 10,10,10,10 ,10), 10);
		System.out.println(res);
		
	}
}
