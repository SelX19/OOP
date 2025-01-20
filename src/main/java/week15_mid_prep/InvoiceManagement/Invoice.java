package week15_mid_prep.InvoiceManagement;

import java.util.Date;

public class Invoice {
    private Date invoiceDate;
    @FieldFormat(text_format = TextFormat.CAPITALIZE)
    private String invoiceNumber;
    private int qtr;
    private int year;
    @FieldFormat(text_format = TextFormat.CAPITALIZE)
    private String customerName;
    @FieldFormat(currency_format = CurrencyFormat.USD)
    private double totalAmount;
    @FieldFormat(currency_format = CurrencyFormat.EURO)
    private double taxAmount;
    private double netAmount;

    private Invoice(InvoiceBuilder builder){
        invoiceDate = builder.invoiceDate;
        invoiceNumber = builder.invoiceNumber;
        qtr = builder.qtr;
        year = builder.year;
        customerName = builder.customerName;
        totalAmount = builder.totalAmount;
        taxAmount = builder.taxAmount;
        netAmount = builder.netAmount;
    }

    public static class InvoiceBuilder{
        private Date invoiceDate;
        private String invoiceNumber;
        private int qtr;
        private int year;
        private String customerName;
        private double totalAmount;
        private double taxAmount;
        private double netAmount;

        public InvoiceBuilder(){

        }

        public InvoiceBuilder setInvoiceDate(Date date){
            this.invoiceDate=date;
            return this;
        }

        public InvoiceBuilder setInvoiceNumber(String invoiceNumber){
            this.invoiceNumber=invoiceNumber;
            return this;
        }

        public InvoiceBuilder setQtr (int qtr){
            this.qtr = qtr;
            return this;
        }

        public InvoiceBuilder setYear (int year){
            this.year = year;
            return this;
        }

        public InvoiceBuilder setCustomerName(String customerName){
            this.customerName=customerName;
            return this;
        }

        public InvoiceBuilder setTotalAmount(double totalAmount){
            this.totalAmount = totalAmount;
            return this;
        }

        public InvoiceBuilder setTaxAmount(double taxAmount){
            this.taxAmount = taxAmount;
            return this;
        }

        public InvoiceBuilder setNetAmount(double netAmount){
            this.netAmount = netAmount;
            return this;
        }

        public Invoice build(){
            return new Invoice(this);
        }
    }

    public Date getInvoiceDate(){
        return invoiceDate;
    }

    public String getInvoiceNumber(){
        return invoiceNumber;
    }

    public int getQtr(){
        return qtr;
    }

    public int getYear(){
        return year;
    }

    public String getCustomerName(){
        return customerName;
    }

    public double getTotalAmount(){
        return totalAmount;
    }

    public double getTaxAmount(){
        return taxAmount;
    }

    public double getNetAmount(){
        return netAmount;
    }


}
