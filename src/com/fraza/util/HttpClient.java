package com.fraza.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;

public class HttpClient 
{

	static void connect() throws IOException
	{
		URL url = new URL("https://api.nuget.org/v3/index.json");
        URLConnection con = url.openConnection();
        final Reader reader = new InputStreamReader(con.getInputStream());
        final BufferedReader br = new BufferedReader(reader);        
        String line = "";
        while ((line = br.readLine()) != null) 
        {
            System.out.println(line);
        }        
        br.close();
	}

	public static void main(String[] args) throws Exception
	{
		connect();
	}
}
