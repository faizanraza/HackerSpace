package com.fraza.tools.stock;

import java.util.ArrayList;
import java.util.List;

import com.fraza.tools.excel.ExcelHandler;

//This is an old code to read stock alerts from csv/excel
public class StockDataMain
{
	public static String defaultDelimiter = ",";
	public static String defaultDuration = "1mo";
	
	public static List<StockData> getStockAlerts() throws Exception
	{
		final List<StockData> stockDataList = new ArrayList<StockData>();

		//Fetch all stocks from holding csv/excel
		final List<String> records = ExcelHandler.readCSV(ExcelHandler.holdingsCSVFile, true);
		
		//For each record get current stock data
		for(String record: records)
		{
			StockData stockData = StockData.create(record, defaultDelimiter);
			String yfinResponse = YFinDataCollector.getStockDataResponse(stockData.symbol, defaultDuration);
			stockData = StockData.update(stockData, yfinResponse);
			
			stockDataList.add(stockData);
		}
		return stockDataList;
	}
	
	public static void main(String[] args) throws Exception
	{
		List<StockData> stockDataList = StockDataMain.getStockAlerts();
	}
}
