package com.ven.leetcode.week5;

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
	private static final int[] HOURS = { 1, 2, 4, 8 };
	private static final int[] MINUTES = { 1, 2, 4, 8, 16, 32 };

	public List<String> readBinaryWatch(int num) {
		List<String> l = new ArrayList<>();
		if (num < 1) {
			return l;
		}
		helper(num, 0, 0, 0, l);

		return l;
	}

	private void helper(int num, int start, int hr, int min, List<String> l) {
		if (hr > 11 || min > 59) {
			return;
		}
		if (num == 0) {
			StringBuilder sb = new StringBuilder();
			sb.append(hr);
			sb.append(":");
			if (min < 10) {
				sb.append("0");
				sb.append(min);

			}else {
				sb.append(min);
			}
			l.add(sb.toString());
			return;
		}

		if (num < 0) {
			return;
		}

		for (int i = start; i < HOURS.length; i++) {
			num = num - 1;
			hr += HOURS[i];
			helper(num, start + 1, hr, 0, l);
			if (num > 0) {
				for (int j = 0; j < MINUTES.length; j++) {
					num = num - 1;
					min += MINUTES[j];
					helper(num - 1, start, hr, min, l);
					min -= MINUTES[j];
					num = num + 1;
				}
			}
			num = num + 1;
			hr -= HOURS[i];
		}
	}

	public static void main(String[] args) {
		BinaryWatch b = new BinaryWatch();

		System.out.println(b.readBinaryWatch(2));
	}
}
