package com.fraza.test;

import java.util.HashMap;

public class TempTest
{
	public static void main(String[] args)
	{
		System.out.println(3/2 + "," + 5/2 + "," + 5/4 + "," + 10/3 + "," + 11/3);
		
		String t1 = "test";
		char[] chArr = t1.toCharArray();
		
		System.out.println(t1);
		chArr[0] = 'p';
		System.out.println(chArr);
		
		
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		hm.put("a", 33);
		hm.put("m", 22);
		hm.put("z", 11);
		
		HashMap<String, Integer> hmcopy = (HashMap<String, Integer>) hm.clone();
		hmcopy.remove("m");
		hmcopy.put("z", 55);
		
		System.out.println(hm.size() + "," + hmcopy.size());
		System.out.println(hm.get("z") + "," + hmcopy.get("z"));
	}
}
