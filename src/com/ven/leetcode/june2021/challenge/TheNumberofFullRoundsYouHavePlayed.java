package com.ven.leetcode.june2021.challenge;

public class TheNumberofFullRoundsYouHavePlayed {
	public int numberOfRounds(String startTime, String finishTime) {
        int[] start = getTime(startTime), end = getTime(finishTime);
        if(end[0] < start[0] || end[0] == start[0] && end[1] < start[1]) end[0] += 24; // Midnight case
        return (end[0] * 4 + end[1]/15) - (start[0] * 4 + ((int)Math.ceil((double)start[1]/15)));
    }
    private int[] getTime(String t) {
        return new int[] {(t.charAt(0) - '0') * 10 + (t.charAt(1) - '0'), (t.charAt(3) - '0') * 10 + (t.charAt(4) - '0')};
    }

	public static void main(String[] args) {
		TheNumberofFullRoundsYouHavePlayed n = new TheNumberofFullRoundsYouHavePlayed();
		System.out.println(n.numberOfRounds("12:01", "12:44"));
		System.out.println(n.numberOfRounds("20:00", "06:00"));
		System.out.println(n.numberOfRounds("00:00", "23:59"));
		System.out.println(n.numberOfRounds("12:00", "13:59"));
		System.out.println(n.numberOfRounds("12:15", "13:01"));
	}
}
