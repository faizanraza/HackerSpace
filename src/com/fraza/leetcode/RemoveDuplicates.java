package com.fraza.leetcode;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150
public class RemoveDuplicates {

	public int removeDuplicates(int[] nums) 
	{
		int len = nums.length;
		int i = 0, j = 1;
		int dups = 0;
		// replace all dups with -101
		while (j < len)
		{
			while (j < len && nums[i] == nums[j])
			{
				nums[j++] = -101;
				dups++;
			}
			i=j;
			j++;
		}
		
		//pull the non dups back
		i=0;
		while(i < (len - dups))
		{
			if(nums[i] == -101)
			{
				j = i+1;
				while(j < len && nums[j] == -101)
				{
					j++;
				}
				nums[i] = nums[j];
				nums[j] = -101;
			}
			i++;
		}
	 	
	 	return len - dups;
	 }
	
	 public static void main(String[] args) throws Exception 
	 {
	 	sample2();
	 }
	
	 public static void sample1() 
	 {
		int[] nums = {0,0,1,1,1,2,2,3,3,4,4,4,4,5};
		int ans = new RemoveDuplicates().removeDuplicates(nums);
		System.out.println(ans);
	 }

	 public static void sample2() 
	 {
		int[] nums = {1,2,2,3};
		int ans = new RemoveDuplicates().removeDuplicates(nums);
		System.out.println(ans);
	 }
}