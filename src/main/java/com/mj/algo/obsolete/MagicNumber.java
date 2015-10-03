package com.mj.algo.obsolete;

public class MagicNumber {
	
	public static void printMagicNumber(int n){
		
		int pow = 1;
		int answer=0;
		
		int binary = baseTwo(n);
		System.out.println("Binary is ->" + binary);
		while(n>=1){
			pow = pow*5;
			//if last bit is 1
			
			if((binary &1)==1){
				answer = answer+pow;
			}
			binary>>=1;
			n>>=1;
		}
		
		System.out.print("Answer is -> " + answer);
		
		
	}
	
	public static int baseTwo(int number){
	    int counter=0; //keeps the digits place
	    int remainder = 0; //keeps binary number form 
	    while(number>=1){
	        remainder += (number%2)*(Math.pow(10, counter));
	        counter+=1;
	        number = number/2;
	    }
	    return remainder;
	}

	
	public static void main(String args[]){
		printMagicNumber(1);
	}

}
