package week15_final_prep.BookDataTransformation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FinalPrep {

    List<Book> myBooks = new ArrayList<>();

    //constructor, using loadBooks method
    public FinalPrep(String fileName){
       this.myBooks = loadBooks(fileName);
    }

    //getter for the constructed list of books
    public List<Book> getMyBooks(){
        return myBooks;
    }

    public static List<Book> loadBooks(String fileName){
        List<Book> books = new ArrayList<>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            //reading all file lines
            List<String> lines = reader.lines().collect(Collectors.toList());

            //looping through the read lines and writing them to instantiated list
            //skipping the header line - starting from i=1
            for(int i=1; i<lines.size(); i++){
                //creating array of each line parts:
                String[] parts = lines.get(i).split(";");

                //testing if 1st, 5th and 6th (date, customerId, totalAmount) columns of each line are empty, and throwing custom exception if they are:
                if(parts[0] == ""  || parts[4] == "" || parts[5] == ""){
                    throw new WrongFormatException("Values are empty", new ClassCastException());
                }

                //otherwise, use each part by builder to set each attribute and add to list 1 read line of file
                books.add(
                        new Book.BookBuilder()
                                .setDate(new SimpleDateFormat("MM/dd/yyyy").parse(parts[0]))
                                .setQuarter(parts[1])
                                .setQuantity(Integer.parseInt(parts[2]))
                                .setYear(Integer.parseInt(parts[3]))
                                .setCustomerId(parts[4])
                                .setTotalAmount(Double.parseDouble(parts[5]))
                                .setProfitPercentage(Double.parseDouble(parts[6]))
                                .setProfitIncrease(Double.parseDouble(parts[7]))
                                .setCostPrice(Double.parseDouble(parts[8]))
                                .build()
                );

            }
        }
        catch(FileNotFoundException e){
            throw new RuntimeException(e);
        }
        catch(ParseException e){
            e.printStackTrace();
        }
        return books;
    }

}
