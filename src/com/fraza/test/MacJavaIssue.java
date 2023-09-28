package com.fraza.test;

public class MacJavaIssue
{
	public static void main(String[] args)
	{
		try
		{
			// Update the location where fdb-java.jar is unzipped
			System.load("/Users/fraza/Downloads/fdb-java-6.2.10/lib/osx/x86_64/libfdb_java.jnilib");
		}
		catch (Throwable e)
		{
			e.printStackTrace();
		}
	}
}
