package com.fraza.tools.pdf;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.TextPosition;

/*
 * https://www.tutorialspoint.com/pdfbox/index.htm
 * https://www.javatpoint.com/pdfbox-tutorial
 * 
 * usage - GetPDFPages <file path> <comma separated page (zero indexed)> 
 */
public class FindTextInPDF 
{
	public static void main(String[] args) 
	{
		try 
		{
			File file = new File("/Users/fraza/Downloads/438Room1Kasavanahalli.pdf");
			PDDocument doc = PDDocument.load(file);
			System.out.println("Num Pages = " + doc.getNumberOfPages());
			for (PDPage pdpage : doc.getPages()) 
			{
				COSDictionary pageDict = pdpage.getCOSObject();
				/*for (COSName cosname: pageDict.keySet())
				{
					//System.out.print(cosname.getName() + ",");
				}*/
				System.out.println( pdpage.getMediaBox().toString());
				System.out.println("Page ends");
		    }
			doc.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void main2(String[] args) 
	{
		try 
		{
			File file = new File("/Users/fraza/Downloads/438Room1Kasavanahalli.pdf");
			PDDocument doc = PDDocument.load(file);
			PDFTextStripper pdfTextStripper = new PDFTextStripper();
			pdfTextStripper.setSortByPosition(true);
			pdfTextStripper.setStartPage(1);
			pdfTextStripper.setEndPage(6);
			String text = pdfTextStripper.getText(doc);
			System.out.println("text started");
			System.out.println(text);
			System.out.println("text ended");
			doc.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	public static void main1(String[] args) throws Exception
	{
		String filePath = "/Users/fraza/Downloads/438Room1Kasavanahalli.pdf";
		if(args.length > 0) filePath = args[0];
		PDDocument pd = PDDocument.load(new File(filePath));
		
		String searchTerm = "ELECTORAL";
		if(args.length > 1) searchTerm = args[1];
		
		//startpage =1
		String endpage = "1";
		if(args.length > 2) endpage = args[2];
		
		List<TextPositionSequence> seq = new FindTextInPDF().findSubwords(pd, Integer.parseInt(endpage), searchTerm);
		for(TextPositionSequence s: seq)
		{
			System.out.println( s.start + "-" + s.end + " >> " + s.toString());
		}
	}

	List<TextPositionSequence> findSubwords(PDDocument document, int page, String searchTerm) throws IOException
	{
	    final List<TextPositionSequence> hits = new ArrayList<TextPositionSequence>();
	    PDFTextStripper stripper = new PDFTextStripper()
	    {
	        @Override
	        protected void writeString(String text, List<TextPosition> textPositions) throws IOException
	        {
	            TextPositionSequence word = new TextPositionSequence(textPositions);
	            String string = word.toString();

	            int fromIndex = 0;
	            int index;
	            while ((index = string.indexOf(searchTerm, fromIndex)) > -1)
	            {
	                hits.add(word.subSequence(index, index + searchTerm.length()));
	                fromIndex = index + 1;
	            }
	            super.writeString(text, textPositions);
	        }
	    };
	    
	    stripper.setSortByPosition(true);
	    stripper.setStartPage(1);
	    stripper.setEndPage(page);
	    stripper.getText(document);
	    return hits;
	}
	
	public class TextPositionSequence implements CharSequence
	{
	    public TextPositionSequence(List<TextPosition> textPositions)
	    {
	        this(textPositions, 0, textPositions.size());
	    }

	    public TextPositionSequence(List<TextPosition> textPositions, int start, int end)
	    {
	        this.textPositions = textPositions;
	        this.start = start;
	        this.end = end;
	    }

	    @Override
	    public int length()
	    {
	        return end - start;
	    }

	    @Override
	    public char charAt(int index)
	    {
	        TextPosition textPosition = textPositionAt(index);
	        String text = textPosition.getUnicode();
	        return text.charAt(0);
	    }

	    @Override
	    public TextPositionSequence subSequence(int start, int end)
	    {
	        return new TextPositionSequence(textPositions, this.start + start, this.start + end);
	    }

	    @Override
	    public String toString()
	    {
	        StringBuilder builder = new StringBuilder(length());
	        for (int i = 0; i < length(); i++)
	        {
	            builder.append(charAt(i));
	        }
	        return builder.toString();
	    }

	    public TextPosition textPositionAt(int index)
	    {
	        return textPositions.get(start + index);
	    }

	    public float getX()
	    {
	        return textPositions.get(start).getXDirAdj();
	    }

	    public float getY()
	    {
	        return textPositions.get(start).getYDirAdj();
	    }

	    public float getWidth()
	    {
	        if (end == start)
	            return 0;
	        TextPosition first = textPositions.get(start);
	        TextPosition last = textPositions.get(end - 1);
	        return last.getWidthDirAdj() + last.getXDirAdj() - first.getXDirAdj();
	    }

	    final List<TextPosition> textPositions;
	    final int start, end;
	}

}
