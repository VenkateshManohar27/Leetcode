package com.vm.practice;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

	public List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<>();
		helper("",0,0,n,list);
		return list;
	}
	
	
	private void helper(String str, int numOfLeftParanthesis, int numOfRightParanthesis, int n, List<String> list) {
		
		if(n == numOfLeftParanthesis && n == numOfRightParanthesis) {
			list.add(str);
			return;
		}
		if(numOfLeftParanthesis <= n) {
		helper(str+"(",numOfLeftParanthesis+1, numOfRightParanthesis,n, list);
		}
		if(numOfRightParanthesis<numOfLeftParanthesis) {
		helper(str+")", numOfLeftParanthesis, numOfRightParanthesis+1,n, list);
		}
	}


	public static void main(String[] args) {
		GenerateParenthesis gp = new GenerateParenthesis();
		System.out.println(gp.generateParenthesis(0));
		System.out.println(gp.generateParenthesis(1));
		System.out.println(gp.generateParenthesis(2));
		System.out.println(gp.generateParenthesis(3));
		System.out.println(gp.generateParenthesis(4));
	}
}
