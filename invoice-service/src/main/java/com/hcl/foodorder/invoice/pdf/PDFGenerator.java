package com.hcl.foodorder.invoice.pdf;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.hcl.foodorder.domain.order.Order;
import com.hcl.foodorder.domain.restaurant.MenuItem;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Component
public class PDFGenerator {

	private static final Logger LOGGER = LoggerFactory.getLogger(PDFGenerator.class);

	public void generatePDFReport(Order order) throws DocumentException, IOException {
		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream("D:/HCL/invoiceReport" + order.getOrderNumber() + ".pdf"));
		document.open();

		// Invoice Header
		Paragraph paragraph = new Paragraph("Invoice Order : " + order.getOrderNumber());
		paragraph.setAlignment(Element.ALIGN_CENTER);
		document.add(paragraph);

		// Customer Details
		paragraph = new Paragraph("Customer Details : ");
		paragraph.setAlignment(Element.ALIGN_LEFT);
		document.add(paragraph);

		paragraph = new Paragraph("----------------------------");
		paragraph.setAlignment(Element.ALIGN_CENTER);
		document.add(paragraph);

		// Restaurant Details
		paragraph = new Paragraph("Restaurant Details : ");
		paragraph.setAlignment(Element.ALIGN_LEFT);
		document.add(paragraph);

		paragraph = new Paragraph("----------------------------");
		paragraph.setAlignment(Element.ALIGN_CENTER);
		document.add(paragraph);

		paragraph = new Paragraph("Ordered Items");
		paragraph.setAlignment(Element.ALIGN_CENTER);
		document.add(paragraph);

		// Order List
		PdfPTable table = new PdfPTable(4);
		// Table Header
		Stream.of("Item Name", "Price", "Quantity", "Total Price").forEach(columnTitle -> {
			PdfPCell header = new PdfPCell();
			header.setBackgroundColor(BaseColor.LIGHT_GRAY);
			header.setBorderWidth(1.5f);
			header.setPhrase(new Phrase(columnTitle));
			table.addCell(header);
		});

		for (MenuItem item : order.getItemList()) {
			// Table Body
			table.addCell(item.getName());
			table.addCell(String.valueOf(item.getPrice()));
			table.addCell(String.valueOf(item.getQuantity()));
			table.addCell(String.valueOf(item.getQuantity()*item.getPrice()));
		}
		document.add(table);
		document.close();
	}
	/*
	 * public static void main(String[] args) throws DocumentException,
	 * URISyntaxException, IOException {
	 * 
	 * PDFGenerator pdfGenerator = new PDFGenerator(); Order order = new Order();
	 * order.setId(1234567890L); order.setOrderNumber("ABC1234567890");
	 * order.setStatus(OrderStatus.CREATED); order.setTaxPercentage(5.0);
	 * order.setTotal(10000.0); order.setTotalTaxAmount(50.0);
	 * 
	 * pdfGenerator.generatePDFReport(order);
	 * 
	 * LOGGER.info("PDF Generation..!");
	 * 
	 * }
	 */
}
