package com.ven.leetcode.easy;

public class BadVersion {
	private int badVersion = 0;

	public BadVersion(int badVersion) {
		// TODO Auto-generated constructor stub
		this.badVersion = badVersion;
	}

	private boolean isBadVersion(int n) {
		return n >= badVersion;
	}

	public int firstBadVersion(int n) {
		return firstBadVersion(1, n);
	}

	private int firstBadVersion(int start, int end) {
		if (start > end) {
			return 0;
		}
		int mid = start + (end - start) / 2;

		boolean isBad = isBadVersion(mid);
		if (isBad && (mid == 1 || !isBadVersion(mid - 1))) {
			return mid;
		}

		if (isBad) {
			return firstBadVersion(start, mid - 1);
		} else {
			return firstBadVersion(mid + 1, end);
		}
	}

	public int firstBadVersionOptimized(int n) {
		int start = 1, end = n;
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (!isBadVersion(mid))
				start = mid + 1;
			else
				end = mid;
		}
		return start;
	}

	public static void main(String[] args) {
		BadVersion bv = new BadVersion(1);

		System.out.println(bv.firstBadVersion(3));

		bv = new BadVersion(4);
		System.out.println(bv.firstBadVersion(5));

		bv = new BadVersion(1702766719);
		System.out.println(bv.firstBadVersion(2126753390));

	}

}
