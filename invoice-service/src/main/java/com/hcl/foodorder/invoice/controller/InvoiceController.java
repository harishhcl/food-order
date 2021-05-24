package com.hcl.foodorder.invoice.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.foodorder.domain.order.Order;
import com.hcl.foodorder.invoice.pdf.PDFGenerator;
import com.itextpdf.text.DocumentException;

@RestController
@RequestMapping("invoices/v1")
public class InvoiceController {
	@Autowired
	private PDFGenerator generator;

	@PostMapping("/generateOrder")
	public ResponseEntity<String> generateInvoice(@RequestBody Order order) {
		try {
			generator.generatePDFReport(order);
		} catch (DocumentException | IOException e) {
			e.printStackTrace();
		}		
		return new ResponseEntity<>("Report has been generated ",HttpStatus.OK);
	}
}
