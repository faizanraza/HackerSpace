package com.fraza.tools.pdf;

import java.io.File;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy;

/*
 * https://www.tutorialspoint.com/pdfbox/index.htm
 * https://www.javatpoint.com/pdfbox-tutorial
 * 
 * usage - RemovePDFPassword <file path> <pwd> 
 */
public class UpdatePDFPassword 
{
	public static void main(String[] args) 
	{
		String filePath = "/Users/fraza/Downloads/AAKPF9380J_2024-25.pdf";
		String ownerpwd = "AAKPF9380J11885783"; //owner_pwd
		String userpwd = "userpwd"; // user_pwd
		
		if(args.length > 0) filePath = args[0];
		if(args.length > 1) ownerpwd = args[1];
		if(args.length > 2)
		{
			userpwd = args[2];
		}
		
		removePassword(filePath, ownerpwd);
	}

	public static void removePassword( String filePath, String pwd)
	{
		try( PDDocument pd = PDDocument.load(new File(filePath), pwd) )
		{
		     pd.setAllSecurityToBeRemoved(true);
		     pd.save(filePath+".NoPwd.pdf");
		} 
		catch (Exception e)
		{
		     e.printStackTrace();
		}
	}

	public static void addPassword( String filePath, String ownerpwd, String userpwd)
	{
		try( PDDocument pd = PDDocument.load(new File(filePath)) )
		{
		 	 AccessPermission accessPermission = new AccessPermission();

		 	 // Set to true if you want to allow printing
			 accessPermission.setCanPrint(false); 

			 StandardProtectionPolicy protectionPolicy = new StandardProtectionPolicy(ownerpwd, userpwd, accessPermission);
			
			 pd.protect(protectionPolicy);
		     pd.save(filePath+".Protected.pdf");
		} 
		catch (Exception e)
		{
		     e.printStackTrace();
		}
	}
}
