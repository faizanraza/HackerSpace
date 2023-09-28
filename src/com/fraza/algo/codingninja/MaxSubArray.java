package com.fraza.algo.codingninja;

import java.util.Arrays;

//https://www.codingninjas.com/studio/problems/maximum-subarray-sum_630526
public class MaxSubArray 
{
	public static long maxSubarraySum(int[] arr, int n) {
		// write your code here
		long maxSum = 0;
		
		int i = 0;
		long currSum = 0;
		while(i < n )
		{
			while(i < n  && arr[i] >=0)
			{
				currSum += arr[i++];
			}
			if( currSum > maxSum ) maxSum = currSum;
			
			while(i < n &&  arr[i] <=0)
			{
				currSum += arr[i++];
			}
			if( currSum < 0 ) currSum = 0;
		}
		
		return maxSum;
	}


    public static void main(String[] args) throws Exception {
    	sample3();
	}
    
    public static void sample1() {//ans=11
		
    	int n=9;
    	String[] arrStr = "1 2 7 -4 3 2 -10 9 1".split(" ");
    	int[] arr = Arrays.stream(arrStr)
                .mapToInt(Integer::parseInt).toArray();

    	System.out.print(maxSubarraySum(arr, n)); 
	}

    public static void sample2() {////ans=60
		
    	int n=6;
    	String[] arrStr = "10 20 -30 40 -50 60".split(" ");
    	int[] arr = Arrays.stream(arrStr)
                .mapToInt(Integer::parseInt).toArray();

    	System.out.print(maxSubarraySum(arr, n)); 
	}

    public static void sample3() {//ans=0
		
    	int n=3;
    	String[] arrStr = "-3 -5 -6".split(" ");
    	int[] arr = Arrays.stream(arrStr)
                .mapToInt(Integer::parseInt).toArray();

    	System.out.print(maxSubarraySum(arr, n)); 
	}
}
