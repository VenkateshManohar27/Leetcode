package com.ven.leetcode.week239;

public class MinimumAdjacentSwapsReachtheKthSmallestNumber {
	public char[] nextGreaterElement(char[] n) {
		char[] arr = n;
		int i, j;
		for (i = arr.length - 1; i > 0; i--) {
			if (arr[i] > arr[i - 1])
				break;
		}

		if (i == 0)
			return arr;
		int num = arr[i - 1], smallest = i;

		for (j = i + 1; j < arr.length; j++)
			if (arr[j] > num && arr[j] <= arr[smallest])
				smallest = j;

		swap(arr, i - 1, smallest);
		reverse(arr, i, arr.length - 1);

		return arr;
	}

	private void reverse(char[] arr, int left, int right) {
		while (left < right) {
			swap(arr, left, right);
			left++;
			right--;
		}
	}

	private void swap(char[] arr, int left, int right) {
		char tmp = arr[left];
		arr[left] = arr[right];
		arr[right] = tmp;
	}

	public int getMinSwaps(String num, int k) {
		int temp = k;
		char[] greater = num.toCharArray();
		while (temp > 0) {
			greater = nextGreaterElement(greater);
			temp--;
		}
		char[] number = num.toCharArray();
		return count(greater, number, number.length);
	}

	private int count(char[] s1, char[] s2, int n) {
		int i = 0, j = 0, res = 0;

		while (i < n) {
			j = i;

			while (s1[j] != s2[i])
				j++;

			while (i < j) {
				char temp = s1[j];
				s1[j] = s1[j - 1];
				s1[j-- - 1] = temp;
				++res;
			}
			++i;
		}
		return res;
	}

	public static void main(String[] args) {
		MinimumAdjacentSwapsReachtheKthSmallestNumber c = new MinimumAdjacentSwapsReachtheKthSmallestNumber();
		System.out.println(c.getMinSwaps("5489355142", 4));
		System.out.println(c.getMinSwaps("11112", 4));
		System.out.println(c.getMinSwaps("00123", 1));
	}
}
