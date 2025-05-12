package com.fraza.algo.codingninja;

import java.util.Arrays;

//https://www.codingninjas.com/codestudio/problems/sum-of-infinite-array_873335
public class Sort012 
{   
    public static void sort012(int[] arr)
    {
        int n0 = 0, n1 = 0, n2 = 0;
        for(int n: arr)
        {
            if(n==0) n0++;
            else if(n==1) n1++;
            else n2++;
        }
        int i=0;
        while(i<n0)
        {
            arr[i++] = 0;
        }
        while(i<(n0+n1))
        {
            arr[i++] = 1;
        }
        while(i<(n0+n1+n2))
        {
            arr[i++] = 2;
        }
    }

    public static void main(String[] args) throws Exception {
    	sample1();
	}
    
    public static void sample1() {
		
    	String[] arrStr = "0 1 2 2 1 0".split(" ");
    	int[] arr = Arrays.stream(arrStr)
                .mapToInt(Integer::parseInt).toArray();    	

    	sort012(arr);
    	for(int n: arr)
    		System.out.print(n + " "); 
	}
}
