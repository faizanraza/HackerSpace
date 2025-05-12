package com.fraza.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumWebAgent
{
	static boolean debug = false;
    public static void main(String[] args) throws InterruptedException
    {
    	debug = true;
    	new SeleniumWebAgent().getUrlSource("https://query2.finance.yahoo.com/v8/finance/chart/SBIN.NS");//https://www.geeksforgeeks.org
    }
    
    WebDriver driver;
    public SeleniumWebAgent()
    {
    	//Set the system property for ChromeDriver (path to chromedriver executable)
        System.setProperty("webdriver.chrome.driver", "/Users/fraza/Downloads/chromedriver-mac-arm64/chromedriver");
        
        //Create an instance of ChromeDriver (launch the Chrome browser)
        driver = new ChromeDriver();
    }

    public String getUrlSource(String url) throws InterruptedException
    {
        int sleepTime = (int)(Math.random() * 6);//sleep time in seconds (between 0 & 6 seconds)
		Thread.sleep(sleepTime * 1000);

		driver.get(url);

        String pageSrc = driver.getPageSource();
        if(debug)
        {
            String pageTitle = driver.getTitle();
            System.out.println("Page Title: " + pageTitle);
        	System.out.println(pageSrc);
        }
		
		return pageSrc;
    }
    
    @Override
    public void finalize() throws Throwable 
    {
    	driver.quit();
    }
}
