package model;

public class InvoiceLine {

    private InvoiceHeader InvoiceHeader;
    private String InvoiceNumber;
    private String ItemName;
    private String ItemPrice;
    private String Count;

    public InvoiceLine( String invoiceNumber, String itemName, String itemPrice, String count) {

        InvoiceNumber = invoiceNumber;
        ItemName = itemName;
        ItemPrice = itemPrice;
        Count = count;
    }

    public model.InvoiceHeader getInvoiceHeader() {
        return InvoiceHeader;
    }

    public void setInvoiceHeader(model.InvoiceHeader invoiceHeader) {
        InvoiceHeader = invoiceHeader;
    }

    public String getInvoiceNumber() {
        return InvoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        InvoiceNumber = invoiceNumber;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public String getItemPrice() {
        return ItemPrice;
    }

    public void setItemPrice(String itemPrice) {
        ItemPrice = itemPrice;
    }

    public String getCount() {
        return Count;
    }

    public void setCount(String count) {
        Count = count;
    }
}
