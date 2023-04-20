package com.example.pdf.Payload;

public class RequestPayload {
	private String LoanNumber;
	private String firstName;
	private String lastName;
	private String dob;
	private long loanAmount;
	private int loanTennure;
	private long LoanEmi;
	
	public String getLoanNumber() {
		return LoanNumber;
	}
	public void setLoanNumber(String loanNumber) {
		LoanNumber = loanNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public long getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(long loanAmount) {
		this.loanAmount = loanAmount;
	}
	public int getLoanTennure() {
		return loanTennure;
	}
	public void setLoanTennure(int loanTennure) {
		this.loanTennure = loanTennure;
	}
	public long getLoanEmi() {
		return LoanEmi;
	}
	public void setLoanEmi(long loanEmi) {
		LoanEmi = loanEmi;
	}
	
		
	

}
