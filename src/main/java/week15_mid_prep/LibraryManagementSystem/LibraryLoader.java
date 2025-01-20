package week15_mid_prep.LibraryManagementSystem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class LibraryLoader {

    List<Book> books = new ArrayList<>();

    LibraryLoader(String fileName){
        books=loadBooks(fileName);
    }

    public static List<Book>loadBooks(String fileName){

        List<Book>books = new ArrayList<>();

        try{
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            List<String>lines = reader.lines().collect(Collectors.toList());

            if(lines.get(1)==null){ //first line after header
                throw new InvalidBookException("CSV file is empty(only header line is present.");
            }

            for(int i=1; i<lines.size(); i++){

                String[] parts = lines.get(i).split(",");

                if(parts.length!=7){
                    throw new InvalidBookException("Invalid number of fields.");
                }

                //All parts named correspondingly:
                String isbn = parts[0].trim();
                String title = parts[1].trim();
                String author = parts[2].trim();
                String publicationDateString = parts[3].trim();
                String categoryString = parts[4].toUpperCase().trim();
                String priceString = parts[5].trim();
                String availabilityString = parts[6].toUpperCase().trim();

                if(isbn.isEmpty() || title.isEmpty() || author.isEmpty()){
                    throw new InvalidBookException("Mandatory fields are empty", new ClassCastException());
                }

                //isbn, title, author shall be in the String format, so no casting needed for those fields

                //validating publicationDate

                Date publicationDate;
                try{
                    publicationDate = new SimpleDateFormat("yyyy-MM-dd").parse(publicationDateString);
                }
                catch(ParseException e){
                    throw new InvalidBookException("Invalid date form at line " + lines.get(i), e);
                }

                //if having valid form, but out of range
                if(publicationDate.after(new Date())){
                    throw new InvalidBookException("Date is set to the future, exceeding current date");
                }

                //validating category
                BookCategory category;
                if(categoryString.isEmpty()){
                    // no value, set category to default value:
                    category = BookCategory.FICTION;
                }
                else{
                    //if value present, take value of String bookCategoryStr and set it to value of category
                    try{
                        category = BookCategory.valueOf(categoryString);
                    }
                    catch(IllegalArgumentException e){
                        throw new InvalidBookException("Invalid book category at line " + lines.get(i));
                    }
                }

                //validating price
                double price;
                try{
                    price = Double.parseDouble(priceString);
                    if(price<0){
                        throw new InvalidBookException("Invalid price set at line " + lines.get(i) + ", must not be lower than zero.", new ClassCastException());
                    }
                }
                catch(NumberFormatException e){
                    throw new InvalidBookException("Invalid price format, at the line " + lines.get(i));
                }

                //validating availability field
                AvailabilityStatus availability;
                if(availabilityString.isEmpty()){
                    //setting to default, if not already set
                    availability = AvailabilityStatus.AVAILABLE;
                }
                else{
                    try{
                        availability = AvailabilityStatus.valueOf(availabilityString);
                    }
                    catch(IllegalArgumentException e){
                        throw new InvalidBookException("Invalid availability status set at the line " + lines.get(i));
                    }
                }

                //using factory method

                BookFactory factory; //interface

                switch(category){ // based on the category we call the implementing class, to override interface's main method 'createBook()'
                    case FICTION:
                        factory = new FictionBookFactory(); break;
                    case NON_FICTION:
                        factory = new NonFictionBookFactory(); break;
                    case SCIENCE:
                        factory = new ScienceBookFactory(); break;
                    case ARTS:
                        factory = new ArtsBookFactory(); break;
                    case HISTORY:
                        factory = new HistoryBookFactory(); break;
                    case TECHNOLOGY:
                        factory = new TechnologyBookFactory(); break;
                    default:
                        factory = new FictionBookFactory(); break;
                }

                Book book = factory.createBook(isbn, title, author, publicationDate, category, price, availability);
                books.add(book);
            }
        }
        catch(FileNotFoundException e){
            throw new RuntimeException(e);
        }
        return books;
    }
}

