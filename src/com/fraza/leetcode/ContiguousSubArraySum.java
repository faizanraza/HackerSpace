package com.fraza.leetcode;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/subarray-sum-equals-k/description/
public class ContiguousSubArraySum {

	public int subarraySum(int[] nums, int k) 
	{
        Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
        cache.put(0, 1);
        int count = 0;
        int sum = 0;

        for (int num : nums) {
            sum += num;
            int diff = sum - k;
            if (cache.containsKey(diff)) {
                count += cache.get(diff);
            }
            cache.put(sum, cache.getOrDefault(sum, 0) + 1);
        }

        return count;
	}
	public int subarraySum1(int[] nums, int k) 
	{
		int ans = 0;
		int len = nums.length;
		int l = 0;
		while(l<len)
		{
			int sum = nums[l];
			if(sum == k) ans++;
			int r = l+1;
			while(r<len)
			{
				sum += nums[r++];
				if(sum == k) ans++;
			}
			//if(sum == k) ans++;
			
			l++;
		}
		return ans;
    }


    public static void main(String[] args) throws Exception 
    {
    	long t1 = System.currentTimeMillis();
    	sample1();
    	sample2();
    	sample3();
    	sample4();
    	System.out.println("time = " + (System.currentTimeMillis() - t1));
	}
    public static void run(String[] arrStr, int k) {
    	int[] arr = new int[arrStr.length];
    	int i=0;
    	for(String a: arrStr)
    	{
    		arr[i++] = Integer.parseInt(a);
    	}
    	System.out.println(new ContiguousSubArraySum().subarraySum(arr, k)); 
	}
    
	public static void sample1() 
	{
    	run("1 1 1".split(" "), 2);
	}
	
	public static void sample2() 
	{
    	run("-1 -1 1".split(" "), 1);
	}

	public static void sample3() 
	{
    	run("2 -3 14 1 -5 11 -9 2 -19 4 20 -16 1 10 -4 0 8 -4 10 -13 15 8 -9 7 6 -12 14 1 10 -4 0 8 -4 10 6 -12 14 1 10 -4 0 8 -4 10 -13 15 8 -9 7 6 -12 14 0 -5 6 16 -12 2 -19 4 20 -16 1 10 -4 0 8 -4 10 -13 15 8 -9 7 6 -12 14 1 0 -5 6 16 -3 7 9 -11 0 8 4 -7 5 6 2 -3 14 1 -5 11 -9 2 -19 4 20 -16 1 10 -4 0 8 -4 10 -13 15 8 -9 7 6 -12 14 1 0 -5 6 16 -12 2 -19 4 20 -16 1 10 -4 0 8 -4 10 -13 15 8 -9 7 6 -12 14 1 0 -5 6 16 -3 7 9 -11 0 8 4 -7 5 6".split(" "), 12);
	}
	
	public static void sample4() 
	{
    	run("1 -1 0".split(" "), 0);
	}
}
