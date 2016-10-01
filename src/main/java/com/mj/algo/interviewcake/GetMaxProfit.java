package com.mj.algo.interviewcake;

import java.util.List;
import java.math.*;

import javax.management.RuntimeErrorException;

/*
 *  Suppose we could access yesterday's stock prices as a list, where:

    The indices are the time in minutes past trade opening time, which was 9:30am local time.
    The values are the price in dollars of Apple stock at that time.

	So if the stock cost $500 at 10:30am, stock_prices_yesterday[60] = 500. 
 */
public class GetMaxProfit {
	
	public float getMaxProfit(Float[] stockPriceYesterday){
		
		if (stockPriceYesterday.length<2){
			throw new RuntimeErrorException(null, "index out of bound exception");
		}
		
		float minPrice = stockPriceYesterday[0];
		float maxProfit = stockPriceYesterday[1] - stockPriceYesterday[0];
		int index = 0;
		while (index < stockPriceYesterday.length) {
			float currentPrice = stockPriceYesterday[index];
			float potentialMaxProfit = currentPrice - minPrice;
			maxProfit = Math.max(potentialMaxProfit, maxProfit);
			minPrice = Math.min(minPrice, currentPrice);
			index++;
		}
		return maxProfit;
	}
	
	public static void main(String args[]){
		GetMaxProfit getMaxProfit = new GetMaxProfit();
		System.out.print(getMaxProfit.getMaxProfit(new Float[]{10f, 7f, 5f, 8f, 11f, 9f}));
	}
		

}
