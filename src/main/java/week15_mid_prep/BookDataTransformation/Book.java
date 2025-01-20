package week15_mid_prep.BookDataTransformation;

import java.util.Date;

public class Book {

    private Date date;
    @WriteConcerns(case_format = CaseFormatter.ORDINARY)
    private String quarter;
    private int quantity;
    private int year;
    @WriteConcerns(case_format = CaseFormatter.UPPER_CASE)
    private String customerId;
    @WriteConcerns(number_format = NumberFormatter.COMMA)
    private double totalAmount;
    @WriteConcerns(number_format = NumberFormatter.PERCENTAGE)
    private double profitPercentage;
    private double profitIncrease;
    private double costPrice;

    //private constructor
    private Book(BookBuilder builder){
        this.date = builder.date;
        this.quarter = builder.quarter;
        this.quantity = builder.quantity;
        this.year = builder.year;
        this.customerId = builder.customerId;
        this.totalAmount = builder.totalAmount;
        this.profitPercentage = builder.profitPercentage;
        this.profitIncrease = builder.profitIncrease;
        this.costPrice = builder.costPrice;
    }

    //inner static class
    public static class BookBuilder{
        private Date date;
        private String quarter;
        private int quantity;
        private int year;
        private String customerId;
        private double totalAmount;
        private double profitPercentage;
        private double profitIncrease;
        private double costPrice;

        public BookBuilder(){

        }

        //setters returning builder type
        public BookBuilder setDate(Date date){
            this.date=date;
            return this;
        }

        public BookBuilder setQuarter(String quarter){
            this.quarter=quarter;
            return this;
        }

        public BookBuilder setQuantity(int quantity){
            this.quantity=quantity;
            return this;
        }

        public BookBuilder setYear(int year){
            this.year=year;
            return this;
        }

        public BookBuilder setCustomerId(String customerId){
            this.customerId=customerId;
            return this;
        }

        public BookBuilder setTotalAmount(double totalAmount){
            this.totalAmount=totalAmount;
            return this;
        }

        public BookBuilder setProfitPercentage(double profitPercentage){
            this.profitPercentage=profitPercentage;
            return this;
        }

        public BookBuilder setProfitIncrease(double profitIncrease){
            this.profitIncrease=profitIncrease;
            return this;
        }

        public BookBuilder setCostPrice(double costPrice){
            this.costPrice=costPrice;
            return this;
        }

        //public build method returning instance of outer class type
        public Book build(){
            return new Book(this);
        }
    }

    //writing getters in the outer method - to make private attributes accessible:
    public Date getDate(){
        return date;
    }

    public String getQuarter(){
        return quarter;
    }

    public int getQuantity(){
        return quantity;
    }

    public int getYear(){
        return year;
    }

    public String getCustomerId(){
        return customerId;
    }

    public double getTotalAmount(){
        return totalAmount;
    }

    public double getProfitPercentage(){
        return profitPercentage;
    }

    public double getProfitIncrease(){
        return profitIncrease;
    }

    public double getCostPrice(){
        return costPrice;
    }

}
