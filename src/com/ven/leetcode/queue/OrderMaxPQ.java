package com.ven.leetcode.queue;

import java.util.NoSuchElementException;

import com.ven.utility.ArrayUtility;

public class OrderMaxPQ<Key extends Comparable<Key>> {
	private Comparable[] q;
	private int N = 0;

	public OrderMaxPQ(int capacity) {
		super();
		q = new Comparable[capacity];
	}

	public void insert(Key value) {
		if (N < q.length) {
			q[++N] = value;
			swim(N);
		}
	}

	public void swim(int index) {
		while (index > 1 && ArrayUtility.less(q[index / 2], q[index])) {
			ArrayUtility.exch(q, index / 2,index);
			index = index / 2;
		}
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return N == 0;
	}

	public Key delMax() {
		if(isEmpty()){
            throw new NoSuchElementException("PQ is empty");
        }
		Key max = (Key) q[1];
		ArrayUtility.exch(q, 1, N);
		q[N]= null;
		N--;
		sink(1);
		return max;
	}

	private void sink(int index) {
		while (2 * index <= N) {
            int j = 2 * index;
            if (j < N && ArrayUtility.less(q[j], q[j + 1])) {
                j++;
            }
            if (!ArrayUtility.less(q[index], q[j])) {
                break;
            }
            ArrayUtility.exch(q, index, j);
            index = j;
        }
		
	}
}
