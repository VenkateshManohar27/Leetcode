package com.ven.leetcode.segtree;

import com.ven.utility.ArrayUtility;

public class SegmentTree {
	int[] segTree;
	int[] input;
	Operation op;

	public SegmentTree(int[] input, Operation op) {
		super();
		this.input = input;
		this.op = op;
		constructSegTree(input, op);
	}

	public void constructSegTree(int[] input, Operation op) {
		int length = NextPowerOf2.nextPowerOf2(input.length);
		this.segTree = new int[2 * length - 1];
		construct(input, 0, input.length - 1, 0, op);
		ArrayUtility.print(this.segTree);
	}

	private void construct(int[] input, int low, int high, int pos, Operation op) {
		if (low == high) {
			this.segTree[pos] = input[low];
			return;
		}
		int mid = (low + high) / 2;
		construct(input, low, mid, 2 * pos + 1, op);
		construct(input, mid + 1, high, 2 * pos + 2, op);
		segTree[pos] = op.perform(segTree[2 * pos + 1], segTree[2 * pos + 2]);
	}

	public int rangeQuery(int start, int end) {
		return rangeQuery(start, end, 0, input.length - 1, 0);
	}

	private int rangeQuery(int start, int end, int low, int high, int pos) {
		if (start <= low && end >= high) {
			return this.segTree[pos];
		}
		if (start > high || end < low) {
			return op.defaultValue();
		}
		int mid = (low + high) / 2;
		return op.perform(rangeQuery(start, end, low, mid, 2 * pos + 1),
				rangeQuery(start, end, mid + 1, high, 2 * pos + 2));
	}

	public static void main(String[] args) {
		SegmentTree st = new SegmentTree(new int[] { -1, 2, 4, 0 }, new Min());
		System.out.println(st.rangeQuery(0, 3));
		System.out.println(st.rangeQuery(1, 3));
		System.out.println(st.rangeQuery(1, 2));
		st = new SegmentTree(new int[] { -1, 2, 4, 0, 5 }, new Min());
		
		st = new SegmentTree(new int[] { -1, 2, 4, 0 }, new Sum());
		System.out.println(st.rangeQuery(0, 3));
		System.out.println(st.rangeQuery(1, 3));
		System.out.println(st.rangeQuery(1, 2));
		st = new SegmentTree(new int[] { -1, 2, 4, 0, 5 }, new Sum());

	}
}
