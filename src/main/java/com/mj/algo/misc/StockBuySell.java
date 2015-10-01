package com.mj.algo.misc;

public class StockBuySell {
	
	public class Interval{
		private int buy;
		private int sell;
		
		
		public int getBuy() {
			return buy;
		}
		public void setBuy(int buy) {
			this.buy = buy;
		}
		public int getSell() {
			return sell;
		}
		public void setSell(int sell) {
			this.sell = sell;
		}
		
	}
	int count = 0;
	
	Interval sol[];
	
	private void buySell(int[] price, int n){
		if(n==1){
			return;
		}
		sol = new Interval[n/2+1];
		int i =0;
		while(i<n-1){
			//find local minima
			while ((i < n-1) && (price[i+1] <= price[i])){
				i++;
			}
		    if(i==n-1){
		    	return;
		    }
		    
		    // Store the index of minima
		    if(sol[count]==null){
		    	sol[count] = new Interval();
		    }
	        sol[count].buy = i++;
	        
		    //find local maxima
		    while ((i < n) && (price[i] >= price[i-1])){
		    	i++;
		    }
		    sol[count].sell = i-1;
		    
		    count = count+1;
		}
		    
		 // print solution
		    if (count == 0)
		        System.out.println("There is no day when buying the stock will make profit\n");
		    else
		    {
		       for (int index = 0; index < count; i++)
		    	   System.out.println("Buy on day: " + sol[index].buy + " Sell on day: %d\n" + sol[index].sell);
		    }
		 
		}
	
	public static void main(String args[]){
		// stock prices on consecutive days
	    int price[] = {100, 180, 260, 310, 40, 535, 695};
	    StockBuySell stockBuySell = new StockBuySell();
	    stockBuySell.buySell(price, 6);
	    
	}
    
		
	

}
