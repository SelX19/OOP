package week15_final_prep.LibraryManagementSystem;

import java.util.Date;

public interface BookFactory {
    public Book createBook(String isbn, String title, String author, Date publicationDate, BookCategory category,
    double price, AvailabilityStatus availability) throws InvalidBookException;
}
