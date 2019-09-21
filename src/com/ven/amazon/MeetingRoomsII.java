package com.ven.amazon;

import java.util.Arrays;
import java.util.PriorityQueue;

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}

/**
 * Given an array of meeting time intervals consisting of start and end times
 * [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms
 * required. For example, Given [[0, 30],[5, 10],[15, 20]], return 2.
 * 
 * @author Venkatesh Manohar
 *
 */
public class MeetingRoomsII {
	public int minMeetingRooms(Interval[] intervals) {
		Arrays.sort(intervals, (a, b) -> a.start - b.start);
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (Interval interval : intervals) {
			if (!pq.isEmpty() && interval.start >= pq.peek()) {
				pq.poll();
			}
			pq.add(interval.end);
		}
		return pq.size();
	}

	public static void main(String[] args) {
		MeetingRoomsII mr = new MeetingRoomsII();
		Interval[] intervals = new Interval[3];
		intervals[0] =  new Interval(0,30);
		intervals[1] =  new Interval(5, 10);
		intervals[2] =  new Interval(15, 20);
		System.out.println("Minimum meeting rooms:"+mr.minMeetingRooms(intervals));
		
		intervals = new Interval[2];
		intervals[0] =  new Interval(7,10);
		intervals[1] =  new Interval(2, 4);
		System.out.println("Minimum meeting rooms:"+mr.minMeetingRooms(intervals));
	}
}
