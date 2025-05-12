package com.fraza.tools.pdf;

import java.awt.image.BufferedImage;
import java.io.File;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;

public class PdfToJpg 
{
	public static void main(String[] args) 
	{
		String filePath = "/Users/fraza/Documents/personal/TBD/AlizaBirthCert.pdf";
		if(args.length > 0) filePath = args[0];
		
		String pageList = "0";
		if(args.length > 1) pageList = args[1];
		
		saveAsImage(filePath, pageList);
	}

	public static void saveAsImage( String filePath, String pageList)
	{
		String[] pages = pageList.split(",");
		try( PDDocument pd = PDDocument.load(new File(filePath)))
		{
			 PDFRenderer pdfRenderer = new PDFRenderer(pd);
		     for(String page: pages)
		     {
		    	 int index = Integer.parseInt(page);		    	 
		    	 BufferedImage bim = pdfRenderer.renderImageWithDPI(index, 90, ImageType.RGB);

		    	 // suffix in filename will be used as the file format
		    	 ImageIOUtil.writeImage(bim, filePath + "." + (index+1) + ".png", 90);
		     }
		} 
		catch (Exception e)
		{
		     e.printStackTrace();
		}
	}
}
