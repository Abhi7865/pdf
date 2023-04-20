package com.example.pdf.controller;

import java.awt.PageAttributes.MediaType;


import java.io.ByteArrayInputStream;
import java.net.http.HttpHeaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.HttpHeadersReturnValueHandler;

import com.example.pdf.Payload.RequestPayload;
import com.example.pdf.service.PdfService;


@Controller
@RequestMapping("/pdf")
public class pdfController {
	
	@Autowired
	private PdfService pdfService;
	
	
	@PostMapping("/createPdf")
	public ResponseEntity<InputStreamResource> Createpdf(@RequestBody RequestPayload requestPayload) {
		ByteArrayInputStream pdf= pdfService.createPdf(requestPayload);
		
		org.springframework.http.HttpHeaders httpHeaders = new org.springframework.http.HttpHeaders();
		httpHeaders.add("content-disposition",null);
		
		return ResponseEntity
				.ok()
				.headers(httpHeaders)
				.contentType(org.springframework.http.MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(pdf));
	}
	
	/*
	 * @PostMapping("/LoanPdf") public ResponseEntity<InputStreamResource>
	 * CreateCustomerPdf(@RequestBody RequestPayload requestPayload ) {
	 * ByteArrayInputStream pdf= pdfService.createLoanPdf(requestPayload);
	 * 
	 * org.springframework.http.HttpHeaders httpHeaders = new
	 * org.springframework.http.HttpHeaders();
	 * httpHeaders.add("content-disposition",null);
	 * 
	 * return ResponseEntity .ok() .headers(httpHeaders)
	 * .contentType(org.springframework.http.MediaType.APPLICATION_PDF) .body(new
	 * InputStreamResource(pdf)); }
	 */

}
