package com.ven.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * A binary watch has 4 LEDs on the top which represent the hours (0-11), and
 * the 6 LEDs on the bottom represent the minutes (0-59).
 * 
 * Each LED represents a zero or one, with the least significant bit on the
 * right.
 * 
 * 
 * For example, the above binary watch reads "3:25".
 * 
 * Given a non-negative integer n which represents the number of LEDs that are
 * currently on, return all possible times the watch could represent.
 * 
 * Example:
 * 
 * Input: n = 1 Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04",
 * "0:08", "0:16", "0:32"] Note: The order of output does not matter. The hour
 * must not contain a leading zero, for example "01:00" is not valid, it should
 * be "1:00". The minute must be consist of two digits and may contain a leading
 * zero, for example "10:2" is not valid, it should be "10:02".
 * 
 * @author Venkatesh Manohar
 *
 */
public class BinaryWatch {
	static final int[] HOURS = new int[] { 1, 2, 4, 8 };
	static final int[] MINUTES = new int[] { 1, 2, 4, 8, 16, 32 };

	public List<String> readBinaryWatch(int num) {
		List<String> li = new ArrayList<>();

		helperHour(li, 0, 0, 0, num);
		if (num > 0) {
			helperMinutes(li, 0, 0, 0, num);
		}
		return li;
	}

	private void helperHour(List<String> li, int start, int hr, int min, int num) {
		if (hr > 11 || min > 59) {
			return;
		}
		if (num == 0) {
			String minutes = "00";
			if (min > 0 && min < 10) {
				minutes = "0" + min;
			} else if (min >= 10) {
				minutes = "" + min;
			}
			String time = hr + ":" + minutes;
			li.add(time);
			return;
		}
		for (int i = start; i < HOURS.length; i++) {
			hr = hr + HOURS[i];
			num = num - 1;
			helperHour(li, i + 1, hr, min, num);
			if (num > 0) {
				helperMinutes(li, 0, hr, min, num);
			}
			num = num + 1;
			hr = hr - HOURS[i];
		}
	}

	private void helperMinutes(List<String> li, int start, int hr, int min, int num) {
		if (hr > 11 || min > 59) {
			return;
		}
		if (num == 0) {
			String minutes = "00";
			if (min > 0 && min < 10) {
				minutes = "0" + min;
			} else if (min >= 10) {
				minutes = "" + min;
			}
			String time = hr + ":" + minutes;
			li.add(time);
			return;
		}
		for (int i = start; i < MINUTES.length; i++) {
			min = min + MINUTES[i];
			num = num - 1;
			helperMinutes(li, i + 1, hr, min, num);

			num = num + 1;
			min = min - MINUTES[i];
		}
	}

	public List<String> readBinaryWatch2(int n) {
		int[] time = new int[] { 1, 2, 4, 8, 1, 2, 4, 8, 16, 32 };
		List<String> res = new ArrayList();
		backtrack(res, time, 0, n, 0, 0, 0);
		return res;
	}

	private void backtrack(List<String> res, int[] time, int start, int n, int hour, int min, int count) {
		if (hour > 11 || min > 59) {
			return;
		}
		if (count == n) {
			String mm = min < 10 ? "0" + min : "" + min;
			String hh = "" + hour;
			res.add(new String(hh + ":" + mm));
			return;
		}

		for (int i = start; i < time.length; i++) {
			int newHour = i < 4 ? hour + time[i] : hour;
			int newMin = i < 4 ? min : min + time[i];
			backtrack(res, time, i + 1, n, newHour, newMin, count + 1);
		}
	}

	public static void main(String[] args) {
		BinaryWatch bw = new BinaryWatch();
		System.out.println(bw.readBinaryWatch2(0));
		System.out.println(bw.readBinaryWatch2(1));
		System.out.println(bw.readBinaryWatch2(2));
	}
}
