package com.fraza.algo.dynamicprog;

import java.util.HashMap;

class Fibonacci
{
	public static int calls = 0;
	public static void main(String[] args)
	{
		int n = 10;
		System.out.println("Fib-"+n+" = " + fibNonRecursion(n));
		System.out.println("Total calls = "+calls);
		calls = 0;
		System.out.println("Fib-"+n+" = " + fibSimpleRecursion(n));
		System.out.println("Total calls = "+calls);
		calls = 0;
		System.out.println("Fib-"+n+" = " + fibMemoRecursion(n));
		System.out.println("Total calls = "+calls);
	}

	public static int fibNonRecursion(int n)
	{
		calls++;
		int a1 = 1;//n=1
		int a2 = 1;//n=2
		for(int i=2; i<n; i++)
		{
			int a3 = a1 + a2;
			//move a1, a2 forward
			a1 = a2;
			a2 = a3;
		}
		return a2;
	}

	public static int fibSimpleRecursion(int n)
	{
		calls++;
		if(n<=0) return 0;
		else if(n<=2) return 1;
		else return fibSimpleRecursion(n-1) + fibSimpleRecursion(n-2);
	}

	public static HashMap<Integer,Integer> memo = new HashMap<Integer,Integer>(); 
	public static int fibMemoRecursion(int n)
	{
		System.out.println("Fib called for "+n);calls++;
		if(n<=0) return 0;
		else if(n<=2) return 1;
		else 
		{
			if(memo.containsKey(n)) return memo.get(n);
			int n1 = memo.containsKey(n-1) ? memo.get(n-1) :  fibMemoRecursion(n-1);
			memo.put(n-1,n1);
			int n2 = memo.containsKey(n-2) ? memo.get(n-2) :  fibMemoRecursion(n-2);
			memo.put(n-2,n2);
			int f = n1 + n2;
			memo.put(n, f);
			return f;
		}
	}
}
