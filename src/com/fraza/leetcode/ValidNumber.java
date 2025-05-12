package com.fraza.leetcode;

//https://leetcode.com/problems/valid-number/
public class ValidNumber {

	public boolean isNumber(String s)
	{
		int len = s.length();
		if(len == 0) return false;
		if(s.startsWith("-") || s.startsWith("+"))
		{
			if(len == 1) return false;
			s = s.substring(1);
			len = s.length();
		}
		if(s.startsWith("-") || s.startsWith("+") || s.equals("Infinity")) return false;
		
//		int lastChar = s.charAt(len-1);
//		if((lastChar < 65 || lastChar > 122) || (lastChar > 90 && lastChar < 97))
//			if(lastChar != 46) return false;

		String s2 = null;
		int e = s.indexOf("e");
		int E = s.indexOf("E");
		if(e > -1)//69, 101
		{
			s2 = s.substring(e+1);
			if(s2.startsWith("-") || s2.startsWith("+")) s2 = s2.substring(1);
			s = s.substring(0, e);
		}
		else if(E > -1)
		{
			s2 = s.substring(E+1);
			if(s2.startsWith("-") || s2.startsWith("+")) s2 = s2.substring(1);
			s = s.substring(0, E);
		}
		
		if(null != s2)
		{
			try
			{
				Double.parseDouble(s);
				Integer.parseInt(s2);
				return true;
			}
			catch(NumberFormatException nfe)
			{
				return false;
			}
		}
		else
		{
			try
			{
				Double.parseDouble(s);
				return true;
			}
			catch(NumberFormatException nfe)
			{
				return false;
			}
		}
	}

	public boolean isNumber1(String s)
	{
		try
		{
			if("Infinity".equals(s) || "-Infinity".equals(s) || "+Infinity".equals(s) || s.endsWith("f") || s.endsWith("F") || s.endsWith("d") || s.endsWith("D"))
                return false;
			Double.parseDouble(s);
			return true;
		}
		catch(NumberFormatException e)
		{
			return false;
		}
	}
	
	 public static void main(String[] args) throws Exception 
	 {
		long t1 = System.currentTimeMillis();
	 	sample1();
	 	sample2();
	 	System.out.println("Time = "+ (System.currentTimeMillis() - t1));
	 }
	
	 public static void sample1() //true
	 {
		String[] strs = new String[] {"2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"};
		for(String str: strs)
		{
			boolean ans = new ValidNumber().isNumber(str);
			System.out.println(str + " -> " + ans);
		}
	 }

	 public static void sample2() //false
	 {
		 System.out.println("sample 2 >>>>>>>>>>>>>>>>");
		String[] strs = new String[] {"", "-", "abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53", "959440.94F", "959440.94f", "959440.94d", "84656e656D", "1234567890L","1234567890l", "Infinity", "+Infinity", "-Infinity"};
		for(String str: strs)
		{
			boolean ans = new ValidNumber().isNumber(str);
			System.out.println(str + " -> " + ans);
		}
	 }
}