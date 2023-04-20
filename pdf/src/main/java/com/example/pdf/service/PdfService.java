package com.example.pdf.service;

import java.io.ByteArrayInputStream; 

import java.io.ByteArrayOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.util.RequestPayload;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class PdfService {

	private Logger logger= LoggerFactory.getLogger(PdfService.class);
	
	
	
	public ByteArrayInputStream createPdf(com.example.pdf.Payload.RequestPayload requestPayload) {
		logger.info("Create PDF Started :");
		String title ="LOAN DETAILS";
		String content="TERMS & CONDITIONS";
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		Document document = new Document();
		
		
		 PdfWriter.getInstance(document, out);
		 
		 
		 
		 HeaderFooter footer = new HeaderFooter(false, new Phrase("LTIMINDTREE"));
		 footer.setAlignment(Element.ALIGN_CENTER);
		 footer.setBorderWidthBottom(0);
		 document.setFooter(footer);
		 
		 
		 
		 document.open();
		 Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		Paragraph TitlePara = new Paragraph(title,titleFont );
		TitlePara.setAlignment(Element.ALIGN_CENTER);
		
		document.add(TitlePara);
		document.add(new Paragraph("--------------------------------------------------------------------------------------------------------------------------"));
		
		document.add(new Paragraph("LoanNumber:"+requestPayload.getLoanNumber()));
	
        document.add(new Paragraph("Name: "+requestPayload.getFirstName()+"  "+requestPayload.getLastName()));
        document.add(new Paragraph("Date Of Birth: "+requestPayload.getDob()));
        document.add(new Paragraph("LoanAmount: "+requestPayload.getLoanAmount()));
        document.add(new Paragraph("loanTennure: "+requestPayload.getLoanTennure()+" Year"));
        document.add(new Paragraph("LoanEmi: "+requestPayload.getLoanEmi()));
        
        document.add(new Paragraph(":"));
        
		Font paraFont = FontFactory.getFont(FontFactory.HELVETICA,19);
		Paragraph paragraph = new Paragraph(content);
		
		document.add(new Paragraph("--------------------------------------------------------------------------------------------------------------------------"));
		
		paragraph.setAlignment(Element.ALIGN_CENTER);
		document.add(paragraph);
		
		document.add(new Paragraph("\r\n"
				+ "1. The loan must be repaid within six months of the date of agreement or by a date agreed upon by both parties, whichever is earlier.\r\n"
				+ "\r\n"
				+ "2. The loan may be subject to an interest rate as agreed upon by both parties.\r\n"
				+ "\r\n"
				+ "3. The borrower must provide proof of income and/or assets to the lender prior to the loan being approved.\r\n"
				+ "\r\n"
				+ "4. The borrower must pay all fees associated with the loan and any other fees incurred during the loan repayment period.\r\n"
				+ "\r\n"
				+ "5. The borrower is responsible for ensuring that all payments are made on time and in full.\r\n"
				+ "\r\n"
				+ "6. The borrower must notify the lender of any change in address or other contact details.\r\n"
				+ "\r\n"
				+ "7. The lender reserves the right to increase the interest rate or change the terms of the loan if the borrower misses any payments.\r\n"
				+ "\r\n"
				+ "8. The loan must be repaid in full, even if the borrower dies or is declared bankrupt.\r\n"
				+ "\r\n"
				+ "9. The lender reserves the right to take legal action against the borrower if the loan is not repaid.\r\n"
				+ "\r\n"
				+ "10.The borrower agrees to the terms and conditions set out in the loan agreement."));
		
		
		
		document.close();
		return new ByteArrayInputStream(out.toByteArray());
		
	}
	

	
}
