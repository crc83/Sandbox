package org.sbelei.printer;

import gui.ava.html.image.generator.HtmlImageGenerator;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.print.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.print.attribute.PrintRequestAttributeSet;

/**
 * This prints using HTML2Image library
 * @author sbelei
 *
 */
public class PrintDemo {

	public static void main(String[] args) throws PrinterException {
		new PrintDemo().doAllJob();
	}

	private void doAllJob() throws PrinterException {
		PrinterJob job = PrinterJob.getPrinterJob();
		job.setPrintable(new Printable() {
			
			@Override
			public int print(Graphics graphics, PageFormat pageFormat, int pageIndex)
					throws PrinterException {
				//without this condition we have endless printing
				if (pageIndex > 0) {
			         return NO_SUCH_PAGE;
			    }
				HtmlImageGenerator imageGenerator = new HtmlImageGenerator();
				String html="";
				try {
					html = readFileAsString("report.html");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				imageGenerator.loadHtml(html);
				Dimension dimension = new Dimension();
				dimension.setSize(pageFormat.getImageableWidth(), pageFormat.getImageableHeight());
				imageGenerator.setSize(dimension );
				
				graphics.drawImage(imageGenerator.getBufferedImage(), 0,0,null);
				
				return PAGE_EXISTS;
			}
		});
		boolean doPrint = job.printDialog();
		if (doPrint) {
			job.print();
		}
	}
	
	/** 
	 * @param filePath      name of file to open. The file can reside
	 *                      anywhere in the classpath
	 */
	private String readFileAsString(String filePath) throws java.io.IOException {
	    StringBuffer fileData = new StringBuffer(1000);
	    BufferedReader reader = new BufferedReader(new InputStreamReader(this
	        .getClass().getClassLoader().getResourceAsStream(filePath)));
	    char[] buf = new char[1024];
	    int numRead = 0;
	    while ((numRead = reader.read(buf)) != -1) {
	        String readData = String.valueOf(buf, 0, numRead);
	        fileData.append(readData);
	        buf = new char[1024];
	    }
	    reader.close();
	    return fileData.toString();
	}

}
