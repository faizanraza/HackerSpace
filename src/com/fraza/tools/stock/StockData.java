package com.fraza.tools.stock;

import java.util.ArrayList;

//This is an old code to capture stock data
public class StockData
{
	public String symbol;
	public String kiteSymbol;
	public int holdings;
	public float averageCost;
	public float regularMarketPrice;
	public float regularMarketDayHigh;
	public float regularMarketDayLow;
	public float fiftyTwoWeekHigh;
	public float fiftyTwoWeekLow;
	public int regularMarketVolume;
	public ArrayList<Float> close = new ArrayList<Float>();
	public ArrayList<Float> volume = new ArrayList<Float>();
	
	public String rawData;
	
	public StockData(String symbol, int holdings, float averageCost)
	{
		this.symbol = symbol;
		this.holdings = holdings;
		this.averageCost = averageCost;
	}
	
	public void print()
	{
		System.out.println("symbol="+symbol);
		System.out.println("holdings="+holdings);
		System.out.println("averageCost="+averageCost);
		System.out.println("regularMarketPrice="+regularMarketPrice);
		System.out.println("regularMarketDayHigh="+regularMarketDayHigh);
		System.out.println("regularMarketDayLow="+regularMarketDayLow);
		System.out.println("fiftyTwoWeekHigh="+fiftyTwoWeekHigh);
		System.out.println("fiftyTwoWeekLow="+fiftyTwoWeekLow);
		System.out.println("regularMarketVolume="+regularMarketVolume);
//		System.out.println(rawData);
	}
	
	public static StockData create(String delimitedData, String delimiter) throws Exception
	{
		final String[] delimitedDataArray = delimitedData.split(delimiter);
		if(delimitedDataArray.length < 3) throw new Exception("Symbol, holdings, averageCost are needed to create StockData");
		return new StockData(delimitedDataArray[0], Integer.parseInt(delimitedDataArray[1]), Float.parseFloat(delimitedDataArray[2]));
	}

	public static StockData update(StockData stockData, String yFinData) throws Exception
	{
		if(null == stockData || null == yFinData) throw new Exception("Cannot parse: stockData or yFinData is null.");
		
		stockData.regularMarketPrice = Float.parseFloat(parse(yFinData, "regularMarketPrice"));
		stockData.fiftyTwoWeekHigh = Float.parseFloat(parse(yFinData, "fiftyTwoWeekHigh"));
		stockData.fiftyTwoWeekLow = Float.parseFloat(parse(yFinData, "fiftyTwoWeekLow"));
		stockData.regularMarketDayHigh = Float.parseFloat(parse(yFinData, "regularMarketDayHigh"));
		stockData.regularMarketDayLow = Float.parseFloat(parse(yFinData, "regularMarketDayLow"));
		stockData.regularMarketVolume = Integer.parseInt(parse(yFinData, "regularMarketVolume"));
			
		return stockData;
	}
	
	private static String parse(String yFinData, String token)
	{
		int i1 = yFinData.indexOf(token);
		if (i1 == -1) return null;
		int i2 = yFinData.indexOf(":", i1);
		if (i2 == -1) return null;
		int i3 = yFinData.indexOf(",", i2);
		if (i3 == -1) return null;
		
		return yFinData.substring(i2+1, i3);
	}
	
	public static void main(String[] args) throws Exception
	{
		StockData stockData = create("APOLLOTYRE.NS", sampleRawData); 
		stockData.print();
	}
	
	public static String sampleRawData = "{'chart':{'result':[{'meta':{'currency':'INR','symbol':'APOLLOTYRE.NS','exchangeName':'NSI','fullExchangeName':'NSE','instrumentType':'EQUITY','firstTradeDate':1009856700,'regularMarketTime':1723456799,'hasPrePostMarketData':false,'gmtoffset':19800,'timezone':'IST','exchangeTimezoneName':'Asia/Kolkata','regularMarketPrice':493.5,'fiftyTwoWeekHigh':497.4,'fiftyTwoWeekLow':487.2,'regularMarketDayHigh':497.4,'regularMarketDayLow':487.2,'regularMarketVolume':1950428,'longName':'Apollo Tyres Limited','shortName':'APOLLO TYRES LTD','chartPreviousClose':518.8,'priceHint':2,'currentTradingPeriod':{'pre':{'timezone':'IST','end':1723434300,'start':1723434300,'gmtoffset':19800},'regular':{'timezone':'IST','end':1723456800,'start':1723434300,'gmtoffset':19800},'post':{'timezone':'IST','end':1723456800,'start':1723456800,'gmtoffset':19800}},'dataGranularity':'1d','range':'1mo','validRanges':['1d','5d','1mo','3mo','6mo','1y','2y','5y','10y','ytd','max']},'timestamp':[1720755900,1721015100,1721101500,1721274300,1721360700,1721619900,1721706300,1721792700,1721879100,1721965500,1722224700,1722311100,1722397500,1722483900,1722570300,1722829500,1722915900,1723002300,1723088700,1723175100,1723456799],'indicators':{'quote':[{'close':[518.7999877929688,539.75,550.4500122070312,549.9500122070312,525.5999755859375,525.4000244140625,518.5999755859375,539.25,537.0,550.4000244140625,551.75,559.6500244140625,555.7000122070312,551.5999755859375,536.6500244140625,523.7000122070312,515.3499755859375,520.2000122070312,511.5,491.8500061035156,493.5],'high':[527.6500244140625,547.9000244140625,553.9000244140625,555.1500244140625,538.0,528.75,526.2000122070312,541.0,541.5,558.5,564.5999755859375,568.0499877929688,562.3499755859375,560.0,551.9000244140625,536.5499877929688,532.5,526.9500122070312,516.2000122070312,510.0,497.3999938964844],'volume':[1113874,9379442,5548382,5415470,13115529,1510500,2977480,2424545,1848936,5476585,2850913,3711263,1230173,1683013,2286266,1741274,1205402,1817252,6058675,4084029,1950428],'low':[518.0,522.5,540.0,544.9000244140625,501.54998779296875,519.6500244140625,500.5,516.3499755859375,531.25,532.5,546.0,543.6500244140625,555.0,545.5499877929688,535.5,519.0,512.7999877929688,515.25,505.0,489.70001220703125,487.20001220703125],'open':[527.0499877929688,525.0,542.7000122070312,550.4500122070312,538.0,524.0,525.4000244140625,518.5499877929688,535.0,544.2999877929688,557.0,551.0,561.3499755859375,556.4500122070312,544.9500122070312,527.9000244140625,523.9500122070312,520.25,509.0,510.0,491.8500061035156]}],'adjclose':[{'adjclose':[518.7999877929688,539.75,550.4500122070312,549.9500122070312,525.5999755859375,525.4000244140625,518.5999755859375,539.25,537.0,550.4000244140625,551.75,559.6500244140625,555.7000122070312,551.5999755859375,536.6500244140625,523.7000122070312,515.3499755859375,520.2000122070312,511.5,491.8500061035156,493.5]}]}}],'error':null}}";
}
