package com.fraza.algo.etc;

public class FibGenerator {

	//recursion
	public static int fib2(int n)
	{
		if(n<=1) return n;
		return fib(n-1) + fib(n-2);
	}

	//liners
	public static int fib(int n)
	{
		int l = 1, r = 1;
		for(int i=3; i<=n; ++i)
		{
			r = r+l;
			l = r-l;
		}
		return r;
	}
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		int n = 9999;
		System.out.println(n+"th element of Fibonacci is " +fib(n)); 
		System.out.println("Time = " + (System.currentTimeMillis() - start));
	}
}
