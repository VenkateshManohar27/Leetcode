package com.ven.google;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverageDataStream {
	private Queue<Integer> q = null;
	private final int MAX_SIZE;
	private double sum = 0.0;
	public MovingAverageDataStream(int size) {
		super();
		q = new LinkedList<>();
		MAX_SIZE = size;
	}

	public double next(int n) {
		if(q.size() == MAX_SIZE) {
			sum -= q.remove();
		}
		q.add(n);
		sum += n;
		
		return sum/q.size();
	}
	
	public static void main(String[] args) {
		MovingAverageDataStream mas = new MovingAverageDataStream(3);
		System.out.println(mas.next(1));
		System.out.println(mas.next(10));
		System.out.println(mas.next(3));
		System.out.println(mas.next(5));
	}
}
