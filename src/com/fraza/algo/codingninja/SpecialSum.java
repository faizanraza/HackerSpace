package com.fraza.algo.codingninja;

import java.util.ArrayList;

//https://www.codingninjas.com/codestudio/problems/sum-of-infinite-array_873335
public class SpecialSum 
{
	public static int specialSum(ArrayList<Integer> arr, int n ){
		
		int sum = 0;
		for(Integer i: arr)
		{
			sum+=i;
		}
		while(sum > 9)
		{
			int th = sum/1000;
			sum -= th*1000;
			int h = sum/100;
			sum -= h*100;
			int t = sum/10;
			sum -= t*10;
			
			sum = sum + t + h + th;
		}
		return sum;
	}


    public static void main(String[] args) throws Exception {
    	sample1();
	}
    
    public static void sample1() {
		
    	int n=4;
    	String[] arrStr = "5 8 4 9".split(" ");
    	ArrayList<Integer> arr = new ArrayList<Integer>();  
    	for(String a: arrStr)
    	{
    		arr.add(Integer.parseInt(a));
    	}

    	System.out.print(specialSum(arr, n)); 
	}
}
