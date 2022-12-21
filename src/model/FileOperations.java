package model;

import javax.xml.crypto.Data;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class FileOperations {

    public void readFile() {


        ArrayList<InvoiceHeader> invoices = new ArrayList<>();
        ArrayList<InvoiceLine> Lines = new ArrayList<>();
        BufferedReader br = null;
        String line = "";
        String splitBy = ",";
        try {
            br = new BufferedReader(new FileReader("C:\\Users\\DELL\\IdeaProjects\\untitled\\InvoiceHeaders.csv"));
        } catch (FileNotFoundException ex) {
            System.err.println("Invoice Header File is not Found");
        return;
        }
        while (true)   //returns a Boolean value
        {
            try {
                if (!((line = br.readLine()) != null)) break;
            } catch (IOException ex) {
                System.err.println("Invalid Invoice Header Format");
                return;
            }
            String[] invoiceHeader = line.split(splitBy);    // use comma as separator

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy h:mm");
            LocalDate local_date_1 = LocalDate.parse(invoiceHeader[1], dtf);
            InvoiceHeader invoice = new InvoiceHeader(invoiceHeader[0], local_date_1, invoiceHeader[2]);

            invoices.add(invoice);
        }
        try {
            br = new BufferedReader(new FileReader("C:\\Users\\DELL\\IdeaProjects\\untitled\\InvoiceLines.csv"));
        } catch (FileNotFoundException ex) {
            System.err.println("Invoice Line File is not Found");
            return;
        }
        while (true)   //returns a Boolean value
        {
            try {
                if (!((line = br.readLine()) != null)) break;
            } catch (IOException ex) {
                System.err.println("Invalid Invoice Line Format");
                return;
            }
            String[] invoiceLine = line.split(splitBy);    // use comma as separator


            InvoiceLine invline = new InvoiceLine(invoiceLine[0], invoiceLine[1], invoiceLine[2], invoiceLine[3]);
            Lines.add(invline);
            for (InvoiceHeader invoiceHeader : invoices
            ) {
                if (invoiceHeader.getInvoiceNumber().equals(invline.getInvoiceNumber())) {
                    invoiceHeader.getInvoiceLines().add(invline);

                }
            }
        }
        for (InvoiceHeader invoiceHeader : invoices
        ) {
            System.out.println("Invoice {" );

            System.out.println("Invoice: " + invoiceHeader.getInvoiceNumber());
            System.out.println("Invoice: " + invoiceHeader.getInvoiceNumber() + ", Date: " + invoiceHeader.getInvoiceDate() + ", Customer Name: " + invoiceHeader.getCustomerName());
            for (InvoiceLine invoiceLine : invoiceHeader.getInvoiceLines()
            ) {
                System.out.println("Item Name: " + invoiceLine.getItemName() + ", Price: " + invoiceLine.getItemPrice() + ", Count: " + invoiceLine.getCount());
            }
            System.out.println("}" );
        }

    }



    public void writeFile() {

    }

}
