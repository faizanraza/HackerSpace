package com.fraza.leetcode;

import java.util.HashMap;

//https://leetcode.com/problems/two-sum/description/
public class TwoSum {

	public int[] twoSum(int[] nums, int target) 
	{
		int len = nums.length;
		
		HashMap<Integer, Integer> numMap = new HashMap<Integer, Integer>();
		for(int i=0; i<len; i++)
		{
			Integer j = numMap.get(target - nums[i]);
			numMap.put(nums[i], i);
			if(j != null && j != i)
			{
				return new int[]{j, i};
			}
		}
		
	 	return new int[0];
	 }

	public int[] twoSum2(int[] nums, int target) 
	{
		int len = nums.length;
		
		HashMap<Integer, Integer> numMap = new HashMap<Integer, Integer>();
		for(int i=0; i<len; i++)
		{
			//if(!numMap.containsKey(nums[i])) // this line degrades performance from 63% to 58%
				numMap.put(nums[i], i);
		}
		
		for(int i=0; i<len; i++)
		{
			Integer j = numMap.get(target - nums[i]);
			if(j != null && j != i)
			{
				return new int[]{i, j};
			}
		}
		
	 	
	 	return new int[0];
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
	
	 public static void sample1() //0,1
	 {
		int[] nums = {2,7,11,15};
		int[] ans = new TwoSum().twoSum(nums, 9);
		System.out.println(ans[0] + "," + ans[1]);
	 }

	 public static void sample2() //1,2
	 {
		int[] nums = {3,2,4};
		int[] ans = new TwoSum().twoSum(nums, 6);
		System.out.println(ans[0] + "," + ans[1]);
	 }

	 public static void sample3() //0,1
	 {
		int[] nums = {3,3};
		int[] ans = new TwoSum().twoSum(nums, 6);
		System.out.println(ans[0] + "," + ans[1]);
	 }
	 
	 public static void sample4() //
	 {
		int[] nums = {3,2,3,-1,0,-55,3,2,3,-1,0,0,3,75,3,2,3,-1,999999999,3,2,3,-1,0,-5,3,2,3,-1,0,0,3,7,3,25,3,-1,0,3,2,3,-1,0,-5,35,2,3,-1,0,0,3,7,35,2,3,-15,0,3,2,3,-1,50,-5,3,2,3,-1,0,0,3,57,3,2,3,-1,0,3,2,53,-1,0,-5,3,2,3,-1,0,0,3,7,3,2,3,-551,0,3,2,3,-1,0,-5,3,2,3,-1,0,0,3,557,3,2,355,-1,0,3,2,3,-1,0,-5,3,2,3,-1,0,0,3,7,3,2,3,-1,0,3,2,3,-1,550,-5,3,2,3,-1,0,0,3,7,3,2,3,-1,0,3,2,3,-1,0,-5,3,2,3,-1,0,0,3,7,3,2,3,-1,0,3,2,3,-1,0,-5,3,2,3,-1,0,0,3,7,3,2,3,-1,0,3,2,3,-1,0,-5,3,2,3,-1,0,0,3,7,3,2,3,-1,0,3,2,3,-1,0,-5,3,2,3,-1,0,0,3,7,3,2,3,-1,0,3,2,3,-1,0,-5,3,2,3,-1,0,0,3,7,3,2,3,-1,0,3,2,3,-1,0,-5,3,2,3,-1,0,0,3,7,3,2,3,-1,0,3,2,3,-1,0,-5,3,2,3,-1,0,0,3,7,3,2,3,-1,0,-1,0,3,2,3,-1,0,-5,3,2,3,-1,0,0,3,7,3,2,3,-1,0,3,2,3,-1,0,-5,3,2,3,-1,0,0,3,7,-9,11,-1,0,3,2,3,-1,0,-5,3,2,3,-1,0,0,3,7,3,2,3,-1,0,3,2,3,-1,0,-5,3,2,3,-1,0,0,3,7,3,2,3,-1,0,-55,3,2,3,-1,0,0,3,75,3,2,3,-1,999999999,3,2,3,-1,0,-5,3,2,3,-1,0,0,3,7,3,25,3,-1,0,3,2,3,-1,0,-5,35,2,3,-1,0,0,3,7,35,2,3,-15,0,3,2,3,-1,50,-5,3,2,3,-1,0,0,3,57,3,2,3,-1,0,3,2,53,-1,0,-5,3,2,3,-1,0,0,3,7,3,2,3,-551,0,3,2,3,-1,0,-5,3,2,3,-1,0,0,3,557,3,2,355,-1,0,3,2,3,-1,0,-5,3,2,3,-1,0,0,3,7,3,2,3,-1,0,3,2,3,-1,550,-5,3,2,3,-1,0,0,3,7,3,2,3,-1,0,3,2,3,-1,0,-5,3,2,3,-1,0,0,3,7,3,2,3,-1,0,3,2,3,-1,0,-5,3,2,3,-1,0,0,3,7,3,2,3,-1,0,3,2,3,-1,0,-5,3,2,3,-1,0,0,3,7,3,2,3,-1,0,3,2,3,-1,0,-5,3,2,3,-1,0,0,3,7,3,2,3,-1,0,3,2,3,-1,0,-5,3,2,3,-1,0,0,3,7,3,2,3,-1,0,3,2,3,-1,0,-5,3,2,3,-1,0,0,3,7,3,2,3,-1,0,3,2,3,-1,0,-5,3,2,3,-1,0,0,3,7,3,2,3,-1,0,-1,0,3,2,3,-1,0,-5,3,2,3,-1,0,0,3,7,3,2,3,-1,0,3,2,3,-1,0,-5,3,2,3,-1,0,0,3,7,-9,11,-1,0,3,2,3,-1,0,-5,3,2,3,-1,0,0,3,7,3,2,3,-1,0,3,2,3,-1,0,-5,3,2,3,-1,0,0,3,7};
		int[] ans = new TwoSum().twoSum(nums, 4);
		System.out.println(ans[0] + "," + ans[1]);
	 }

	 public static void sample5() //1,3
	 {
		int[] nums = {-1000000000,999999999,1000000000, 2, 1};
		int[] ans = new TwoSum().twoSum(nums, 1000000001);
		System.out.println(ans[0] + "," + ans[1]);
	 }
}