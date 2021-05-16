package com.ven.leetcode.week240;

public class MaximumPopulationYear {
	
	 public int maximumPopulation(int[][] logs) {
	        int max = 0;
	        int year = 0;
	        for(int i = 0;i< logs.length; i++){
	            int birth = logs[i][0];
	            int death = logs[i][1];
	            int count = 1;
	            System.out.println("birth:"+birth+", death:"+ death);
	            for(int j = 0; j< logs.length; j++){
	                if( i== j) continue;
	                if(logs[j][0] <=  birth && logs[j][1] >= birth && logs[j][1] > death){
	                    System.out.println("birth1:"+logs[j][0]+", death1:"+ logs[j][1]);
	                    count++;
	                     System.out.println("count:"+count);
	                }
	            }
	            //System.out.println("count:"+count+", birth:"+birth+", death:"+ death);
	            if(count >= max ) {
	                if(count > max){
	                    year = birth;
	                }else if(birth < year){
	                    year = birth;
	                }
	            }
	            max = Math.max(max, count);
	        }
	        return year;
	    }
	
	public static void main(String[] args) {
		MaximumPopulationYear a = new MaximumPopulationYear();
		
		a.maximumPopulation(new int[][] {{1987,2047},{1952,2006},{2021,2042},{2047,2049},{2036,2040},{1994,2009
				}});
		//[[2008,2026],[2004,2008],[2034,2035],[1999,2050],[2049,2050],[2011,2035],[1966,2033],[2044,2049]]
	}
}
