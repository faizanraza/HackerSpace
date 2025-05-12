package com.fraza.leetcode;

// https://leetcode.com/problems/subarray-sum-equals-k/description/
public class Add2Numbers {

	 public static class ListNode {
	     int val;
	     ListNode next;
	     ListNode() {}
	     ListNode(int val) { this.val = val; }
	     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	     public String toString() {
	    	 String s = String.valueOf(val);
	    	 if(next != null) s+= "," + next.toString();
	    	 return s;
	     }
	}
	 
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode ans = new ListNode();
		ListNode tmp = ans;
		int carry = 0;
		while(l1 != null && l2 != null)
		{
			int sum = carry + l1.val + l2.val;
			tmp.val = sum%10;
			carry = sum/10;
			l1 = l1.next;
			l2 = l2.next;
			if(l1 != null || l2 != null)
			{
				tmp.next = new ListNode();
				tmp = tmp.next;
			}
		}
		while(l1 != null)
		{
			int sum = carry + l1.val;
			tmp.val = sum%10;
			carry = sum/10;
			l1 = l1.next;
			if(l1 != null)
			{
				tmp.next = new ListNode();
				tmp = tmp.next;
			}
		}
		while(l2 != null)
		{
			int sum = carry + l2.val;
			tmp.val = sum%10;
			carry = sum/10;
			l2 = l2.next;
			if(l1 != null || l2 != null)
			{
				tmp.next = new ListNode();
				tmp = tmp.next;
			}
		}
		if(carry > 0) tmp.next = new ListNode(carry);

		return ans;
    }


    public static void main(String[] args) throws Exception {
    	sample2();
    	sample3();
	}
    
    public static ListNode getSampleLN(String str) {
    	String[] arrStr = str.split(",");
    	ListNode ln = new ListNode(Integer.parseInt(arrStr[0]));
    	ListNode tmp = ln;
    	for(int i=1; i<arrStr.length; ++i)
    	{
    		tmp.next = new ListNode(Integer.parseInt(arrStr[i]));
    		tmp = tmp.next;
    	}
    	return ln;
    }

    public static void sample1() {
    	System.out.println(new Add2Numbers().addTwoNumbers(getSampleLN("2,4,3"), getSampleLN("5,6,4")));
	}

    public static void sample2() {
    	System.out.println(new Add2Numbers().addTwoNumbers(getSampleLN("0"), getSampleLN("0")));
	}

    public static void sample3() {
    	System.out.println(new Add2Numbers().addTwoNumbers(getSampleLN("9,9,9,9,9,9,9"), getSampleLN("9,9,9,9")));
	}
}
