package com.fraza.leetcode;

//https://leetcode.com/problems/next-permutation/description/
public class PermutationNextSequence
{
	public void nextPermutation(int[] nums)
	{
		int len = nums.length;
		if(len == 0 ) return;
		int i = len - 2;
		int j = len - 1;
		int prev = nums[j];
		boolean found = false;
		while(i >= 0)
		{
			if(nums[i] < prev) //find next sequence now
			{
				int k = i + 1;
				while(k <= j && nums[k] > nums[i])
					k++;
				k--;
				int tmp = nums[i];
				nums[i] = nums[k];
				nums[k] = tmp;
				
				i++;
				while(i < j)
				{
					tmp = nums[i];
					nums[i] = nums[j];
					nums[j] = tmp;
					i++;
					j--;
				}
				
				found = true;
				break;
			}
			prev = nums[i--];
		}
		if(!found)
		{
			i=0;
			j=len-1;
			while(j>i)
			{
				int tmp = nums[i];
				nums[i] = nums[j];
				nums[j] = tmp;
				i++;
				j--;
			}
		}
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
		sample7();
		System.out.println("Time = " + (System.currentTimeMillis() - t1));
	}

	public static void sample1()//132
	{
		int[] nums = { 1,2,3 };
		new PermutationNextSequence().nextPermutation(nums);
		for(int n: nums)
			System.out.print(n + ",");
		System.out.println();
	}

	public static void sample2() // "123"
	{
		int[] nums = {3,2,1};
		new PermutationNextSequence().nextPermutation(nums);
		for(int n: nums)
			System.out.print(n + ",");
		System.out.println();
	}

	public static void sample3() // "2803174569"
	{
		int[] nums = { 2, 8, 0, 3, 1, 6, 9, 7, 5, 4 };
		new PermutationNextSequence().nextPermutation(nums);
		for(int n: nums)
			System.out.print(n + ",");
		System.out.println();
	}

	public static void sample4() // "82"
	{
		int[] nums = {2, 8};
		new PermutationNextSequence().nextPermutation(nums);
		for(int n: nums)
			System.out.print(n + ",");
		System.out.println();
	}

	public static void sample5() // "28"
	{
		int[] nums = {8, 2};
		new PermutationNextSequence().nextPermutation(nums);
		for(int n: nums)
			System.out.print(n + ",");
		System.out.println();
	}

	public static void sample6() // "2"
	{
		int[] nums = {2};
		new PermutationNextSequence().nextPermutation(nums);
		for(int n: nums)
			System.out.print(n + ",");
		System.out.println();
	}

	public static void sample7() // ""
	{
		int[] nums = {1,1,5};
		new PermutationNextSequence().nextPermutation(nums);
		for(int n: nums)
			System.out.print(n + ",");
		System.out.println();
	}
}