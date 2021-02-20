package com.ven.leetcode.feb2021.challenge;

import java.util.PriorityQueue;

public class MaximumScoreFromRemovingStones {
	public int maximumScore(int a, int b, int c) {
		PriorityQueue<Integer> q = new PriorityQueue<Integer>((i, j) -> {
			 return j - i;
		});
       
       q.offer(a);
       q.offer(b);
       q.offer(c);
       int score = 0;
       while(q.size() > 1){
           int i = q.poll()-1;
           int j  = q.poll()-1;
           if(i > 0)
               q.offer(i);
           if(j>0)
               q.offer(j);
           
           score++;
       }
       return score;

	}
	
	public static void main(String[] args) {
		MaximumScoreFromRemovingStones m = new MaximumScoreFromRemovingStones();
		System.out.println(m.maximumScore(2, 4, 6));
	}
}
