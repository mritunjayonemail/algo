package com.mj.algo.misc;

import java.util.HashSet;
import java.util.Set;


//checks whether any permutation ↴ of an input string is a palindrome
public class HasPalindromePermutation {
	
	boolean hasPalindromePermutation(String str){
		Set unPairedCharacters = new HashSet();
		
		for (int i = 0; i < str.length(); i++){
		    char c = str.charAt(i);     
		    
		    if(unPairedCharacters.contains(c)){
		    	unPairedCharacters.remove(c);
		    }
		    else {
		    	unPairedCharacters.add(c);
		    }
		    	 
		}
		
		// the string has a palindrome permutation if it
		// has one or zero characters without a pair
		return unPairedCharacters.size() <= 1;
	}
	
	
	public static void main(String[] args){
		HasPalindromePermutation hasPalindromePermutation = new HasPalindromePermutation();
		System.out.println("is Palindrome -> " + hasPalindromePermutation.hasPalindromePermutation("civil"));
	}
	

}
