package week15_final_prep.LibraryManagementSystem;

import java.util.Date;

public class FictionBookFactory implements BookFactory{
    @Override
    public Book createBook(String isbn, String title, String author, Date publicationDate, BookCategory category,
                           double price, AvailabilityStatus availability) throws InvalidBookException{
        return new Book(isbn, title, author, publicationDate, BookCategory.FICTION, price, availability);
    }
}
