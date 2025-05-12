package com.fraza.tools.stock;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.SortedMap;
import java.util.TreeMap;

//This object is used to hold the YFin data for all the stocks
public class YFinDataHolder
{
	SortedMap<String, String> minMaxData = new TreeMap<String, String>();
	HashMap<String, ArrayList<String>> historicalData = new HashMap<String, ArrayList<String>>();
	
	public void updateMinMax(String symbol, String record)
	{
		minMaxData.put(symbol, record);
	}
	
	public void updateHistoricalData(String symbol, ArrayList<String> records)
	{
		historicalData.put(symbol, records);
	}
	
	public void printMinMax()
	{
		for(String symbol: minMaxData.keySet())
		{
			String minMaxRecord = minMaxData.get(symbol);
			System.out.println(minMaxRecord);
		}
	}

	public void printHistoricalData()
	{
		for(String symbol: historicalData.keySet())
		{
			ArrayList<String> records = historicalData.get(symbol);
			for(String record: records)
			{
				System.out.println(record);
			}
		}
	}

	public void saveHistoricalData(String filePath, String headerRecord)
	{
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) 
		{
			if(null != headerRecord)
			{
				writer.write(headerRecord);
                writer.newLine();
			}
			for(String symbol: historicalData.keySet())
			{
				ArrayList<String> records = historicalData.get(symbol);
				for(String record: records)
				{
					writer.write(record);
	                writer.newLine();
				}
			}
        }
		catch (IOException e) 
		{
            System.err.println("An error occurred writing to the file: " + e.getMessage());
        }
	}

	public void saveMinMaxData(String filePath, String headerRecord)
	{
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) 
		{
			if(null != headerRecord)
			{
				writer.write(headerRecord);
                writer.newLine();
			}
			for(String symbol: minMaxData.keySet())
			{
				String record = minMaxData.get(symbol);
				writer.write(record);
	            writer.newLine();
			}
        }
		catch (IOException e) 
		{
            System.err.println("An error occurred writing to the file: " + e.getMessage());
        }
	}
}
