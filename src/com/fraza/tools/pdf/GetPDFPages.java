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
public class GetPDFPages 
{
	public static void main(String[] args) 
	{
		String filePath = "/Users/fraza/Downloads/Form_14ANEW_MIZAN RAZA.pdf";
		if(args.length > 0) filePath = args[0];
		
		String pageList = "0,3";
		if(args.length > 1) pageList = args[1];
		
		getPages(filePath, pageList);
	}

	public static void getPages( String filePath, String pageList)
	{
		String[] pages = pageList.split(",");
		try( PDDocument pd = PDDocument.load(new File(filePath)); 
				PDDocument newDoc = new PDDocument(); )
		{
		     pd.setAllSecurityToBeRemoved(true);
		     pd.save(filePath+".subset.pdf");
		     
		     for(String page: pages)
		     {
		    	 int index = Integer.parseInt(page);
		    	 PDPage pdPage = pd.getPage(index);
		    	 
		    	 newDoc.addPage(pdPage);
		     }
		     
		     newDoc.save( filePath + ".subset.pdf" );
		} 
		catch (Exception e)
		{
		     e.printStackTrace();
		}
	}
}
