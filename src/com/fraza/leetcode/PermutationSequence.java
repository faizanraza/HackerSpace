package com.fraza.leetcode;

//https://leetcode.com/problems/permutation-sequence/
public class PermutationSequence {

	public String getPermutation(int n, int k)
	{
		String s = "";
		
		int[] elements = new int[n];
		for(int i=0; i<n; ++i) elements[i] = i+1;

		int fac = factorial(n);
		
		while(n > 0)
		{
			int i = ((k-1) * n/fac);
			s = s + String.valueOf(getElement(elements, i));
			
			k = k - (i*fac/n);
			fac = fac/n;
			n--;
		}
		
		
		return s;
	}
	
	public int factorial(int n)
	{
		int f = n;
		while(--n > 1)
		{
			f = f*n;
		}
		
		return f;
	}

	public String getElement(int[] elements, int n)
	{
		int i = 0;
		int j = 0;
		while(i < elements.length)
		{
			if(elements[i] > 0)
			{
				if(j == n) 
				{
					String s = String.valueOf(elements[i]);
					elements[i] = 0;
					return s;
				}
				j++;
			}
			i++;
		}
		
		return "";
	}
	
	
	 public static void main(String[] args) throws Exception 
	 {
		long t1 = System.currentTimeMillis();
	 	sample1();
	 	sample2();
	 	sample3();
	 	sample4();
	 	sample5();
	 	sample6();
	 	System.out.println("Time = "+ (System.currentTimeMillis() - t1));
	 }
	
	 public static void sample1() //"213"
	 {
		String ans = new PermutationSequence().getPermutation(3, 3);
		System.out.println(ans);
	 }

	 public static void sample2() //"2314"
	 {
			String ans = new PermutationSequence().getPermutation(4, 9);
			System.out.println(ans);
	 }

	 public static void sample3() //"123"
	 {
		 String ans = new PermutationSequence().getPermutation(3, 1);
		 System.out.println(ans);
	 }
	 
	 public static void sample4() //"321"
	 {
		 String ans = new PermutationSequence().getPermutation(3, 6);
		 System.out.println(ans);
	 }

	 public static void sample5() //"1"
	 {
		 String ans = new PermutationSequence().getPermutation(1, 1);
		 System.out.println(ans);
	 }

	 public static void sample6() //"21"
	 {
		 String ans = new PermutationSequence().getPermutation(2, 2);
		 System.out.println(ans);
	 }
}