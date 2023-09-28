package com.fraza.algo.dynamicprog;

import java.util.HashMap;

class FindPathInGrid
{
	static int[][] grid;
	static int rows = 0;
	static int cols = 0;
	static int calls = 0;
	public static void createGrid()
	{
		grid = new int[][] 
		{
			{1,1,1,1,1,1,1,1},
			{1,1,0,1,1,1,0,1},
			{1,1,1,1,0,1,1,1},
			{0,1,0,1,1,0,1,1},
			{1,1,0,1,1,1,1,1},
			{1,1,1,0,0,1,0,1},
			{1,0,1,1,1,0,1,1},
			{1,1,1,1,1,1,1,1},
		};
		rows = grid.length;
		cols = grid[0].length;
	}
	public static void main(String[] args)
	{
		createGrid();
		
		System.out.println("Total paths = " + countPathsSimpleRecursion(0, 0));
		System.out.println("Total calls = " +calls);

		calls = 0;
		System.out.println("Total paths = " + countPathsMemoRecursion(0, 0));
		System.out.println("Total calls = " +calls);
	}

	public static int countPathsSimpleRecursion(int row, int col)
	{
		calls++;
		if(row == rows || col == cols) return 0;
		if(grid[row][col] == 0) return 0;
		if(row == rows-1 && col == cols-1) return 1; 
		return countPathsSimpleRecursion(row+1, col) + countPathsSimpleRecursion(row, col+1);
	}
	
	public static HashMap<Integer,Integer> memo = new HashMap<Integer,Integer>(); 
	public static int countPathsMemoRecursion(int row, int col)
	{
		System.out.println("Fib called for "+(10*row+col));calls++;
		if(row == rows || col == cols) return 0;
		if(grid[row][col] == 0) return 0;
		if(row == rows-1 && col == cols-1) return 1;

		int key = 10*row+col;
		if(memo.containsKey(key)) return memo.get(key);
		int down = (memo.containsKey(10*(row+1)+col)) ? memo.get(10*(row+1)+col) : countPathsMemoRecursion(row+1, col);
		memo.put(10*(row+1)+col, down);
		int right = (memo.containsKey(10*row+col+1)) ? memo.get(10*row+col+1) : countPathsMemoRecursion(row, col+1);
		memo.put(10*row+col+1, right);
		int count = down + right;
//		int count = countPathsMemoRecursion(row+1, col) + countPathsMemoRecursion(row, col+1);
		memo.put(key, count);
		return count;
	}
}
