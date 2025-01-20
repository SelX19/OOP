package week15_final_prep.BookDataTransformation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.util.List;

public class ReportWriter {

    public static void writeReport(String outputFileName, List<Book> books){
        try{
            //firstly initializing bufferedWriter instance:
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));

            //extracting fields using reflexion
            Field[] fields = Book.class.getDeclaredFields();

            //checking if the field is the last one or not:
            for(int i=0; i<fields.length; i++){
                writer.write(
                        fields.length-1 == i ?
                                fields[i].getName().concat("\n") :
                                fields[i].getName().concat(";")
                );
            }

            //then looping through the fields:
            for(Book book:books){
                for(int i=0; i<fields.length; i++){
                    //firstly setting field to be accessible by using reflexion:
                    fields[i].setAccessible(true);

                    //checking if the annotation is present
                    if(fields[i].isAnnotationPresent(WriteConcerns.class)){
                        if(fields[i].get(book) instanceof String){

                            CaseFormatter caseFormat = fields[i].getAnnotation(WriteConcerns.class).case_format();

                            switch(caseFormat){
                                case LOWER_CASE -> writer.write(
                                        fields.length-1 == i ?
                                                fields[i].get(book).toString().toLowerCase().concat("\n") :
                                                fields[i].get(book).toString().toLowerCase().concat(";")
                                );
                                case UPPER_CASE -> writer.write(
                                        fields.length-1 == 1 ?
                                                fields[i].get(book).toString().toUpperCase().concat("\n") :
                                                fields[i].get(book).toString().toUpperCase().concat(";")
                                );
                                case ORDINARY -> writer.write(
                                        fields.length - 1 == i ?
                                                fields[i].get(book).toString().concat("\n") :
                                                fields[i].get(book).toString().concat(";")
                                );
                            }
                        }
                        else{
                            NumberFormatter numberFormat = fields[i].getAnnotation(WriteConcerns.class).number_format();

                            if(numberFormat == NumberFormatter.COMMA){
                                //using Java's in-built text format - DecimalFormat
                                DecimalFormat df = new DecimalFormat("#,###.##");
                                writer.write(
                                        fields.length-1==i ?
                                                df.format(fields[i].get(book)).concat("\n"):
                                                df.format(fields[i].get(book)).concat(";")
                                );
                            }
                            else{
                                //if NumberFormatter.PERCENTAGE
                                writer.write(
                                      fields.length-1==i ?
                                      "%".concat(fields[i].get(book).toString()).concat("\n"):
                                              "%".concat(fields[i].get(book).toString()).concat(";")
                                );
                            }
                        }
                    }
                    else{
                        //if annotation not present
                        writer.write(
                                fields.length - 1 == i ?
                                        fields[i].get(book).toString().concat("\n") :
                                        fields[i].get(book).toString().concat(";")
                        );
                    }
                }
            }
            writer.close();
        }
        catch(IOException e){
            throw new RuntimeException(e);
        }
        catch(IllegalAccessException e){
            throw new RuntimeException(e);
        }
    }
}
