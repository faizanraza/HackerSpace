package com.fraza.tools.stock;

import java.util.List;

//This object is used to parse JSON data from YFinance chart API
public class StockChartData
{
	public Chart chart;
	
	public class Chart
	{
		public List<Result> result;
		public String error;
	}
	
	public class Result
	{
		public Meta meta;
		public List<Long> timestamp;
		public Indicators indicators;
	}
	
	public class Meta
	{
		public String symbol;
		public Double regularMarketPrice;
		public Double fiftyTwoWeekHigh;
		public Double fiftyTwoWeekLow;
		public Long regularMarketVolume;
	}
	
	public class Indicators
	{
		public List<Quote> quote;
	}
	
	public class Quote
	{
		public List<Double> high;
		public List<Double> low;
		public List<Double> open;
		public List<Double> close;
		public List<Long> volume;
	}
}
