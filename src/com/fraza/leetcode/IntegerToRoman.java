package com.fraza.leetcode;

//https://leetcode.com/problems/integer-to-roman/submissions/1388511979/?envType=study-plan-v2&envId=top-interview-150
public class IntegerToRoman {

	public String intToRoman(int num)
	{
		StringBuilder sb = new StringBuilder();
		int th = num/1000;
		int h = (num - th*1000)/100;
		int t = (num - th*1000 - h*100)/10;
		int o = (num - th*1000 - h*100 - t*10);
		
		int i=0;
		while(i++ < th) sb.append("M");
		
		if(h == 9) sb.append("CM");
		else if(h == 4) sb.append("CD");
		else 
		{
			if(h >= 5) sb.append("D");
			h = h % 5;
			i=0;
			while(i++ < h) sb.append("C");
		}
		
		if(t == 9) sb.append("XC");
		else if(t == 4) sb.append("XL");
		else 
		{
			if(t >= 5) sb.append("L");
			t = t % 5;
			i=0;
			while(i++ < t) sb.append("X");
		}

		if(o == 9) sb.append("IX");
		else if(o == 4) sb.append("IV");
		else 
		{
			if(o >= 5) sb.append("V");
			o = o % 5;
			i=0;
			while(i++ < o) sb.append("I");
		}
		
		return sb.toString();
	 }
	
	 public static void main(String[] args) throws Exception 
	 {
	 	sample1();
	 	sample2();
	 	sample3();
	 	sample4();
	 	sample5();
	 	sample6();
	 }
	
	 public static void sample1() //LVIII
	 {
		int nums = 58;
		String ans = new IntegerToRoman().intToRoman(nums);
		System.out.println(ans);
	 }

	 public static void sample2() //MCMXCIV
	 {
		int nums = 1994;
		String ans = new IntegerToRoman().intToRoman(nums);
		System.out.println(ans);
	 }
	 
	 public static void sample3() //
	 {
		int nums = 3999;
		String ans = new IntegerToRoman().intToRoman(nums);
		System.out.println(ans);
	 }

	 public static void sample4() //
	 {
		int nums = 1;
		String ans = new IntegerToRoman().intToRoman(nums);
		System.out.println(ans);
	 }

	 public static void sample5() //
	 {
		int nums = 1915;
		String ans = new IntegerToRoman().intToRoman(nums);
		System.out.println(ans);
	 }

	 public static void sample6() //DXCIV
	 {
		int nums = 594;
		String ans = new IntegerToRoman().intToRoman(nums);
		System.out.println(ans);
	 }
}