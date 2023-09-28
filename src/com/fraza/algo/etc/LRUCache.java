package com.fraza.algo.etc;

import java.util.HashMap;

public class LRUCache
{
	public static void main(String[] args)
	{
		LRUCache c = new LRUCache(10);
		int i=0;
		while(i++ < 100)
		{
			int key = (int)(20.0 * Math.random()) + 1;
			int value = key;
			c.put(key, value);
			c.print();
			
			if(key >= 10)
			{
				key = (int)(20 * Math.random());
				c.get(key);
				c.print();
			}
		}
	}
	
	int capacity = 10;
	public HashMap<Integer, Node> map = null;
	Node head;
	Node tail;
	
	public LRUCache(int c)
	{
		capacity = c;
		map = new HashMap<Integer, Node>(c);
	}
	
	public Integer get(int key)
	{
		System.out.print("\nGet " + key);
		Node t = map.get(key);
		if(t == null) return null;
		
		used(t.key);
		return t.value;
	}

	//a new data is pushed to the tail and the head is removed if exceeds capacity
	public void put(int key, int value)
	{
		System.out.print("\nPut " + key);
		if(map.get(key) != null) //if already exists just put to tail
		{
			used(key);
			return;
		}

		//if over-size, evict
		if(map.size() >= capacity && head != null)
		{
			map.remove(head.key);//remove from map
			if(head != null)//remove head from list
			{
				head = head.next;
				if(head != null) head.prev = null;
			}
		}
		
		//add element to map and add key to the linked list
		Node n = new Node(key, value);
		if(head == null) head = n;
		else if(tail != null)
		{
			tail.next = n;
			n.prev = tail;
			tail = n;
		}
		else
		{
			head.next = n;
			n.prev = head;
			tail = n;
		}
		map.put(key, n);
	}
	
	//when a data is used from the cache its moved to the tail/recent
	public void used(int key)
	{
		Node node = map.get(key);
		if (node != null)
		{
			Node p = node.prev;
			Node n = node.next;
			
			if(n == null) return;//already at end
			else n.prev = p;			
			if(p == null) head = n;//its the first element
			else p.next = n;
			
			if(tail != null && tail.key != key)
			{
				tail.next = node;
				node.prev = tail;
				node.next = null;
				tail = node;
			}
			System.out.print(" >> FOUND "+ key);
		}
	}

	public void print()
	{
		System.out.print(" >> Map-size = " + map.size()+ " List >> ");
		Node t = head;
		while(t != null)
		{
			System.out.print( t.key + "," );
			t = t.next;
		}
	}
}

class Node
{
	int key;
	int value;
	Node prev;
	Node next;
	
	Node(int key, int value)
	{
		this.key = key;
		this.value = value;
	}
}