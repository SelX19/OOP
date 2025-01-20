package week15_final_prep.LibraryManagementSystem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class LibraryReportGenerator {

    public static void generateReport(String outputFileName, List<Book> books){

        try{
        //initialize the BufferedReader instance
        BufferedWriter writer= new BufferedWriter(new FileWriter(outputFileName));

        //firstly checking if the input read list is empty or not, and if existing
        if(books==null || books.isEmpty()){
            System.out.println("No books to generate report");
            return;
        }

        //else, start with reading header fields and writing the header line to the report:

        //extract the fields, using reflection:
        Field[] fields = Book.class.getDeclaredFields();
        StringBuilder headerLine = new StringBuilder(); //using StringBuilder so that we can use append() method

        //to get header, traverse through the single loop - through the fields of the header line only:
        for(int i=0; i<fields.length; i++){
            headerLine.append(fields[i].getName());
            if(i!=fields.length-1){ //if not the last field, add commas in between the field names
                headerLine.append(", ");
            }
        }

        //write the header line in the String form!
        writer.write(headerLine.toString());
        writer.newLine(); //skipping to the next line after header line

        //then, loop through all lines, and through all fields of each (double loop), format each field, write to line, and finally write each line to the report:
            for(Book book:books){
                StringBuilder line = new StringBuilder();
                for(int i=0; i<fields.length; i++){

                    Field field = fields[i]; //initializing current field - not to use each time fields[i]

                    field.setAccessible(true); //firstly setting each field to be accessible

                    //extracting original value of each field from each line
                    Object value = field.get(book);
                    String transformedValue = "";

                    //checking if the annotation is present on the field
                    if(field.isAnnotationPresent(FieldValidation.class)){
                        //if so, get(extract) the annotation
                        FieldValidation annotation = field.getAnnotation(FieldValidation.class);

                        //then checking if the value of the given field, in the given line, is of type String or other type
                        BookCategory category = book.getCategory();

                        if(value instanceof String){
                            String stringValue = (String)value;
                            if(category.equals(BookCategory.FICTION)){
                                transformedValue = stringValue.toUpperCase();
                            }
                            else if(category.equals(BookCategory.NON_FICTION)){
                                transformedValue = stringValue.toLowerCase();
                            }
                            else if(category.equals(BookCategory.SCIENCE) || category.equals(BookCategory.ARTS)){
                                transformedValue = capitalize(stringValue);
                            }
                            else{
                                transformedValue = stringValue;
                            }
                        }
                        else if(value instanceof Double || value instanceof Integer || value instanceof Float){
                            double number = ((Number)value).doubleValue();
                            if(field.getName().equalsIgnoreCase("price") && category.equals(BookCategory.TECHNOLOGY)){ //for the price field only, adn inside Technology Category, apply the discount
                                number*=0.9; //price is now 90% of the original price(number), 10% discount has been applied
                            }
                            transformedValue = String.format("%.2f", number);
                        }
                        else if(value instanceof Date){
                            Date date = (Date)value;
                            transformedValue = new SimpleDateFormat("yyyy-MM-dd").format(date);
                        }
                        else if(value instanceof AvailabilityStatus){
                            AvailabilityStatus availability = (AvailabilityStatus)value;

                            switch(availability){
                                case AVAILABLE -> transformedValue = "A";
                                case CHECKED_OUT -> transformedValue = "C";
                                case RESERVED -> transformedValue = "R";
                                case LOST -> transformedValue = "L";
                                default -> transformedValue = "";
                            }
                        }
                        else{
                            //if instance of anything else, just parse to String, no additional formatting needed:
                            transformedValue = value.toString();
                        }
                    }
                    else{
                        //as well, when annotation is not present, just parse to String with no additional formatting needed:
                        transformedValue = value.toString();
                    }
                    line.append(transformedValue);
                    if(i!=fields.length-1){
                        line.append(",");
                    }
                }
                writer.write(line.toString());
                writer.newLine();
            }
            writer.close();
        }
        catch(IOException | IllegalAccessException e){
            throw new RuntimeException(e);
        }
    }

    private static String capitalize(String str){
        if(str == null || str.isEmpty()){
            return str;
        }
        String[]words = str.split("\\s+"); //splitting sentence to words, dividing by 1 or more spaces

        StringBuilder capitalized = new StringBuilder();

        for(String word: words){
            if(word.length()>0){
                // word having at least 1 character - capitalizing the first character
                capitalized.append(Character.toUpperCase(word.charAt(0)));
                if(word.length()>1){
                    //if word has more than 1 character, appending all other characters in lower case
                    capitalized.append(word.substring(1).toLowerCase());
                }
                else{
                    //if no more characters after the first character, add space:
                    capitalized.append(" ");
                }
            }
        }
        return capitalized.toString();
    }
}
