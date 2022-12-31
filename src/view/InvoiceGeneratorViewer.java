package view;

import model.InvoiceHeader;
import model.InvoiceLine;

import java.util.ArrayList;

public class InvoiceGeneratorViewer {

    public void DisplayInvoices(ArrayList<InvoiceHeader> invoices) {
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
}
