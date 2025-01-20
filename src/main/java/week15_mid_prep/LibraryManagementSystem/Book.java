package week15_mid_prep.LibraryManagementSystem;

import java.util.Date;

public class Book {
    @FieldValidation
    private String isbn;
    @FieldValidation
    private String title;
    @FieldValidation
    private String author;
    @FieldValidation
    private Date publicationDate;
    @FieldValidation
    private BookCategory category;
    @FieldValidation
    private double price;
    @FieldValidation
    private AvailabilityStatus availability;

    //constructor:
    public Book(String isbn, String title, String author, Date publicationDate, BookCategory category,
                double price, AvailabilityStatus availability){
        this.isbn=isbn;
        this.title=title;
        this.author=author;
        this.publicationDate=publicationDate;
        this.category=category;
        this.price=price;
        this.availability=availability;
    }
    //getters:
    public String getIsbn(){
        return isbn;
    }
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public Date getPublicationDate(){
        return publicationDate;
    }
    public BookCategory getCategory(){
        return category;
    }
    public double getPrice(){
        return price;
    }
    public AvailabilityStatus getAvailability(){
        return availability;
    }
    //setters:
    public void setIsbn(String isbn){
        this.isbn=isbn;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public void setAuthor(String author){
        this.author=author;
    }
    public void setPublicationDate(Date publicationDate){
        this.publicationDate=publicationDate;
    }
    public void setCategory(BookCategory category){
        this.category=category;
    }
    public void setPrice(double price){
        this.price=price;
    }
    public void setAvailability(AvailabilityStatus availability){
        this.availability=availability;
    }
}
