package com.vm.practice;

import java.util.ArrayList;

public class JobSequencing {

	private ArrayList<Job> sequence(ArrayList<Job> jobs) {
		ArrayList<Job> sequence = new ArrayList<>();
		jobs.sort((a, b) -> {
			return b.getProfit() - a.getProfit();
		});
		boolean[] slots = new boolean[jobs.size()];

		for (Job j : jobs) {
			for (int i = j.getDeadline()-1; i >= 0; i--) {
				if (!slots[i]) {
					slots[i] = true;
					sequence.add(j);
					break;
				}
			}
		}
		return sequence;
	}

	public static void main(String[] args) {
		JobSequencing jobSequencing = new JobSequencing();
		ArrayList<Job> jobs = new ArrayList<Job>();
		jobs.add(new Job("1", 2, 20));
		jobs.add(new Job("2", 2, 15));
		jobs.add(new Job("3", 1, 10));
		jobs.add(new Job("4", 3, 5));
		jobs.add(new Job("5", 3, 1));
		ArrayList<Job> result = jobSequencing.sequence(jobs);

		for (Job job : result) {
			System.out.println(job);
		}
		System.out.println("------------------------------------------");
		jobs.clear();
		result.clear();

		jobs.add(new Job("1", 4, 20));
		jobs.add(new Job("2", 1, 10));
		jobs.add(new Job("3", 1, 40));
		jobs.add(new Job("4", 1, 30));
		result = jobSequencing.sequence(jobs);

		for (Job job : result) {
			System.out.println(job);
		}
		System.out.println("------------------------------------------");
		jobs.clear();
		result.clear();

		jobs.add(new Job("1", 3, 35));
		jobs.add(new Job("2", 4, 30));
		jobs.add(new Job("3", 4, 25));
		jobs.add(new Job("4", 2, 20));
		jobs.add(new Job("5", 3, 15));
		jobs.add(new Job("6", 1, 12));
		jobs.add(new Job("7", 2, 5));
		result = jobSequencing.sequence(jobs);

		for (Job job : result) {
			System.out.println(job);
		}
	}
}

class Job {
	private String id;
	private int profit;
	private int deadline;

	public Job(String id, int deadline, int profit) {
		super();
		this.id = id;
		this.profit = profit;
		this.deadline = deadline;
	}

	public int getProfit() {
		return profit;
	}

	public int getDeadline() {
		return deadline;
	}

	@Override
	public String toString() {
		return "Job [id=" + id + ", profit=" + profit + ", deadline=" + deadline + "]";
	}

}