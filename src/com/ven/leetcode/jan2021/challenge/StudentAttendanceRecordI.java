package com.ven.leetcode.jan2021.challenge;

/**
 * You are given a string representing an attendance record for a student. The
 * record only contains the following three characters: 'A' : Absent. 'L' :
 * Late. 'P' : Present. A student could be rewarded if his attendance record
 * doesn't contain more than one 'A' (absent) or more than two continuous 'L'
 * (late).
 * 
 * You need to return whether the student could be rewarded according to his
 * attendance record.
 * 
 * Example 1: Input: "PPALLP" Output: True Example 2: Input: "PPALLL" Output:
 * False
 * 
 * @author Venkatesh Manohar
 *
 */
public class StudentAttendanceRecordI {
	public boolean checkRecord(String s) {
		int a = 0;
		int l = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == 'A') {
				a++;
			}
			if (c == 'L') {
				l++;
			} else {
				l = 0;
			}
			if (a > 1 || l > 2) {
				return false;
			}
		}

		return true;
	}
}
