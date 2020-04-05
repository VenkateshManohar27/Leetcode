package com.vm.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class KWeakestRows {
	
	public int[] kWeakestRows(int[][] mat, int k) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < mat.length; i++){
            int count =0;
            for(int j =0 ; j < mat[i].length; j++){
                
                if(mat[i][j]== 1){
                    count++;
                }
                
            }
            if(map.containsKey(count)){
                List<Integer> li = map.get(count);
                li.add(i);
                map.put(count, li);
            } else {
                List<Integer> li = new  ArrayList<>();
                li.add(i);
                map.put(count, li);
            }
        }
        int res[] = new int[k];
        int l = 0;
        int cnt = 0;
        while(l < res.length){
            if(map.containsKey(cnt)){
                List<Integer> li = map.get(cnt);
                int size = 0;
                while(size < li.size() && l < k){
                    res[l] = li.get(size);
                    l++;
                    size++;
                }
            }
            cnt++;
            
        }
        return res;
    }
	public static void main(String[] args) {
		int mat[][] = new int[][] {{1,1,0,0,0},{1,1,1,1,0},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,1}};
		KWeakestRows kwr = new KWeakestRows();
		System.out.println(kwr.kWeakestRows(mat, 3));
	}

}
