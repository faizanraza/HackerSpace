package com.fraza.leetcode;

public class ArrayPopWinner {

    public boolean predictTheWinner(int[] nums) {
    	int len = nums.length;
    	int[] cumSums = new int[len];
    	int[][] maxSums = new int[len][len];
      
        for(int i=0; i<len; i++)
            if(i == 0)
                cumSums[i] = nums[i];
            else cumSums[i] = cumSums[i-1] + nums[i];

        for(int i=0; i<len; i++)
        {            
            for(int s=0; s<len-i; s++)
            {
                int e = s+i;System.out.println(s+":"+e);
                
                if(s == e)
                    maxSums[s][e] = nums[s];
                else if(s + 1 == e)
                    maxSums[s][e] = Math.max(nums[s],nums[e]);
                else // do recursion
                {                    
                    int choose_s = nums[s] + (cumSums[e]-cumSums[s+1]+nums[s+1]-maxSums[s+1][e]);
                    int choose_e = nums[e] + (cumSums[e-1]-cumSums[s]+nums[s]-maxSums[s][e-1]);
                    maxSums[s][e] = Math.max( choose_s, choose_e );                
                }
            }
        }
        return (maxSums[0][len-1] >= cumSums[len-1] - maxSums[0][len-1]);
    }

    public boolean predictTheWinnerDeprecate(int[] nums) {
        if(nums.length < 3) return true;
        
        int sum1=0, sum2=0;
        int s = 0, e = nums.length - 1; 
        boolean p1 = true;
        while(e >= s)
        {
        	//find best pop
        	int pop = 0;
        	if(e - s > 2)
        	{
        		int opt1 = nums[s]+ Math.max(Math.min(nums[s+1], nums[e]), nums[e-1]);
        		int opt2 = nums[e]+ Math.max(Math.min(nums[e-1], nums[s]), nums[s+1]);
        		if(opt1 >= opt2)
        			pop = nums[s++];
        		else
        			pop = nums[e--];
        	}
        	else
        	{
        		if(nums[e]>nums[s])
        			pop = nums[e--];
        		else
        			pop = nums[s++];
        	}
        	
    		if(p1)
    			sum1 += pop;
    		else
    			sum2 += pop;
        	p1 = !p1;
        }
        return sum1 >= sum2;
    }
    
    public static void main(String[] args) throws Exception {
    	sample1();//false
    	sample2();//true
//    	sample3();//true
//    	sample4();//false
//    	sample5();//true
	}
    public static void run(String[] arrStr) {
    	int[] arr = new int[arrStr.length];
    	int i=0;
    	for(String a: arrStr)
    	{
    		arr[i++] = Integer.parseInt(a);
    	}
    	System.out.println(new ArrayPopWinner().predictTheWinner(arr)); 
	}
    
	public static void sample1() //false
	{
    	run("1,5,2".split(","));
	}
	
	public static void sample2() //true
	{
		run("1,5,233,7".split(","));
	}

	public static void sample3() //true
	{
		run("1000,1000,1000,0,0,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000".split(","));
	}

	public static void sample4() //false
	{
		run("3606449,6,5,9,452429,7,9580316,9857582,8514433,9,6,6614512,753594,5474165,4,2697293,8,7,1".split(","));
	}

	public static void sample5() //true
	{
		run("1,2,3,4,999,3".split(","));
	}
}
