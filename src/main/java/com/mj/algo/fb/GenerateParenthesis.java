package com.mj.algo.fb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/*
 * Given n pairs of parenthesis, write a function to generate all combinations of well formed parenthesis.
 */

public class GenerateParenthesis {
	
	List<String> result = new ArrayList<String>();
	
	public void generate(int n) {
		backtrack(result, n, 0, 0);
	}
	
	private void backtrack(List<String> result, int n, int open, int close) {
		if(open==n && close == n) {
			String curString = result.stream().collect(Collectors.joining());
			result.add(curString);
		}
		
		if(open<close) {
			result.add("(");
			backtrack(result, n, open+1, close);
			result.remove(result.size()-1);
		}
		
		if(close<n) {
			result.add(")");
			backtrack(result, n, open, close+1);
			result.remove(result.size()-1);
		}
	}
	
	public static void main(String[] args) {
		int n =3;
		new GenerateParenthesis().generate(n);
		
	}

}
