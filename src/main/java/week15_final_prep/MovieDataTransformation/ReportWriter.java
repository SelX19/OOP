package week15_final_prep.MovieDataTransformation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

public class ReportWriter {

    public static void generateReport(String outputFileName, List<Movie>movies){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));

            Field[] fields = Movie.class.getDeclaredFields();

            movies.get(0).toString().toUpperCase(); //he first line - headers shall be in uppercase

            for(int i=1; i<movies.size(); i++){
                for(int j=0; j<fields.length; j++){ //field=attribute

                    fields[j].setAccessible(true);

                    if(fields[j].isAnnotationPresent(FieldFormat.class)){

                        if(fields[j].get(i) instanceof String){ //if line is instance of string!

                            TextFormatter tf = fields[j].getAnnotation(FieldFormat.class).text_format();

                            switch(tf){
                                case ORDINARY -> writer.write( //firstly checking if the field is the last one or not
                                        fields.length-1 == j ?
                                                fields[j].get(i).toString().concat("\n"):
                                                fields[j].get(i).toString().concat(",")
                                );
                                case UPPER_CASE -> writer.write(
                                        fields.length-1==j ?
                                                fields[j].get(i).toString().toUpperCase().concat("\n"):
                                                fields[j].get(i).toString().toUpperCase().concat(";")
                                );
                                case LOWER_CASE ->writer.write(
                                        fields.length-1==j ?
                                                fields[j].get(i).toString().toLowerCase().concat("\n"):
                                                fields[j].get(i).toString().toLowerCase().concat(";")
                                );
                            }
                        }
                        else{
                            NumberFormatter nf = fields[j].getAnnotation(FieldFormat.class).number_format();

                            switch(nf){
                                case PERCENTAGE -> writer.write(
                                        fields.length-1==j ?
                                                "%".concat(fields[j].get(i).toString()).concat("\n"):
                                                "%".concat(fields[j].get(i).toString()).concat(";")
                                );
                                case CURRENCY -> writer.write(
                                        fields.length-1==j ?
                                                "$".concat(fields[j].get(i).toString()).concat("\n"):
                                                "$".concat(fields[j].get(i).toString()).concat(";")

                                );
                            }

                        }

                    }
                    else{
                        //if annotation not present
                        writer.write(
                                fields.length - 1 == i ?
                                        fields[i].get(i).toString().concat("\n") :
                                        fields[i].get(i).toString().concat(";") //regular formatting - copy-pasting form from the original file
                        );
                    }
                }
            }
            writer.close(); //P.S.:don't forget this line!!
        }
        catch(IOException | IllegalAccessException e){
            throw new RuntimeException(e);
        }

    }
}
