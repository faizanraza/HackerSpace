package com.fraza.leetcode;

import java.util.HashMap;

//https://leetcode.com/problems/permutation-in-string/description/
public class LongestSubstring {

	public int lengthOfLongestSubstringKDistinct(String s, int k)
	{
		HashMap<Integer, Integer> longestSS = new HashMap<Integer, Integer>();
		int i=0;
		int j=0;
		int len = s.length();
		int ssLen = 0;
		while(longestSS.size() <= k && j < len)
		{
			int c = s.charAt(j);
			Integer freq = longestSS.get(c);
			if(null != freq)
			{
				longestSS.put(c, freq+1);
			}
			else if(longestSS.size() < k)
			{
				longestSS.put(c, 1);
			}
			else break;
			
			ssLen++;
			j++;
		}
		int max = ssLen;
		while(j < len)
		{
			int c = s.charAt(j);
			Integer freq = longestSS.get(c);

			if(null != freq)
			{
				longestSS.put(c, freq+1);
				ssLen++;
				j++;
			}
			else if(longestSS.size() < k)
			{
				longestSS.put(c, 1);
				ssLen++;
				j++;
			}
			else
			{
				int c1 = s.charAt(i);
				Integer f1 = longestSS.get(c1);
				if(null != f1)
				{
					if(f1 <= 1)
						longestSS.remove(c1);
					else
						longestSS.put(c1, f1-1);
					ssLen--;
				}
				i++;
			}

			max = Math.max(max, ssLen);
		}

		return max;
	}
	
	 public static void main(String[] args) throws Exception 
	 {
		long t1 = System.currentTimeMillis();
	 	sample1();
	 	sample2();
	 	sample3();
//	 	sample6();
	 	System.out.println("Time = "+ (System.currentTimeMillis() - t1));
	 }
	
	 public static void sample1() //3
	 {
		String str = "eceba";
		int k = 2;
		int ans = new LongestSubstring().lengthOfLongestSubstringKDistinct(str, k);
		System.out.println(ans);
	 }

	 public static void sample2() //2
	 {
			String str = "aa";
			int k = 1;
			int ans = new LongestSubstring().lengthOfLongestSubstringKDistinct(str, k);
			System.out.println(ans);
	 }

	 public static void sample3() //true
	 {
		 String str = "addddcsgggjdegggggwaffhuanmsssssxbggggjjjgggssssswrewssssffffrrrrhgjrrrrrdddwghmgkj";
		 int k = 5;
		 int ans = new LongestSubstring().lengthOfLongestSubstringKDistinct(str, k);
		 System.out.println(ans);
	 }

	 public static void sample6() //
	 {

	 }
}