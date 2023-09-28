package com.fraza.algo.codingninja;

import java.util.ArrayList;

//https://www.codingninjas.com/codestudio/problems/sum-of-infinite-array_873335
public class RotatedSortedArray 
{
    public static int search(ArrayList<Integer> arr, int n, int k) {
        int i=0;
        int prev = arr.get(i++);
        if( k == prev ) return 0;
        while(i < n && k < arr.get(i) && prev < arr.get(i)) {
        	prev = arr.get(i++);
        }
        while(i < n && k > arr.get(i)) {
        	prev = arr.get(i++);
        }
        if( i < n && k == arr.get(i) ) return i;
        return -1;
    }


    public static void main(String[] args) throws Exception {
    	sample1();
	}
    
    public static void sample1() {
		
    	int n=4, k=3;
    	String[] arrStr = "2 3 5 8".split(" ");
    	ArrayList<Integer> arr = new ArrayList<Integer>();  
    	for(String a: arrStr)
    	{
    		arr.add(Integer.parseInt(a));
    	}

    	System.out.print(search(arr, n, k)); 
	}
}
