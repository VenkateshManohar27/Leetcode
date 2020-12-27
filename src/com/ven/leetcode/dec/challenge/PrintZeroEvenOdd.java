package com.ven.leetcode.dec.challenge;

import java.util.function.IntConsumer;

/**
 * Suppose you are given the following code:
 * 
 * class ZeroEvenOdd { public ZeroEvenOdd(int n) { ... } // constructor public
 * void zero(printNumber) { ... } // only output 0's public void
 * even(printNumber) { ... } // only output even numbers public void
 * odd(printNumber) { ... } // only output odd numbers } The same instance of
 * ZeroEvenOdd will be passed to three different threads:
 * 
 * Thread A will call zero() which should only output 0's. Thread B will call
 * even() which should only ouput even numbers. Thread C will call odd() which
 * should only output odd numbers. Each of the threads is given a printNumber
 * method to output an integer. Modify the given program to output the series
 * 010203040506... where the length of the series must be 2n.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = 2 Output: "0102" Explanation: There are three threads being fired
 * asynchronously. One of them calls zero(), the other calls even(), and the
 * last one calls odd(). "0102" is the correct output. Example 2:
 * 
 * Input: n = 5 Output: "0102030405"
 * 
 * @author Venkatesh Manohar
 *
 */
public class PrintZeroEvenOdd {
	private int n;
	private int i = 0;
	private boolean printZero = true;

	public PrintZeroEvenOdd(int n) {
		this.n = n;
	}

	// printNumber.accept(x) outputs "x", where x is an integer.
	public synchronized void zero() throws InterruptedException {
		while (true) {
			while (i <= n && !printZero) {
				wait();
			}
			if (i > n)
				break;
			if (i < n)
				// printNumber.accept(0);
				System.out.print("0");
			printZero = false;
			i++;
			notifyAll();
		}
	}

	public synchronized void even() throws InterruptedException {
		while (true) {
			while (i <= n && (printZero || i % 2 != 0)) {
				wait();
			}
			if (i > n)
				break;
			// printNumber.accept(i);
			System.out.print(i);
			printZero = true;
			notifyAll();
		}
	}

	public synchronized void odd() throws InterruptedException {
		while (true) {
			while (i <= n && (printZero || i % 2 != 1)) {
				wait();
			}
			if (i > n)
				break;
			// printNumber.accept(i);
			System.out.print(i);
			printZero = true;
			notifyAll();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		PrintZeroEvenOdd p = new PrintZeroEvenOdd(2);
		execute(p);
		System.out.println();
		p = new PrintZeroEvenOdd(10);
		execute(p);
	}

	private static void execute(PrintZeroEvenOdd p) throws InterruptedException {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				// code goes here.
				try {
					p.zero();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		t1.start();

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					p.even();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		t2.start();

		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					p.odd();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		t3.start();
		
		t1.join();
		t2.join();
		t3.join();
	}
}
