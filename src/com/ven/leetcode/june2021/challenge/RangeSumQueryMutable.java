package com.ven.leetcode.june2021.challenge;

/**
 * Given an integer array nums, handle multiple queries of the following types:
 * 
 * Update the value of an element in nums. Calculate the sum of the elements of
 * nums between indices left and right inclusive where left <= right. Implement
 * the NumArray class:
 * 
 * NumArray(int[] nums) Initializes the object with the integer array nums. void
 * update(int index, int val) Updates the value of nums[index] to be val. int
 * sumRange(int left, int right) Returns the sum of the elements of nums between
 * indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... +
 * nums[right]).
 * 
 * 
 * Example 1:
 * 
 * Input ["NumArray", "sumRange", "update", "sumRange"] [[[1, 3, 5]], [0, 2],
 * [1, 2], [0, 2]] Output [null, 9, null, 8]
 * 
 * Explanation NumArray numArray = new NumArray([1, 3, 5]); numArray.sumRange(0,
 * 2); // return 1 + 3 + 5 = 9 numArray.update(1, 2); // nums = [1, 2, 5]
 * numArray.sumRange(0, 2); // return 1 + 2 + 5 = 8
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 3 * 104 -100 <= nums[i] <= 100 0 <= index < nums.length
 * -100 <= val <= 100 0 <= left <= right < nums.length At most 3 * 104 calls
 * will be made to update and sumRange.
 * 
 * @author Venkatesh Manohar
 *
 */
class NumArray {
	int[] b = null;
	int len = 0;
	int[] n = null;

	public NumArray(int[] nums) {
		double l = Math.sqrt(nums.length);
		len = (int) Math.ceil(nums.length / l);
		n = nums;
		b = new int[len];
		for (int i = 0; i < nums.length; i++) {
			b[i / len] += nums[i];
		}

	}

	public void update(int index, int val) {
		int i = index / len;
		b[i] = b[i] - n[index] + val;
		n[index] = val;
	}

	public int sumRange(int left, int right) {
		int startBlock = left / len;
		int endBlock = right / len;
		int sum = 0;
		if (startBlock == endBlock) {
			for (int i = left; i <= right; i++) {
				sum += n[i];
			}
		} else {
			for (int i = left; i <= (startBlock + 1) * len - 1; i++) {
				sum += n[i];
			}
			for (int i = startBlock + 1; i <= endBlock - 1; i++) {
				sum += b[i];
			}
			for (int i = (endBlock * len); i <= right; i++) {
				sum += n[i];
			}
		}
		return sum;
	}
}

class NumArraySegTree {

	public int ST[];
	public int n;

	public void createSegmentTree(int arr[], int l, int r, int pos) {
		if (l == r) {
			ST[pos] = arr[l];
			return;
		}
		int mid = l + (r - l) / 2;
		createSegmentTree(arr, l, mid, 2 * pos + 1);
		createSegmentTree(arr, mid + 1, r, 2 * pos + 2);
		ST[pos] = ST[2 * pos + 1] + ST[2 * pos + 2];
	}

	public int RangeSumQuery(int low, int high, int qlow, int qhigh, int pos) {
		if (qlow <= low && qhigh >= high)
			return ST[pos];
		if (qlow > high || qhigh < low)
			return 0;
		int mid = low + (high - low) / 2;
		int val1 = RangeSumQuery(low, mid, qlow, qhigh, 2 * pos + 1);
		int val2 = RangeSumQuery(mid + 1, high, qlow, qhigh, 2 * pos + 2);
		return (val1 + val2);
	}

	public void RangeSumUpdate(int low, int high, int index, int val, int pos) {
		if (index < low || index > high)
			return;
		if (low == high) {
			ST[pos] = val;
			return;
		}
		int mid = low + (high - low) / 2;
		RangeSumUpdate(low, mid, index, val, 2 * pos + 1);
		RangeSumUpdate(mid + 1, high, index, val, 2 * pos + 2);
		ST[pos] = ST[2 * pos + 1] + ST[2 * pos + 2];
	}

	public NumArraySegTree(int[] nums) {
		n = nums.length;
		if (n == 0)
			return;
		// YOU MAY INITIALIZE SIZE OF SEGMENT TREE WITH (4*n) AS THAT IS THE MAXIMUM
		// SIZE A SEGMENT TREE CAN HAVE.
		// THE BELOW FORMULA (NEXT 2 LINES) IS USED FOR SPACE OPTIMIZATION.
		int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
		int size = 2 * (int) Math.pow(2, x) - 1;
		ST = new int[size];
		createSegmentTree(nums, 0, n - 1, 0);
	}

	public void update(int i, int val) {
		RangeSumUpdate(0, n - 1, i, val, 0);
	}

	public int sumRange(int i, int j) {
		return RangeSumQuery(0, n - 1, i, j, 0);
	}
}

public class RangeSumQueryMutable {

}
