package controller;

import model.InvoiceHeader;
import model.InvoiceLine;
import view.InvoiceGeneratorViewer;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class InvoiceGeneratorController {

    public void readFile() {


        ArrayList<InvoiceHeader> invoices = new ArrayList<>();
        ArrayList<InvoiceLine> Lines = new ArrayList<>();
        BufferedReader br = null;
        String line = "";
        String splitBy = ",";
        try {
            String invoiceHeadersFilePath = new File("").getAbsolutePath() + "/InvoiceHeaders.csv";
            br = new BufferedReader(new FileReader(invoiceHeadersFilePath));
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
            String invoiceLinesFilePath = new File("").getAbsolutePath() + "/InvoiceLines.csv";
            br = new BufferedReader(new FileReader(invoiceLinesFilePath));
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

        InvoiceGeneratorViewer invoiceGeneratorViewer = new InvoiceGeneratorViewer();
        invoiceGeneratorViewer.DisplayInvoices(invoices);

    }



    public void writeFile() {

    }

}
