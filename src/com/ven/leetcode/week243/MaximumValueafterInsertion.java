package com.ven.leetcode.week243;

public class MaximumValueafterInsertion {
	
	public String maxValue(String n, int x) {
        StringBuilder sb = new StringBuilder(n);
        
        boolean positive = sb.charAt(0) != '-';
        boolean inserted = false;
        for(int i = 0; i< sb.length(); i++){
            int c = sb.charAt(i) - '0';
            if(positive){
                if(x > c){
                    sb.insert(i, x);
                    inserted = true;
                    break;
                }
            }else{
                if(x < c){
                    sb.insert(i, x);
                    inserted = true;
                    break;
                }
            }
            
        }
        if(!inserted) sb.insert(sb.length(), x);
        return sb.toString();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumValueafterInsertion b = new MaximumValueafterInsertion();
		System.out.println(b.maxValue("99", 9));
		System.out.println(b.maxValue("-139", 9));
		System.out.println(b.maxValue("-139", 2));
		System.out.println(b.maxValue("73", 6));
		System.out.println(b.maxValue("-55", 2));
		System.out.println(b.maxValue("-22", 5));
		System.out.println(b.maxValue("99", 6));
		System.out.println(b.maxValue("-132", 3));
	}

}
