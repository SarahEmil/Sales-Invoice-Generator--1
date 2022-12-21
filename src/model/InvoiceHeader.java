package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
//DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

       // LocalDateTime now = LocalDateTime.now();
//String europeanDatePattern = "dd.MM.yyyy";
//DateTimeFormatter europeanDateFormatter = DateTimeFormatter.ofPattern(europeanDatePattern);
//System.out.println(europeanDateFormatter.format(LocalDate.of(2016, 7, 31)));

public class InvoiceHeader {

    private String InvoiceNumber;
    private LocalDate InvoiceDate;
    private String CustomerName;
    private ArrayList<InvoiceLine> InvoiceLines;

    public InvoiceHeader(String invoiceNumber, LocalDate invoiceDate, String customerName) {
        InvoiceNumber = invoiceNumber;
        InvoiceDate = invoiceDate;
        CustomerName = customerName;
        InvoiceLines = new ArrayList<>();
    }

    public String getInvoiceNumber() {
        return InvoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        InvoiceNumber = invoiceNumber;
    }

    public LocalDate getInvoiceDate() {
        return InvoiceDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        InvoiceDate = invoiceDate;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public ArrayList<InvoiceLine> getInvoiceLines() {
        return InvoiceLines;
    }

    public void setInvoiceLines(ArrayList<InvoiceLine> invoiceLines) {
        InvoiceLines = invoiceLines;
    }

}
