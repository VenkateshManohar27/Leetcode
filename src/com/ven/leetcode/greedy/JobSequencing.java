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
	
	private ArrayList<Job> sequence(ArrayList<Job> jobs) {
		ArrayList<Job> sequence = new ArrayList<>();
		jobs.sort((j1,j2)->{
			return j2.getProfits() - j1.getProfits();
		});
		boolean[] slots = new boolean[jobs.size()];
		
		for(Job job: jobs) {
			for(int i = job.getDeadlines()-1; i>=0 ;i-- ) {
				if(!slots[i]  ) {
					slots[i] = true;
					sequence.add(job);
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
