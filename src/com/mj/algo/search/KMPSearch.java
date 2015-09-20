package com.mj.algo.search;

public class KMPSearch {
	
	
	private void kmpSearch(char[] pat, char[] txt){
		int m = pat.length;
		int n = txt.length;
		
		int[] lps = computeLPS(pat);
		int i = 0;
		int j = 0;
		
		while (i < n){
		  if (pat[j] == txt[i])
	      {
	        j++;
	        i++;
	      }
		  if (j == m)
	      {
	        System.out.println("Found pattern at index %d \n" + (i-j));
	        j = lps[j-1];
	      }
		  else if (i < n && pat[j] != txt[i])
	      {
	        // Do not match lps[0..lps[j-1]] characters,
	        // they will match anyway
	        if (j != 0)
	         j = lps[j-1];
	        else
	         i = i+1;
	      }
		
		}
		 
		
	}
	
	private int[] computeLPS(char[] pattern){
		int[] t = new int[pattern.length];
		t[0]= 0;
		int pos = 0;
		int index = 1;
		while(index<pattern.length){
			if(pattern[index]== pattern[pos]){
				pos++;
				t[index]=pos;
				index++;
			}
			else{
				if(pos!=0){
					pos=t[pos-1];
				}
				else {
					t[index] = 0;
					index++;
				}
			}
		}
		return t;
	}
	
	
	public static void main(String args[]){

		char[] txt = new char[]{'A', 'B', 'A', 'B', 'D', 'A', 'B','A','C','D','A','B', 'A', 'B','C', 'A', 'B', 'A', 'B'};
		char[] pattern = new char[]{'A', 'A', 'B','A', 'A', 'C', 'A', 'A', 'B', 'A','A'};
		KMPSearch kmpSearch = new KMPSearch();
		kmpSearch.kmpSearch(pattern, txt);
		
		//KMPSearch(pat, txt);
	}

}
