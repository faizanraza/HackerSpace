package com.fraza.algo.codingninja;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//https://www.codingninjas.com/codestudio/problems/sum-of-infinite-array_873335
public class InfiniteArray 
{
    public static List<Integer> sumInRanges(int[] arr, int n, List<List<Long>> queries, int q) {

    	List<Integer> answer = new ArrayList<Integer>(queries.size());
    	int arr_len = arr.length;
    	
    	long sum=0;
    	for(int elem: arr)
    		sum+=elem;

        for(List<Long> query: queries)
        {
            long lB = query.get(0)-1;
            long rB = query.get(1)-1;
            long count = rB-lB+1;

            int div = (int)(count/arr_len);
            long total = sum * div;

            if(count % arr_len > 0)
            {
	            int lA = (int)(lB % arr_len);
	            int rA = (int)(rB % arr_len);
	            
	            if(lA <= rA)
	            {
		            for(int i=lA; i<=(int)rA; ++i)
		            {
		            	total += arr[i];
		            }
	            }
	            else
	            {
	            	total += sum;
	            	for(int i=rA+1; i<lA; ++i)
		            {
		            	total += arr[i];
		            }
		            /*for(int i=0; i<=(int)rA; ++i)
		            {
		            	total += arr[i];
		            }
		            for(int i=lA; i<arr_len; ++i)
		            {
		            	total += arr[i];
		            }*/
	            }
            }
            int mod_total = (int)(total % 1000000007);
            answer.add(mod_total);
        }

        return answer;
    }

    public static void main(String[] args) throws Exception {
    	TestInput1();
	}
    
    public static void TestInput1() throws Exception {
    	
    	Scanner scanner = new Scanner(new File("Testcases/CodingNinja/InfiniteArray/input3.txt"));
    	int nTC = Integer.parseInt(scanner.nextLine());
    	for(int i=0; i<nTC; i++)
    	{
    		int n = Integer.parseInt(scanner.nextLine());
    		String[] arrStr = scanner.nextLine().split(" ");
    		int[] arr = Arrays.stream(arrStr)
                    .mapToInt(Integer::parseInt).toArray();
    		
    		int q = Integer.parseInt(scanner.nextLine());
    		List<List<Long>> queries = new ArrayList<List<Long>>();
    		for(int j=0; j<q; ++j)
    		{
    			String[] qStr = scanner.nextLine().split(" ");
    			List<Long> a1 = new ArrayList<Long>(); 
    			a1.add(Long.parseLong(qStr[0]));
    			a1.add(Long.parseLong(qStr[1]));
    			queries.add(a1);
    		}
    		
    		System.out.println(sumInRanges(arr, n, queries, q)); 
    	}
    }

    public static void sample15() {//1090,8050,168
		
    	String[] arrStr = "98 7 985 65 5".split(" ");
    	int[] arr = Arrays.stream(arrStr)
                .mapToInt(Integer::parseInt).toArray();
    	
    	int n=2;
    	
    	List<List<Long>> q = new ArrayList<List<Long>>();
    	List<Long> a1;
    	a1 = new ArrayList<Long>(); a1.add(1l);a1.add(3l);q.add(a1);
    	a1 = new ArrayList<Long>(); a1.add(1l);a1.add(33l);q.add(a1);
    	a1 = new ArrayList<Long>(); a1.add(4l);a1.add(6l);q.add(a1);
    	
    	System.out.println(sumInRanges(arr, n, q, n)); 
	}
    
    public static void sample13() {//112,112
		
    	String[] arrStr = "12 14 53".split(" ");
    	int[] arr = Arrays.stream(arrStr)
                .mapToInt(Integer::parseInt).toArray();
    	
    	int n=2;
    	
    	List<List<Long>> q = new ArrayList<List<Long>>();
    	List<Long> a1;
    	a1 = new ArrayList<Long>(); a1.add(1l);a1.add(5l);q.add(a1);
    	a1 = new ArrayList<Long>(); a1.add(4l);a1.add(8l);q.add(a1);
    	
    	System.out.println(sumInRanges(arr, n, q, n)); 
	}
    
    public static void sample11() {//10,10,30,20
		
    	String[] arrStr = "10".split(" ");
    	int[] arr = Arrays.stream(arrStr)
                .mapToInt(Integer::parseInt).toArray();
    	
    	int n=2;
    	
    	List<List<Long>> q = new ArrayList<List<Long>>();
    	List<Long> a1; 
    	a1 = new ArrayList<Long>(); a1.add(1l);a1.add(1l);q.add(a1);
    	a1 = new ArrayList<Long>(); a1.add(7l);a1.add(7l);q.add(a1);
    	a1 = new ArrayList<Long>(); a1.add(3l);a1.add(5l);q.add(a1);
    	a1 = new ArrayList<Long>(); a1.add(1l);a1.add(2l);q.add(a1);
    	
    	System.out.println(sumInRanges(arr, n, q, n)); 
	}
    
    public static void sample2() {
		
    	String[] arrStr = "5 2 6 9".split(" ");
    	int[] arr = Arrays.stream(arrStr)
                .mapToInt(Integer::parseInt).toArray();
    	
    	int n=2;
    	
    	List<List<Long>> q = new ArrayList<List<Long>>();
    	List<Long> a1; 
    	a1 = new ArrayList<Long>(); a1.add(1l);a1.add(5l);q.add(a1);
    	a1 = new ArrayList<Long>(); a1.add(10l);a1.add(13l);q.add(a1);
    	a1 = new ArrayList<Long>(); a1.add(7l);a1.add(11l);q.add(a1);
    	
    	System.out.println(sumInRanges(arr, n, q, n)); 
	}
    
    public static void sample1() {
		
    	String[] arrStr = "1 2 3".split(" ");
    	int[] arr = Arrays.stream(arrStr)
                .mapToInt(Integer::parseInt).toArray();
    	
    	int n=2;
    	
    	List<List<Long>> q = new ArrayList<List<Long>>();
    	List<Long> a1;
    	a1 = new ArrayList<Long>(); a1.add(1l);a1.add(3l);q.add(a1);
    	a1 = new ArrayList<Long>(); a1.add(1l);a1.add(5l);q.add(a1);
    	
    	System.out.println(sumInRanges(arr, n, q, n)); 
	}
}
