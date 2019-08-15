package com.ven.leetcode.greedy;

public class Job {
	private String id;
	private int profits;
	private int deadlines;

	public Job(String id, int deadlines, int profits) {
		super();
		this.id = id;
		this.deadlines = deadlines;
		this.profits = profits;
		
	}

	public String getId() {
		return id;
	}

	public int getProfits() {
		return profits;
	}

	public int getDeadlines() {
		return deadlines;
	}

	@Override
	public String toString() {
		return "Job [id=" + id + ", profits=" + profits + ", deadlines=" + deadlines + "]";
	}

}
