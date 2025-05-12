package com.fraza.tools.pdf;

import java.io.File;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

/*
 * https://www.tutorialspoint.com/pdfbox/index.htm
 * https://www.javatpoint.com/pdfbox-tutorial
 * 
 * usage - GetPDFPages <file path> <comma separated page (zero indexed)> 
 */
public class CombinePDFPages 
{
	public static void main(String[] args) 
	{
		String file1Path = "/Users/fraza/Downloads/FaizanLkoBlr22Oct23.pdf";
		String file2Path = "/Users/fraza/Downloads/LkoBlr22Oct23.pdf";

		if(args.length > 0) file1Path = args[0];
		if(args.length > 1) file2Path = args[1];
		
		combinePages(file1Path, file2Path);
	}

	public static void combinePages( String file1Path, String file2Path)
	{
		try( PDDocument pd1 = PDDocument.load(new File(file1Path)); 
				PDDocument pd2 = PDDocument.load(new File(file2Path)); 
				PDDocument newDoc = new PDDocument();)
		{
		     pd1.setAllSecurityToBeRemoved(true);
		     pd2.setAllSecurityToBeRemoved(true);
		     
		     for(PDPage page: pd1.getPages())
		     {
		    	 newDoc.addPage(page);
		     }
		     for(PDPage page: pd2.getPages())
		     {
		    	 newDoc.addPage(page);
		     }
		     
		     newDoc.save( file1Path + ".combined.pdf" );
		} 
		catch (Exception e)
		{
		     e.printStackTrace();
		}
	}
}
