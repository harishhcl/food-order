package com.hcl.foodorder.invoice.pdf;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Component
public class PDFGenerator {
	public static void main(String[] args) throws DocumentException, URISyntaxException, IOException {
		
		PDFGenerator pdfGenerator =new PDFGenerator();
		
		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream("D:/HCL/invoiceReport.pdf"));
		document.open();

		PdfPTable table = new PdfPTable(3);
		pdfGenerator.addTableHeader(table);
		pdfGenerator.addRows(table);
		pdfGenerator.addCustomRows(table);

		document.add(table);

		document.close();
		
		System.out.println("PDF Generation..!");
		
	}

	private void addTableHeader(PdfPTable table) {
		Stream.of("column header 1", "column header 2", "column header 3").forEach(columnTitle -> {
			PdfPCell header = new PdfPCell();
			header.setBackgroundColor(BaseColor.LIGHT_GRAY);
			header.setBorderWidth(2);
			header.setPhrase(new Phrase(columnTitle));
			table.addCell(header);
		});
	}

	private void addRows(PdfPTable table) {
		table.addCell("row 1, col 1");
		table.addCell("row 1, col 2");
		table.addCell("row 1, col 3");
	}

	private void addCustomRows(PdfPTable table) throws URISyntaxException, BadElementException, IOException {

		PdfPCell horizontalAlignCell = new PdfPCell(new Phrase("row 2, col 2"));
		horizontalAlignCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(horizontalAlignCell);

		PdfPCell verticalAlignCell = new PdfPCell(new Phrase("row 2, col 3"));
		verticalAlignCell.setVerticalAlignment(Element.ALIGN_BOTTOM);
		table.addCell(verticalAlignCell);
		
	}
}
