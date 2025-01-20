package week15_mid_prep.InvoiceManagement;

import java.util.List;

public class MainRun {
    public static void main(String[]args){
        List<Invoice> invoices = InvoiceProcessor.loadInvoices("invoices.csv");
        CSVReportGenerator.generateReport("report.csv", invoices);
    }
}
