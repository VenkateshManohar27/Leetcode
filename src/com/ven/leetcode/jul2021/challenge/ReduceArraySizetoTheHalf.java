package com.ven.leetcode.jul2021.challenge;

import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * Given an array arr. You can choose a set of integers and remove all the
 * occurrences of these integers in the array.
 * 
 * Return the minimum size of the set so that at least half of the integers of
 * the array are removed.
 * 
 * Example 1:
 * 
 * Input: arr = [3,3,3,3,5,5,5,2,2,7] Output: 2 Explanation: Choosing {3,7} will
 * make the new array [5,5,5,2,2] which has size 5 (i.e equal to half of the
 * size of the old array). Possible sets of size 2 are {3,5},{3,2},{5,2}.
 * Choosing set {2,7} is not possible as it will make the new array
 * [3,3,3,3,5,5,5] which has size greater than half of the size of the old
 * array. Example 2:
 * 
 * Input: arr = [7,7,7,7,7,7] Output: 1 Explanation: The only possible set you
 * can choose is {7}. This will make the new array empty. Example 3:
 * 
 * Input: arr = [1,9] Output: 1 Example 4:
 * 
 * Input: arr = [1000,1000,3,7] Output: 1 Example 5:
 * 
 * Input: arr = [1,2,3,4,5,6,7,8,9,10] Output: 5
 * 
 * 
 * Constraints:
 * 
 * 1 <= arr.length <= 10^5 arr.length is even. 1 <= arr[i] <= 10^5
 * 
 * @author Venkatesh Manohar
 *
 */
public class ReduceArraySizetoTheHalf {
	public int minSetSize(int[] arr) {
        int n = arr.length;
        int[] freq = new int[100001];
        for(int i = 0; i <arr.length; i++){
            freq[arr[i]]++;
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> b[1] - a[1]);
        for(int i = 0; i< freq.length; i++){
            if(freq[i] == 0) continue;
            pq.offer(new int[]{i, freq[i]});
        }
        int size = 0;
        int min = 0;
        while(!pq.isEmpty()){
            size += pq.poll()[1];
            min++;
            if(size >= n/2){
                return min;
            }
        }
        
        return min;
    }
	
	public int minSetSize2(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i <arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> b[1] - a[1]);
        for (Iterator<Integer> it = map.keySet().iterator(); it.hasNext();) {
        	Integer i = it.next();
			pq.offer(new int[]{i, map.get(i)});
			
		}
        int size = 0;
        int min = 0;
        while(!pq.isEmpty()){
            size += pq.poll()[1];
            min++;
            if(size >= n/2){
                return min;
            }
        }
        
        return min;
    }
}
