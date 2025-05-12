package com.fraza.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MyHttpClient 
{

	static void connect(String urlString) throws IOException
	{
		URL url = new URL(urlString);
        URLConnection con = url.openConnection();
        final Reader reader = new InputStreamReader(con.getInputStream());
        final BufferedReader br = new BufferedReader(reader);        
        String line = "";
        while ((line = br.readLine()) != null) 
        {
            System.out.println(line);
        }        
        br.close();reader.close();
	}

	static void connect2(String urlString) throws IOException, InterruptedException
	{
	    HttpClient client = HttpClient.newHttpClient();
	    HttpRequest request = HttpRequest.newBuilder()
	        .uri(URI.create(urlString))
            .header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:136.0) Gecko/20100101 Firefox/136.0")
	        .build();
	    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
	    
	    System.out.println(response.body());
	}
	
	//Other ways include
	//Apache HttpClient
	//OkHttp
	//Retrofit
	
	public static void main(String[] args) throws Exception
	{
		String urlString = "https://query1.finance.yahoo.com/v8/finance/chart/SBIN.NS?range=1d&interval=1d";
		try
		{
			connect2(urlString);
		}
		catch(Exception e)
		{
			System.out.println("Error executing HTTP requests !!");
		}
	}
}
