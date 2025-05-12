package com.fraza.leetcode;


// https://leetcode.com/problems/subarray-sum-equals-k/description/
public class ConstructRectangle {

	public int[] constructRectangle(int area) {
		int i = (int)Math.round(Math.sqrt(area));
		int w = 1;
		while(i>w)
		{
			if(area%i == 0) break;
			i--;
		}
		return new int[] {area/i, i};
    }


    public static void main(String[] args) throws Exception {
    	int[] ans;
    	ans = sample1();System.out.println(ans[0] + "," + ans[1]);
    	ans = sample2();System.out.println(ans[0] + "," + ans[1]);
    	ans = sample3();System.out.println(ans[0] + "," + ans[1]);
	}
    
	public static int[] sample1() 
	{
		return new ConstructRectangle().constructRectangle(4);
	}
	
	public static int[] sample2() 
	{
		return new ConstructRectangle().constructRectangle(37);
	}

	public static int[] sample3() 
	{
		return new ConstructRectangle().constructRectangle(122122);
	}
}
