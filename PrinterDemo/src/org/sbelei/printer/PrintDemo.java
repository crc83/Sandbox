package org.sbelei.printer;

import java.awt.Graphics;
import java.awt.print.*;

public class PrintDemo {

	public static void main(String[] args) throws PrinterException {
		PrinterJob job = PrinterJob.getPrinterJob();
		job.setPrintable(new Printable() {
			
			@Override
			public int print(Graphics graphics, PageFormat pageFormat, int pageIndex)
					throws PrinterException {
				//without this condition we have endless printing
				if (pageIndex > 0) {
			         return NO_SUCH_PAGE;
			    }
				
				graphics.drawString("Hello world", 10, 10);
				return PAGE_EXISTS;
			}
		});
		boolean doPrint = job.printDialog();
		if (doPrint) {
			job.print();
		}
	}

}
