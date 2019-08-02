package com.ven.leetcode.greedy;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Given an array of jobs where every job has a deadline and associated profit
 * if the job is finished before the deadline. It is also given that every job
 * takes single unit of time, so the minimum possible deadline for any job is 1.
 * How to maximize total profit if only one job can be scheduled at a time.
 * 
 * Examples:
 * 
 * Input: Four Jobs with following deadlines and profits JobID Deadline Profit a
 * 4 20 b 1 10 c 1 40 d 1 30 Output: Following is maximum profit sequence of
 * jobs c, a
 * 
 * 
 * Input: Five Jobs with following deadlines and profits JobID Deadline Profit a
 * 2 100 b 1 19 c 2 27 d 1 25 e 3 15 Output: Following is maximum profit
 * sequence of jobs c, a, e
 * 
 * @author Venkatesh Manohar
 *
 */
public class JobSequencing {
	static class Job implements Comparable<Job> {
		char id;
		int deadline;
		int profit;

		@Override
		public int compareTo(Job otherJob) {
			return otherJob.profit - this.profit;
		}

		public Job(char id, int deadline, int profit) {
			this.id = id;
			this.deadline = deadline;
			this.profit = profit;
		}
	}

	public ArrayList<Job> sequence(ArrayList<Job> jobs) {
		Collections.sort(jobs);
		ArrayList<Job> result = new ArrayList<>();
		/*
		 * for (Job job : jobs) { System.out.println(job.id + " - " + job.profit); }
		 */
		boolean[] slots = new boolean[jobs.size()];
		for (Job job : jobs) {
			for (int i = job.deadline - 1; i >= 0; i--) {
				if (job.deadline >= i && !slots[i]) {
					result.add(job);
					slots[i] = true;
					break;
				}

			}
		}

		return result;
	}

	public static void main(String[] args) {
		JobSequencing jobSequencing = new JobSequencing();
		ArrayList<Job> jobs = new ArrayList<Job>();
		jobs.add(new Job('a', 2, 100));
		jobs.add(new Job('b', 1, 19));
		jobs.add(new Job('c', 2, 27));
		jobs.add(new Job('d', 1, 25));
		jobs.add(new Job('e', 3, 15));
		ArrayList<Job> result = jobSequencing.sequence(jobs);

		for (Job job : result) {
			System.out.println(job.id + " - " + job.profit);
		}
		System.out.println("------------------------------------------");
		jobs.clear();
		result.clear();
		
		jobs.add(new Job('a', 4, 20));
		jobs.add(new Job('b', 1, 10));
		jobs.add(new Job('c', 1, 40));
		jobs.add(new Job('d', 1, 30));
		result = jobSequencing.sequence(jobs);

		for (Job job : result) {
			System.out.println(job.id + " - " + job.profit);
		}
	}

}
