package com.fraza.algo.recursion;

public class ConjoinedLinkList 
{
	static Node s1;
	static Node s2;
	static class Node
	{
		int data;
		Node next;
		Node(int d)
		{
			data = d;
		}
		Node getNext()
		{
			return next;
		}
	}

	static void createSample()
	{
		s1 = new Node(11);
		s1.next = new Node(12);
		s1.next.next = new Node(13);
		s1.next.next.next = new Node(14);
		s1.next.next.next.next = new Node(15);
		s1.next.next.next.next.next = new Node(16);
		s1.next.next.next.next.next.next = null;
		
		s2 = new Node(21);
		s2.next = new Node(22);
		s2.next.next = new Node(23);
		s2.next.next.next = new Node(24);
		s2.next.next.next.next = new Node(25);
		s2.next.next.next.next.next = s1.next.next.next;
	}
	
	static void print(Node s)
	{
		while(s != null)
		{
			System.out.print(s.data + " -> ");
			s = s.next; 
		}
		System.out.println("End");
	}
	
	static void findIntersection(Node s1, Node s2)
	{
		if(s1.next != null || s2.next != null)
		{
			findIntersection(s1.next==null?s1:s1.next, s2.next==null?s2:s2.next);
		}
		if(s1.next == null && s2.next == null)
		{
			//start returning back
			System.out.println("Reached End - " + s1.data);
		}
		if( s1.next == s2.next && s1 != s2 )
		{
			System.out.println("Intersection is " + s1.next.data);
		}
	}

	public static void main(String[] args) 
	{
		createSample();
		print(s1);print(s2);
		
		findIntersection(s1, s2);
	}
}
