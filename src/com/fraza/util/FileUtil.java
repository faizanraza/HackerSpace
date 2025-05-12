package com.fraza.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;

public class FileUtil
{
	public static void main(String[] args)
	{
		try
		{
//			createFile("/Users/fraza/Documents/TBD.txt", "File created using Files.createFile(filePath)");
//			createFile("/Users/fraza/Documents/TBD2.txt", new String[]{"File created using PrintWriter", "Line 2"});
			createFile("/Users/fraza/Documents", "TBD3.txt", "File created using File & BufferedWriter");
			
			System.out.println("File successfully created/updated.");
		}
		catch(IOException ioe)
		{
			System.out.println(ioe.getMessage());
			ioe.printStackTrace();
		}
	}
	
	//creates a new file and write the content, throws FileAlreadyExists exception
	public static void createFile(String strFilePath, String content) throws IOException
	{
		Path filePath = Path.of(strFilePath);
        Files.createFile(filePath);

        Files.writeString(filePath, content, StandardOpenOption.WRITE);
	}

	//creates a new file or open existing file and write the contents
	public static void createFile(String strFilePath, String... contents) throws IOException
	{
		PrintWriter writer = new PrintWriter(strFilePath, "UTF-8");
		for(String content: contents)
			writer.println(content);
		writer.close();
	}

	//creates a new file or open existing file and write the contents
	public static void createFile(String baseDirLocation, String fileName, String content) throws IOException
	{
		File baseDir = new File(baseDirLocation);
		File myFile = new File(baseDir, fileName);

		try(BufferedWriter output = new BufferedWriter(new FileWriter(myFile)))
		{			
			output.write(content);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		} 
	}

	public static void inputStreamToString(InputStream inputStream) throws IOException
	{
		//1. Using Apache IOUtils
		String result = IOUtils.toString(inputStream, StandardCharsets.UTF_8);

		//2. Using Scanner
		Scanner s = new Scanner(inputStream).useDelimiter("\\A");
		result = s.hasNext() ? s.next() : "";

		//3. Using StreamAPI. Warning: This solution converts different line breaks (like \r\n) to \n
		result = new BufferedReader(new InputStreamReader(inputStream)).lines().collect(Collectors.joining("\n"));

		//4. Using parallel StreamAPI. Warning: This solution converts different line breaks (like \r\n) to \n
		result = new BufferedReader(new InputStreamReader(inputStream)).lines().parallel()
				.collect(Collectors.joining("\n"));

		//5. Using InputStreamReader and StringBuilder
		int bufferSize = 1024;
		char[] buffer = new char[bufferSize];
		StringBuilder out = new StringBuilder();
		Reader in = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
		for (int numRead; (numRead = in.read(buffer, 0, buffer.length)) > 0;)
		{
			out.append(buffer, 0, numRead);
		}
		result = out.toString();

		//6. Using StringWriter and IOUtils.copy
		StringWriter writer = new StringWriter();
		IOUtils.copy(inputStream, writer, "UTF-8");
		result = writer.toString();

		//7. Using ByteArrayOutputStream and inputStream.read
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] bArr = new byte[1024];
		for (int length; (length = inputStream.read(bArr)) != -1;)
		{
			baos.write(bArr, 0, length);
		}
		result = baos.toString("UTF-8");// StandardCharsets.UTF_8.name() > JDK 7

		//8. BufferedReader (JDK). Warning: This solution converts different line breaks (like \n\r) to line separator system property (for example, in Windows to "\r\n")
		String newLine = System.getProperty("line.separator");
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		StringBuilder sb = new StringBuilder();
		for (String line; (line = reader.readLine()) != null;)
		{
			if (sb.length() > 0)
			{
				sb.append(newLine);
			}
			sb.append(line);
		}
		result = sb.toString();

		//9. Using BufferedInputStream and ByteArrayOutputStream
		BufferedInputStream bis = new BufferedInputStream(inputStream);
		ByteArrayOutputStream buf = new ByteArrayOutputStream();
		for (int ch = bis.read(); ch != -1; ch = bis.read())
		{
			buf.write((byte) ch);
		}
		result = buf.toString("UTF-8"); //StandardCharsets.UTF_8.name() > JDK 7

		//10. Using inputStream.read() and StringBuilder (JDK). Warning: This solution has problems with Unicode, for example with Russian text (works correctly only with non-Unicode text)
		sb = new StringBuilder();
		for (int ch; (ch = inputStream.read()) != -1;)
		{
			sb.append((char) ch);
		}
		result = sb.toString();
	}
}
