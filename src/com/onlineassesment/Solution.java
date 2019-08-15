package com.onlineassesment;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
	public List<Integer> cellCompete(int[] states, int days)
    {
        
        int temp[] = new int [states.length ];
        for (int i=1; i<=days; i++ ){
            for(int j = 0; j < states.length; j++){
                int leftNeighbour = (j-1 < 0)? 0: states[j-1];
                int rightNeighbour = (j+1 >= states.length)? 0: states[j+1];
                boolean result = setState(leftNeighbour, rightNeighbour);
                temp[j] = (result)? 0: 1;
                
            }
            states = Arrays.copyOf(temp, temp.length);
        } 
        return Arrays.stream(states).boxed().collect(Collectors.toList());
    }
    
    private boolean setState(int leftNeighbour,int rightNeighbour){
        if(leftNeighbour ==1 && rightNeighbour ==1){
            return true;
        }else if(leftNeighbour == 0 && rightNeighbour == 0) {
            return true;
        }else{
            return false;
        }
        
    }
    
    public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.cellCompete(new int[] {1, 0,0,0,0,1,0,0} , 1));
		
		System.out.println(s.cellCompete(new int[] {1, 1,1,0,1,1,1,1} , 2));
	}
}
