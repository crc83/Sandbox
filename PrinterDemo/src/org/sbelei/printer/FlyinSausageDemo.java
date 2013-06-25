package org.sbelei.printer;

import org.xhtmlrenderer.simple.*;

import java.awt.print.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Flying sausage doesn't work as expected
 * @author sbelei
 *
 */
public class FlyinSausageDemo {

	public static void main(String[] args ) throws Exception{
		new FlyinSausageDemo().run();
	}

	private void run() throws Exception {
		// . . . .
		// xhtml_panel created earlier
		XHTMLPanel panel =new XHTMLPanel();
		panel.setVisible(false);
		try {
			panel.setDocument(new File("E:/PROJECTS/Sandbox/PrinterDemo/resources/report.xhtml"));
		} catch (Exception e){
			e.printStackTrace();
		}
		System.out.println("Printing...");
		PrinterJob printJob = PrinterJob.getPrinterJob();
		printJob.setPrintable(new XHTMLPrintable(panel));
		if(printJob.printDialog()) {
		  printJob.print();
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
