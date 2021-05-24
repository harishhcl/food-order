package com.hcl.foodorder.invoice.pdf;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hcl.foodorder.domain.order.Order;
import com.hcl.foodorder.domain.order.OrderStatus;
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

@Service
public class PDFGenerator {

	private static final Logger LOGGER = LoggerFactory.getLogger(PDFGenerator.class);

	public void generatePDFReport(Order order) throws DocumentException, IOException {
		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream("D:/HCL/invoiceReport_" + order.getOrderNumber() + ".pdf"));
		document.open();

		// Invoice Header
		Paragraph paragraph = new Paragraph("Invoice Order : " + order.getOrderNumber());
		paragraph.setAlignment(Element.ALIGN_CENTER);
		document.add(paragraph);

		// Customer Details
		paragraph = new Paragraph("Customer Details : " + order.getCustomerId());
		paragraph.setAlignment(Element.ALIGN_LEFT);
		document.add(paragraph);

		// Restaurant Details
		paragraph = new Paragraph("Restaurant Details : " + order.getRestaurantId());
		paragraph.setAlignment(Element.ALIGN_LEFT);
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
			table.addCell(item.getName() + " - " + item.getDescription());
			table.addCell(String.valueOf(item.getPrice()));
			table.addCell(String.valueOf(item.getQuantity()));
			table.addCell(String.valueOf(item.getQuantity() * item.getPrice()));
		}
		document.add(table);
		Double total = order.getItemList().stream().mapToDouble(item -> item.getQuantity() * item.getPrice()).sum();

		paragraph = new Paragraph("Total Cost : " + total);
		paragraph.setAlignment(Element.ALIGN_RIGHT);
		document.add(paragraph);

		double totalTax = (total / 100) * order.getTaxPercentage();
		paragraph = new Paragraph("Total Tax : (" + order.getTaxPercentage() + " % ) : " + totalTax);
		paragraph.setAlignment(Element.ALIGN_RIGHT);
		document.add(paragraph);

		paragraph = new Paragraph("Total Bill : " + (total + totalTax));
		paragraph.setAlignment(Element.ALIGN_RIGHT);
		document.add(paragraph);

		document.close();
	}
/*
	public static void main(String[] args) throws DocumentException, URISyntaxException, IOException {

		PDFGenerator pdfGenerator = new PDFGenerator();
		Order order = new Order();
		Set<MenuItem> items = new HashSet<>();

		MenuItem item1 = new MenuItem();
		item1.setName("Biryani");
		item1.setDescription("Veg Biryani");
		item1.setId(1L);
		item1.setRestaurantId(1234567890L);
		item1.setPrice(100.00);
		item1.setQuantity(1);

		MenuItem item2 = new MenuItem();
		item2.setName("Biryani");
		item2.setDescription("Non Veg Biryani");
		item2.setId(2L);
		item2.setRestaurantId(1234567890L);
		item2.setPrice(200.00);
		item2.setQuantity(1);

		items.add(item1);
		items.add(item2);

		order.setId(1234567890L);
		order.setOrderNumber(1234567890L);
		order.setStatus(OrderStatus.CREATED);
		order.setTaxPercentage(5.0);
		order.setItemList(items);
		order.setCustomerId(987654L);
		order.setRestaurantId(20001L);
		pdfGenerator.generatePDFReport(order);

		LOGGER.info("PDF Generation..!");

	}
*/
}
