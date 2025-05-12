package com.fraza.leetcode;

//https://leetcode.com/problems/trapping-rain-water/submissions/1386218978/?envType=study-plan-v2&envId=top-interview-150
public class TrapRainWater {

	public int trap(int[] height)
	{
		int water = 0;
		int i = 0;
		while(i < height.length)
		{
			int j = i+1;			
			while(j < height.length && height[j] < height[i])
			{
				j++;
			}
			
			int k = j-1;
			int maxHeight = (j == height.length)? height[k] : height[i];
			while(k>i)
			{
				water += (maxHeight - height[k]);
				k--;
				maxHeight = Math.max(maxHeight, height[k]);
			}
			i = j;
		}

		return water;
	 }
	
	 public static void main(String[] args) throws Exception 
	 {
	 	sample1();
	 	sample2();
	 	sample3();
	 	sample4();
	 	sample5();
	 	sample6();
	 	sample7();
	 }
	
	 public static void sample1() //32
	 {
		int[] nums = {2,1,0,7,4,3,2,3,0,2,6,3,1,5,3,4};
		int ans = new TrapRainWater().trap(nums);
		System.out.println(ans);
	 }

	 public static void sample2() //6
	 {
		int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
		int ans = new TrapRainWater().trap(nums);
		System.out.println(ans);
	 }
	 
	 public static void sample3() //9
	 {
		int[] nums = {4,2,0,3,2,5};
		int ans = new TrapRainWater().trap(nums);
		System.out.println(ans);
	 }

	 public static void sample4() //0
	 {
		int[] nums = {4};
		int ans = new TrapRainWater().trap(nums);
		System.out.println(ans);
	 }

	 public static void sample5() //0
	 {
		int[] nums = {0,0,0};
		int ans = new TrapRainWater().trap(nums);
		System.out.println(ans);
	 }

	 public static void sample6() //0
	 {
		int[] nums = {4,3,2};
		int ans = new TrapRainWater().trap(nums);
		System.out.println(ans);
	 }

	 public static void sample7() //0
	 {
		int[] nums = {2,3,4};
		int ans = new TrapRainWater().trap(nums);
		System.out.println(ans);
	 }
}