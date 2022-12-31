import controller.InvoiceGeneratorController;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!!!!!!!!!!!!!!!!!");

        InvoiceGeneratorController invoiceGeneratorController = new InvoiceGeneratorController();
        invoiceGeneratorController.readFile();
    }
}