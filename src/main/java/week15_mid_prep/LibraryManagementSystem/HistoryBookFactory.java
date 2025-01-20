package week15_mid_prep.LibraryManagementSystem;

import java.util.Date;

public class HistoryBookFactory implements BookFactory{
    @Override
    public Book createBook(String isbn, String title, String author, Date publicationDate, BookCategory category,
                           double price, AvailabilityStatus availability) throws InvalidBookException{
        return new Book(isbn, title, author, publicationDate, BookCategory.HISTORY, price, availability);
    }
}
