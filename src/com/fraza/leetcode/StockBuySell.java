package com.fraza.leetcode;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/?envType=study-plan-v2&envId=top-interview-150
public class StockBuySell {

	public int maxProfit(int[] prices)
	{
		int len = prices.length;
		int i = 1, iB = -1, iS = -1;
		int maxProfit = 0;
		
		while(i < len)
		{
			if(iB == -1)
			{
				if( prices[i] > prices[i-1] )
					iB = i - 1;
			}
			else if(iS == -1)
			{
				if( prices[i-1] > prices[i] )
					iS = i-1;
			}
			
			if(iB > -1 && iS > -1)
			{
				maxProfit += prices[iS] - prices[iB];
				iB = -1; iS = -1;
			}
			
			i++;
		}
		
		if(iB > -1 && iS == -1 && prices[len-1] > prices[iB] )
		{
			maxProfit += prices[len-1] - prices[iB];
		}
		
		return maxProfit;
	 }
	
	 public static void main(String[] args) throws Exception 
	 {
	 	sample1();
	 	sample2();
	 	sample3();
	 	sample4();
	 	sample5();
	 }
	
	 public static void sample1() 
	 {
		int[] nums = {7,1,5,3,6,4};
		int ans = new StockBuySell().maxProfit(nums);
		System.out.println(ans);
	 }

	 public static void sample2() 
	 {
		int[] nums = {1,2,3,4,5};
		int ans = new StockBuySell().maxProfit(nums);
		System.out.println(ans);
	 }
	 
	 public static void sample3() 
	 {
		int[] nums = {7,6,4,3,1};
		int ans = new StockBuySell().maxProfit(nums);
		System.out.println(ans);
	 }

	 public static void sample4() 
	 {
		int[] nums = {1,2};
		int ans = new StockBuySell().maxProfit(nums);
		System.out.println(ans);
	 }

	 public static void sample5() 
	 {
		int[] nums = {2,1};
		int ans = new StockBuySell().maxProfit(nums);
		System.out.println(ans);
	 }
}