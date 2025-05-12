package com.fraza.leetcode;

//https://leetcode.com/problems/integer-to-roman/submissions/1388511979/?envType=study-plan-v2&envId=top-interview-150
public class ZigZagConversion {

	public String convert(String s, int numRows)
	{
		StringBuilder sb = new StringBuilder();
		
		int len = s.length();
		int setSize = 2*numRows - 2;
		if(setSize < 1) return s;
		int numSets = len/setSize + 1;
		
		int i=0;
		while(i < numRows)
		{
			int j = 0;
			while(j < numSets)
			{
				int k = i + j*setSize;
				if(k<len) sb.append(s.charAt(k));
				
				if(i > 0 && i < numRows-1)
				{
					k = k + 2*(numRows - i - 1);
					if(k<len) sb.append(s.charAt(k));
				}
				j++;
			}
			i++;
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
	
	 public static void sample1() //PAHNAPLSIIGYIR
	 {
		String str = "PAYPALISHIRING";
		int numRows = 3;
		String ans = new ZigZagConversion().convert(str, numRows);
		System.out.println(ans);
	 }

	 public static void sample2() //PINALSIGYAHRPI
	 {
		String str = "PAYPALISHIRING";
		int numRows = 4;
		String ans = new ZigZagConversion().convert(str, numRows);
		System.out.println(ans);
	 }

	 public static void sample3() //
	 {
		String str = "A";
		int numRows = 1;
		String ans = new ZigZagConversion().convert(str, numRows);
		System.out.println(ans);
	 }
	 
	 public static void sample4() //
	 {
		String str = "cgjgjFHFyedkjlhJYRGVMDH,dshfu.JRDCND,hgfcjagdsjhk.HGFHFNMGKHKHLKJLJLsgdjagkdghk,GGHFVHCHJBKJGVU.jgnvfchcjfhfch,HFXDHSZASGHBJ.gavsfdvmsgjbxjkehd";
		int numRows = 32;
		String ans = new ZigZagConversion().convert(str, numRows);
		System.out.println(ans);
	 }

	 public static void sample5() //
	 {
		String str = "ABCDEFG";
		int numRows = 5;
		String ans = new ZigZagConversion().convert(str, numRows);
		System.out.println(ans);
	 }

	 public static void sample6() //
	 {
		String str = "ABCDEFG";
		int numRows = 9;
		String ans = new ZigZagConversion().convert(str, numRows);
		System.out.println(ans);
	 }
}