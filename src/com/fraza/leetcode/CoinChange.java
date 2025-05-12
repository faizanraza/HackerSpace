package com.fraza.leetcode;

import java.util.HashMap;
import java.util.HashSet;

//https://leetcode.com/problems/coin-change/description/
public class CoinChange {

	public int coinChange1(int[] coins, int amount) 
	{
		int len = coins.length;
		HashSet<Integer> coinSet = new HashSet<Integer>(len);
		for(int coin: coins)
			coinSet.add(coin);
		
		int a = amount;
		while(a >= 1)
		{
			if(coinSet.contains(a))
			{
				
			}
		}
		
	 	return -1;
	 }
	
	public int coinChange(int[] denominations, int amount) {
		if (denominations == null) {
            System.out.println("Cannot calculate change with invalid denominations.");
            return -1;
        }
        if (amount < 0) {
            System.out.println("Amount cannot be negative.");
            return -1;
        }

        int remainingAmount = amount;
        HashMap<Integer, Integer> coinCounts = new HashMap<>(); // Use a HashMap

        // Iterate through the denominations from largest to smallest.
        for (int i = denominations.length - 1; i >= 0; i--) {
            int coinValue = denominations[i];
            // Calculate how many of the current coin can be used.
            while (remainingAmount >= coinValue) {
                remainingAmount -= coinValue;
                coinCounts.put(coinValue, coinCounts.getOrDefault(coinValue, 0) + 1); // Increment count
            }
        }

        // Print the change, or a message if change cannot be made.
        if (remainingAmount == 0) {
            System.out.println("Change for " + amount + ":");
            for (int i = denominations.length - 1; i >= 0; i--) {
                int coinValue = denominations[i];
                if (coinCounts.containsKey(coinValue)) {
                    System.out.println(coinValue + " x " + coinCounts.get(coinValue));
                }
            }
        } else {
            System.out.println("Cannot make exact change for " + amount + " with the given denominations.");
        }
        return coinCounts.size();
    }
	
	public int coinChange(HashSet<Integer> coinSet, int amount) 
	{
		while(amount >= 1)
		{
			if(coinSet.contains(amount))
			{
				return 1;
			}
			else
			{
				
			}
			
			amount--;
		}
		
		return -1;
	}
	
	 public static void main(String[] args) throws Exception 
	 {
		long t1 = System.currentTimeMillis();
	 	sample1();
	 	sample2();
	 	sample3();
	 	sample4();
	 	sample5();
	 	System.out.println("Time = "+ (System.currentTimeMillis() - t1));
	 }
	
	 public static void sample1() //2
	 {
		int[] nums = {2,7,11,15};
		int ans = new CoinChange().coinChange(nums, 9);
		System.out.println(ans);
	 }

	 public static void sample2() //3
	 {
		int[] nums = {1,2,5};
		int ans = new CoinChange().coinChange(nums, 11);
		System.out.println(ans);
	 }

	 public static void sample3() //2
	 {
		int[] nums = {1,3};
		int ans = new CoinChange().coinChange(nums, 6);
		System.out.println(ans);
	 }
	 
	 public static void sample4() //
	 {
		int[] nums = {3,2,3,-1,0,-55,3,2,3,-1,0,0,3,75,3,2,3,-1,999999999,3,2,3,-1,0,-5,3,2,3,-1,0,0,3,7,3,25,3,-1,0,3,2,3,-1,0,-5,35,2,3,-1,0,0,3,7,35,2,3,-15,0,3,2,3,-1,50,-5,3,2,3,-1,0,0,3,57,3,2,3,-1,0,3,2,53,-1,0,-5,3,2,3,-1,0,0,3,7,3,2,3,-551,0,3,2,3,-1,0,-5,3,2,3,-1,0,0,3,557,3,2,355,-1,0,3,2,3,-1,0,-5,3,2,3,-1,0,0,3,7,3,2,3,-1,0,3,2,3,-1,550,-5,3,2,3,-1,0,0,3,7,3,2,3,-1,0,3,2,3,-1,0,-5,3,2,3,-1,0,0,3,7,3,2,3,-1,0,3,2,3,-1,0,-5,3,2,3,-1,0,0,3,7,3,2,3,-1,0,3,2,3,-1,0,-5,3,2,3,-1,0,0,3,7,3,2,3,-1,0,3,2,3,-1,0,-5,3,2,3,-1,0,0,3,7,3,2,3,-1,0,3,2,3,-1,0,-5,3,2,3,-1,0,0,3,7,3,2,3,-1,0,3,2,3,-1,0,-5,3,2,3,-1,0,0,3,7,3,2,3,-1,0,3,2,3,-1,0,-5,3,2,3,-1,0,0,3,7,3,2,3,-1,0,-1,0,3,2,3,-1,0,-5,3,2,3,-1,0,0,3,7,3,2,3,-1,0,3,2,3,-1,0,-5,3,2,3,-1,0,0,3,7,-9,11,-1,0,3,2,3,-1,0,-5,3,2,3,-1,0,0,3,7,3,2,3,-1,0,3,2,3,-1,0,-5,3,2,3,-1,0,0,3,7,3,2,3,-1,0,-55,3,2,3,-1,0,0,3,75,3,2,3,-1,999999999,3,2,3,-1,0,-5,3,2,3,-1,0,0,3,7,3,25,3,-1,0,3,2,3,-1,0,-5,35,2,3,-1,0,0,3,7,35,2,3,-15,0,3,2,3,-1,50,-5,3,2,3,-1,0,0,3,57,3,2,3,-1,0,3,2,53,-1,0,-5,3,2,3,-1,0,0,3,7,3,2,3,-551,0,3,2,3,-1,0,-5,3,2,3,-1,0,0,3,557,3,2,355,-1,0,3,2,3,-1,0,-5,3,2,3,-1,0,0,3,7,3,2,3,-1,0,3,2,3,-1,550,-5,3,2,3,-1,0,0,3,7,3,2,3,-1,0,3,2,3,-1,0,-5,3,2,3,-1,0,0,3,7,3,2,3,-1,0,3,2,3,-1,0,-5,3,2,3,-1,0,0,3,7,3,2,3,-1,0,3,2,3,-1,0,-5,3,2,3,-1,0,0,3,7,3,2,3,-1,0,3,2,3,-1,0,-5,3,2,3,-1,0,0,3,7,3,2,3,-1,0,3,2,3,-1,0,-5,3,2,3,-1,0,0,3,7,3,2,3,-1,0,3,2,3,-1,0,-5,3,2,3,-1,0,0,3,7,3,2,3,-1,0,3,2,3,-1,0,-5,3,2,3,-1,0,0,3,7,3,2,3,-1,0,-1,0,3,2,3,-1,0,-5,3,2,3,-1,0,0,3,7,3,2,3,-1,0,3,2,3,-1,0,-5,3,2,3,-1,0,0,3,7,-9,11,-1,0,3,2,3,-1,0,-5,3,2,3,-1,0,0,3,7,3,2,3,-1,0,3,2,3,-1,0,-5,3,2,3,-1,0,0,3,7};
		int ans = new CoinChange().coinChange(nums, 4);
		System.out.println(ans);
	 }

	 public static void sample5() //1,3
	 {
		int[] nums = {-1000000000,999999999,1000000000, 2, 1};
		int ans = new CoinChange().coinChange(nums, 1000000001);
		System.out.println(ans);
	 }
}