package com.fraza.tools.stock;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.fraza.tools.excel.ExcelHandler;
import com.fraza.util.SeleniumWebAgent;
import com.google.gson.Gson;

//This is to collect data from Yahoo Finance
//When yahoo return http 429 then change yfinHttpError=true
public class YFinDataCollector
{
	static String stockExcelFile = "/Users/fraza/Documents/StockMarket/StockDataTest.xlsx";
	static String stockExcelSheet = "StockList";
	static String stockDataDelim = ",";
	static String stockUrlBase = "https://query2.finance.yahoo.com/v8/finance/chart/";//"https://query1.finance.yahoo.com/v7/finance/chart/";
	static String stockUrlQueryString = "?range=1y&interval=1d";
	static String stockDefaultDuration = "1y";
	static String generatedHistData = "/Users/fraza/Documents/StockMarket/GeneratedHistData.csv";
	static String histDataHeader = "Symbol,Date,Open,High,Low,Close,Volume";
	static String generatedMinMaxData = "/Users/fraza/Documents/StockMarket/GeneratedMinMaxData.csv";
	static String minmaxDataHeader = "Symbol,min1y,max1y,min3mo,max3mo,min1mo,max1mo";
	static String chromeUserAgent = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/136.0.0.0 Safari/537.36";
	static String firefoxUserAgent = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:136.0) Gecko/20100101 Firefox/136.0";

	static boolean yfinHttpError = true;
	static boolean saveData = true;
	static SeleniumWebAgent browserAgent;
	static YFinDataHolder dataHolder;
	
	static
	{
		if(yfinHttpError)
			browserAgent = new SeleniumWebAgent();
	}

	public static void main(String args[]) throws Exception, Throwable
	{
		startCollection(); //use this code for actual collection
		//test(); //use this code to test collection
	}

	public static void test() throws Exception, Throwable
	{
		dataHolder = new YFinDataHolder();
		
		try
		{
			test("SBIN.NS");
			test("HDFCGOLD.NS");
			
			dataHolder.printHistoricalData();
			dataHolder.printMinMax();
			if(saveData)
			{
				dataHolder.saveHistoricalData(generatedHistData, histDataHeader);
				dataHolder.saveMinMaxData(generatedMinMaxData, minmaxDataHeader);
			}
		}
		finally
		{
			browserAgent.finalize();
		}
	}
	public static void test(String yahooSymbol) throws Exception
	{
		String jsonResponse;
		if(yfinHttpError) 
			jsonResponse = browserAgent.getUrlSource(getYFinUrl(yahooSymbol, null));
		else 
			jsonResponse = getStockDataResponse(yahooSymbol, stockDefaultDuration);
		
		System.out.println("Collected json response for the stock - " + yahooSymbol);
		System.out.println(jsonResponse);
		parseYFinJson(jsonResponse);
	}

	public static void startCollection() throws Exception, Throwable
	{
		List<String> records = ExcelHandler.readExcel(stockExcelFile, stockExcelSheet, stockDataDelim, true);
		
		dataHolder = new YFinDataHolder();

		try
		{
			for(String record: records)
			{
				//System.out.println(record);
				StringTokenizer tokenizer = new StringTokenizer(record, stockDataDelim);
				if(tokenizer.hasMoreTokens())
				{
					String yahooSymbol = tokenizer.nextToken();
					String jsonResponse = getStockDataResponse(yahooSymbol, stockDefaultDuration);
					System.out.println("Collected json response for the stock - " + yahooSymbol);
					parseYFinJson(jsonResponse);
				}
			}
			dataHolder.printMinMax();
			saveData();
		}
		finally
		{
			browserAgent.finalize();
		}
	}

	public static void saveData()
	{
		if(saveData)
		{
			dataHolder.saveHistoricalData(generatedHistData, histDataHeader);
			dataHolder.saveMinMaxData(generatedMinMaxData, minmaxDataHeader);
		}
	}

	public static String getYFinUrl(String yahooSymbol, String duration)
	{
		final String qString = (null == duration) ? stockUrlQueryString : "?range="+duration+"&interval=1d";
		return stockUrlBase + yahooSymbol + qString;
	}

	public static String getStockDataResponse(String yahooSymbol, String duration) throws IOException, InterruptedException
	{
		if(yfinHttpError)
		{
			return browserAgent.getUrlSource(getYFinUrl(yahooSymbol, stockDefaultDuration));
		}
		else 
			return getStockDataResponse(getYFinUrl(yahooSymbol, stockDefaultDuration));
	}

	public static String getStockDataResponse(String urlString) throws IOException, InterruptedException
	{
		int sleepTime = (int)(Math.random() * 10);//sleep time in seconds (should be between 0 & 10 seconds)
		Thread.sleep(sleepTime * 1000);
		
	    HttpClient client = HttpClient.newHttpClient();
	    HttpRequest request = HttpRequest.newBuilder()
	        .uri(URI.create(urlString))
            .header("User-Agent", chromeUserAgent)
	        .build();
	    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
	    if(response.statusCode() != 200)
	    {
	    	System.out.println(response.statusCode() + " received while calling - " + urlString);
	    	throw new IOException(response.statusCode() + " received while calling - " + urlString);
	    }
	    return response.body();
	}
	
	public static void parseYFinJson(String jsonString)
	{
		if(yfinHttpError)
		{
			int i1 = jsonString.indexOf('{');
			int i2 = jsonString.lastIndexOf('}') + 1;
			jsonString = jsonString.substring(i1, i2);
		}
		Gson g = new Gson();
		StockChartData chartOutput = g.fromJson(jsonString, StockChartData.class);
		
		com.fraza.tools.stock.StockChartData.Result result = chartOutput.chart.result.get(0);
		com.fraza.tools.stock.StockChartData.Meta meta = result.meta;
		String yahooSymbol = meta.symbol;
		
		com.fraza.tools.stock.StockChartData.Quote quote = result.indicators.quote.get(0);
		List<Long> timestamps = result.timestamp;
		
		int n = timestamps.size();
		ArrayList<String> history = new ArrayList<String>(n);
		double min1y = 99999d;
		double max1y = 0d;
		double min3mo = 99999d;
		double max3mo = 0d;
		double min1mo = 99999d;
		double max1mo = 0d;
		long time3mo = System.currentTimeMillis() - (2678400000l * 3);
		long time1mo = System.currentTimeMillis() - 2678400000l;
		for(int i=0; i<n; i++)
		{
			long timeInMillis = timestamps.get(i)*1000;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String strDate = sdf.format(new Date(timeInMillis));
			
			Double open = quote.open.get(i);
			Double high = quote.high.get(i);
			Double low = quote.low.get(i);
			Double close = quote.close.get(i);
			Long volume = quote.volume.get(i);
			if(null == open || null == high || null == low || null == close) continue;
			String record = yahooSymbol + "," + strDate + "," + open + "," + high + "," + low + "," + close + "," + volume;
			history.add(record);
			//System.out.println(record);
			
			min1y = Math.min(close, min1y);
			max1y = Math.max(close, max1y);
			if(timeInMillis > time1mo)
			{
				min1mo = Math.min(close, min1mo);
				max1mo = Math.max(close, max1mo);
			}
			if(timeInMillis > time3mo)
			{
				min3mo = Math.min(close, min3mo);
				max3mo = Math.max(close, max3mo);
			}
		}
		
		dataHolder.updateHistoricalData(yahooSymbol, history);
		String minMaxRecord = yahooSymbol + "," + min1y + "," + max1y + "," + min3mo + "," + max3mo + "," + min1mo + "," + max1mo;
		dataHolder.updateMinMax(yahooSymbol, minMaxRecord);
	}
}
