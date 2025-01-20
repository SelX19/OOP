package week15_mid_prep.LibraryManagementSystem;

import java.util.List;

public class Main {
    public static void main(String[]args){
        try{
        List<Book> books = LibraryLoader.loadBooks("/Users/selmadjozic/IdeaProjects/OOP_labss/src/main/resources/books.csv");
        LibraryReportGenerator.generateReport("library_report.csv", books);
        System.out.println("Library report has been successfully generated.");
        }
        catch (InvalidBookException e) {
            System.err.println("Error processing books: " + e.getMessage());
            e.printStackTrace();
        } catch (RuntimeException e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
