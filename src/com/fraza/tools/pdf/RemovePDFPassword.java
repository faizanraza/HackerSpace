package com.fraza.tools.pdf;

import java.io.File;

import org.apache.pdfbox.pdmodel.PDDocument;

/*
 * https://www.tutorialspoint.com/pdfbox/index.htm
 * https://www.javatpoint.com/pdfbox-tutorial
 * 
 * usage - RemovePDFPassword <file path> <pwd> 
 */
public class RemovePDFPassword 
{
	public static void main(String[] args) 
	{
		String filePath = "/Users/fraza/Downloads/EAadhaar_0635100530488620221121145421_1812202222051.pdf";
		String pwd = "FAIZ1977";
		
		if(args.length > 0) filePath = args[0];
		if(args.length > 1) pwd = args[1];
		
		removePassword(filePath, pwd);
	}

	public static void removePassword( String filePath, String pwd)
	{
		try( PDDocument pd = PDDocument.load(new File(filePath), pwd) )
		{
		     pd.setAllSecurityToBeRemoved(true);
		     pd.save(filePath+".withoutPwd.pdf");
		} 
		catch (Exception e)
		{
		     e.printStackTrace();
		}
	}
}
