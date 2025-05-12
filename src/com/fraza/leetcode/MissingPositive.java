package com.fraza.leetcode;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150
public class MissingPositive {

	public int firstMissingPositive(int[] nums) 
	{
		int len = nums.length;
		for(int i=0; i<len; ++i)
		{
			int n = nums[i];
			while(n > 0 && n <= len && n != nums[n-1])
			{
				int x = nums[n-1];
				nums[n-1] = n;
				n = x;
			}
		}
		for(int i=0; i<len; ++i)
		{
			if(nums[i] != i+1) return i+1;
		}
	 	return len+1;
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
	 	sample8();
	 	sample9();
	 	sample10();
	 }
	
	 public static void sample1() //3
	 {
		int[] nums = {1,2,0};
		int ans = new MissingPositive().firstMissingPositive(nums);
		System.out.println(ans);
	 }

	 public static void sample2() //2
	 {
		int[] nums = {3,4,-1,1};
		int ans = new MissingPositive().firstMissingPositive(nums);
		System.out.println(ans);
	 }

	 public static void sample3() //1
	 {
		int[] nums = {7,8,9,11,12};
		int ans = new MissingPositive().firstMissingPositive(nums);
		System.out.println(ans);
	 }

	 public static void sample4() //4
	 {
		int[] nums = {100000, 3, 4000, 2, 15, 1, 99999};
		int ans = new MissingPositive().firstMissingPositive(nums);
		System.out.println(ans);
	 }

	 public static void sample5() //10
	 {
		int[] nums = {9,8,7,6,5,4,3,2,1};
		int ans = new MissingPositive().firstMissingPositive(nums);
		System.out.println(ans);
	 }

	 public static void sample6() //9
	 {
		int[] nums = {1,2,3,4,5,6,7,8};
		int ans = new MissingPositive().firstMissingPositive(nums);
		System.out.println(ans);
	 }

	 public static void sample7() //1
	 {
		int[] nums = {-9999};
		int ans = new MissingPositive().firstMissingPositive(nums);
		System.out.println(ans);
	 }

	 public static void sample8() //1
	 {
		int[] nums = {9999};
		int ans = new MissingPositive().firstMissingPositive(nums);
		System.out.println(ans);
	 }

	 public static void sample9() //1
	 {
		int[] nums = {0};
		int ans = new MissingPositive().firstMissingPositive(nums);
		System.out.println(ans);
	 }

	 public static void sample10() //2
	 {
		int[] nums = {1};
		int ans = new MissingPositive().firstMissingPositive(nums);
		System.out.println(ans);
	 }
}