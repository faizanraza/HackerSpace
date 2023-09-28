package com.fraza.algo.codingninja;

import java.util.* ;
import java.io.*;

//https://www.codingninjas.com/codestudio/problems/ayush-gives-ninjatest_1097574
public class AllocateBooks 
{
	public static long ayushGivesNinjatest(int n, int m, int[] time) 
    {
        int max=0, sum =0;
        int mn = (int) Math.round((double)m/n);
        for(int i=0; i<m; i++)
        {
            sum += time[i];
            
            int tmp = time[i];
            if(mn > 1 && i >= (mn-1) && i <= (m-mn))
            	tmp = Math.min(time[i]+time[i-1], time[i]+time[i+1]);
            	
            if(tmp > max) max = tmp;
        }
        
        long prevAnswer = Long.MAX_VALUE;
        long answer = solve(n, m, time, max, sum);
        System.out.println(answer + " max = " + max);
        while(answer < prevAnswer || answer == max)
        {
        	prevAnswer = answer;
        	answer = solve(n, m, time, --max, sum);
        	System.out.println(answer + " max = " + max);
        }
        
        return Math.min(prevAnswer, answer);
    }
	public static long solve(int n, int m, int[] time, int max, int sum) 
    {
		long answer = 0;
        int rem_days = n;
        int i = 0;
        while(i<m)
        {
            int study_time = time[i++];
            int avg_time = (int)Math.ceil(sum*1.0/rem_days);
            int max_limit = Math.max(max, avg_time);	
            while(i<m && rem_days <= (m-i) && (study_time + time[i]) <= max_limit)
            {
                study_time += time[i++];
            }
            System.out.println((n-rem_days+1) + " : " + study_time);
            sum -= study_time;
            if(study_time > answer) answer = study_time;
            rem_days--;
        }
        return answer;
    }

	public static void main(String[] args) 
	{
		test20();
	}

	public static void test20() //10
	{
		int n=10, m=12; //sum=80, avg/day=8+1
		String[] timeStr = "2 5 7 9 10 10 2 10 2 6 10 7".split(" ");
		
		int[] time = Arrays.stream(timeStr)
                .mapToInt(Integer::parseInt)
                .toArray();
        
		long answer = ayushGivesNinjatest(n, m, time);
		System.out.println(answer);
	}
	
	public static void test10() //14
	{
		int n=10, m=17; //sum=107, avg/day=11+1
		String[] timeStr = "1 5 7 6 9 7 1 6 10 3 9 5 2 10 10 6 10".split(" ");
		
		int[] time = Arrays.stream(timeStr)
                .mapToInt(Integer::parseInt)
                .toArray();
        
		long answer = ayushGivesNinjatest(n, m, time);
		System.out.println(answer);
	}
	
	public static void test7() //15
	{
		int n=7, m=12; //sum=81, avg/day=12+1
		String[] timeStr = "10 4 6 3 7 7 9 4 6 10 9 6".split(" ");
		
		int[] time = Arrays.stream(timeStr)
                .mapToInt(Integer::parseInt)
                .toArray();

		long answer = ayushGivesNinjatest(n, m, time);
		System.out.println(answer);
	}
	
	public static void test6() //10
	{
		int n=6, m=11; //sum=44, avg/day=8+1
		String[] timeStr = "5 5 4 1 3 1 6 5 10 2 2".split(" ");
		
		int[] time = Arrays.stream(timeStr)
                .mapToInt(Integer::parseInt)
                .toArray();
		
		long answer = ayushGivesNinjatest(n, m, time);
		System.out.println(answer);
	}

	public static void test1() //4
	{
		int n=3, m=5; //sum=9, avg/day=3+1
		String[] timeStr = "1 2 2 3 1".split(" ");
		
		int[] time = Arrays.stream(timeStr)
                .mapToInt(Integer::parseInt)
                .toArray();
		
		long answer = ayushGivesNinjatest(n, m, time);
		System.out.println(answer);
	}
/**
10 Testcases
1 1
2 
2 2
3 1 
3 5
1 4 1 6 4 
4 6
2 7 9 10 5 4 
5 8
8 2 10 7 9 3 4 7 
6 11
5 5 4 1 3 1 6 5 10 2 2 
7 12
10 4 6 3 7 7 9 4 6 10 9 6 
8 9
7 10 5 2 1 8 4 5 10 
9 11
2 4 10 8 2 10 9 8 8 4 6 
10 17
1 5 7 6 9 7 1 6 10 3 9 5 2 10 10 6 10 
10 output
2
3
6
10
12
10
15
10
10
14


10 Testcases
1 2
3 8 
2 2
1 10 
3 3
9 3 1 
4 7
1 8 2 4 2 4 10 
5 9
6 3 4 4 1 7 10 2 7 
6 12
6 6 1 5 9 6 3 8 3 4 3 3 
7 11
6 7 5 2 5 7 10 4 8 1 5 
8 12
2 3 8 5 5 5 8 8 3 3 7 7 
9 18
5 3 7 3 8 2 1 1 8 3 9 4 4 3 10 10 5 8 
10 12
2 5 7 9 10 10 2 10 2 6 10 7 
10 output
11
10
9
10
10
12
12
11
13
10
 **/
}
