package com.fraza.leetcode;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/?envType=study-plan-v2&envId=top-interview-150
public class JumpGame {

	public boolean canJump(int[] nums)
	{
		int i = 0;

		boolean canHop = true;
		while(i < nums.length)
		{
			if(nums[i] == 0 && i<(nums.length-1))
			{
				canHop = false;
				int j = i-1;
				while(j>=0)
				{
					if(nums[j] > i-j)
					{
						canHop = true;
						break;
					}
					j--;
				}
				if(!canHop) return false;
			}
			i++;
		}

		return canHop;
	 }
	
	 public static void main(String[] args) throws Exception 
	 {
	 	sample1();
	 	sample2();
	 	sample3();
	 	sample4();
	 	sample5();
	 }
	
	 public static void sample1() 
	 {
		int[] nums = {2,3,1,1,4};
		boolean ans = new JumpGame().canJump(nums);
		System.out.println(ans);
	 }

	 public static void sample2() 
	 {
		int[] nums = {3,2,1,0,4};
		boolean ans = new JumpGame().canJump(nums);
		System.out.println(ans);
	 }
	 
	 public static void sample3() 
	 {
		int[] nums = {0};
		boolean ans = new JumpGame().canJump(nums);
		System.out.println(ans);
	 }

	 public static void sample4() 
	 {
		int[] nums = {1, 0};
		boolean ans = new JumpGame().canJump(nums);
		System.out.println(ans);
	 }

	 public static void sample5() 
	 {
		int[] nums = {2, 0, 0};
		boolean ans = new JumpGame().canJump(nums);
		System.out.println(ans);
	 }

	 
	 public static void sample6() 
	 {
		int[] nums = {2, 3, 5, 0, 2, 0, 1, 2, 0, 5, 6, 0, 1};
		boolean ans = new JumpGame().canJump(nums);
		System.out.println(ans);
	 }
}