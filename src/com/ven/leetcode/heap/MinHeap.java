package com.ven.leetcode.heap;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MinHeap {
	private int[] arr = new int[10];
	private int SIZE = -1;

	public MinHeap() {

	}

	public void insert(int v) {
		if (SIZE == arr.length) {
			int[] temp = Arrays.copyOf(arr, arr.length * 2);
			arr = temp;
		}

		arr[++SIZE] = v;
		swim(SIZE);
	}

	public int remove() {
		if (SIZE == -1) {
			throw new NoSuchElementException();
		}

		int val = arr[0];
		arr[0] = arr[SIZE--];
		sink(0);

		return val;
	}

	private void sink(int pos) {

		// If the node is a non-leaf node and greater
		// than any of its child
		if (!isLeaf(pos)) {
			if (arr[pos] > arr[getLeftChild(pos)] || arr[pos] > arr[getRightChild(pos)]) {

				// Swap with the left child and heapify
				// the left child
				if (arr[getLeftChild(pos)] < arr[getRightChild(pos)]) {
					swap(pos, getLeftChild(pos));
					sink(getLeftChild(pos));
				}

				// Swap with the right child and heapify
				// the right child
				else {
					swap(pos, getRightChild(pos));
					sink(getRightChild(pos));
				}
			}
		}
	}

	private boolean isLeaf(int pos) {
		if (pos >= (SIZE / 2) && pos <= SIZE) {
			return true;
		}
		return false;
	}

	private void swim(int index) {
		int parent = getParent(index);
		while (arr[parent] > arr[index]) {
			swap(index, parent);
			index = parent;
			parent = getParent(parent);
		}
	}

	private void swap(int index, int parent) {
		int temp = arr[parent];
		arr[parent] = arr[index];
		arr[index] = temp;
	}

	private int getParent(int index) {
		return index / 2;
	}

	private int getLeftChild(int index) {
		return index * 2 + 1;
	}

	private int getRightChild(int index) {
		return index * 2 + 2;
	}

	public void print() {
		for (int i = 0; i < SIZE / 2; i++) {
			System.out.print(
					" PARENT : " + arr[i] + " LEFT CHILD : " + arr[2 * i +1] + " RIGHT CHILD :" + arr[2 * i + 2]);
			System.out.println();
		}
	}

	public static void main(String[] args) {
		System.out.println("The Min Heap is ");
		MinHeap minHeap = new MinHeap();
		minHeap.insert(5);
		minHeap.insert(3);
		minHeap.insert(17);
		minHeap.insert(10);
		minHeap.insert(84);
		minHeap.insert(19);
		minHeap.insert(6);
		minHeap.insert(22);
		minHeap.insert(9);
		//minHeap.remove();

		minHeap.print();
		System.out.println("The Min val is " + minHeap.remove());
	}
}
