package com.mj.algo.obsolete;

public class CountCoins {
	
	private int countCoin(int[] coins, int sum){
		if(coins == null || coins.length<=0){
			return 0;
		}
		int min[] = new int[sum+1];
		min[0]=0;
		for(int i=1; i<=sum; i++){
			min[i]=Integer.MAX_VALUE;;
			for(int j=0; j<coins.length; j++){
				if(i>= coins[j] && min[i-coins[j]]+1<min[i]){
					min[i]= min[i-coins[j]]+1;
					//System.out.println("min for i is" + i + " " + min[i]);
				}
			}
		}
		return  min[sum];
	}
	
	public static void main(String args[]){
		int[] coins = new int[]{1, 2, 8, 9};
		CountCoins countCoins = new CountCoins();
		int count = countCoins.countCoin(coins, 11);
		System.out.print("Count os the coin is - >" + count);
	}

}
