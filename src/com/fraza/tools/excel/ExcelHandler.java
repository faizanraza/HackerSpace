package com.fraza.tools.excel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHandler
{
	public static String holdingsCSVFile = "/Users/fraza/Downloads/ZerodhaHoldings.csv";
	public static String holdingsExcelFile = "/Users/fraza/Downloads/ZerodhaHoldings.xlsx";
	public static String sheetName = "10-Jun-24";

	public static void main(String args[]) throws Exception
	{
		String filepath = holdingsCSVFile;
		
		final List<String> records;
		if(filepath.contains(".csv"))
			records = readCSV(filepath, null);
		else
			records = readExcel(filepath, sheetName, null, null);

		for(String record: records)
		{
			System.out.println(record);
		}
	}

	public static List<String> readCSV(String filePath, Boolean skipHeader) throws Exception
	{
		if( null == filePath) filePath = holdingsCSVFile;
		if( null == skipHeader) skipHeader = false;
		final List<String> records = new ArrayList<String>();
		try (final FileInputStream fileInputStream = new FileInputStream(filePath);
				final Reader reader = new InputStreamReader(fileInputStream);
		        final BufferedReader br = new BufferedReader(reader))
		{
			String record = br.readLine();
			if(skipHeader) record = br.readLine();
			while(null != record)
			{
				records.add(record.toString());
				record = br.readLine();
			}
		}
		return records;
	}
	
	public static List<String> readExcel(String filePath, String sheetName, String delimiter, Boolean skipHeader) throws IOException
	{
		if( null == filePath) filePath = holdingsExcelFile;
		if( null == delimiter) delimiter = ",";
		if( null == skipHeader) skipHeader = false;
		final List<String> records = new ArrayList<String>();
		try (final FileInputStream fileInputStream = new FileInputStream(new File(filePath));
				final XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream))
		{
			final XSSFSheet sheet;
			if (null != sheetName)
				sheet = workbook.getSheet(sheetName);
			else
				sheet = workbook.getSheetAt(0);

			final Iterator<Row> rowIterator = sheet.iterator();
			if(skipHeader && rowIterator.hasNext()) rowIterator.next();
			while (rowIterator.hasNext())
			{
				final Row row = rowIterator.next();
				final Iterator<Cell> cellIterator = row.cellIterator();
				final StringBuilder record = new StringBuilder();
				while (cellIterator.hasNext())
				{
					final Cell cell = cellIterator.next();
					record.append(cell.toString());
					if(cellIterator.hasNext()) record.append(delimiter);
				}
				records.add(record.toString());
			}
		}
		return records;
	}
}
