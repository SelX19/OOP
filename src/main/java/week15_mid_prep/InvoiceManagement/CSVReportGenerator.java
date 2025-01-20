package week15_mid_prep.InvoiceManagement;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

//2nd way of file writing - Mirza's way:
public class CSVReportGenerator {

    public static void generateReport(String outputFileName, List<Invoice>invoices){
        try(BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputFileName))){
            //write a header line
            writer.write("InvoiceDate,InvoiceNumber,Qtr,Year,CustomerName,TotalAmount,TaxAmount,NetAmount\n");

            //looping through the lines/record(invoices) and through their fields - using reflection to get fields, and StringBuilder to initialize line to which later fields will be appended:
            for(Invoice invoice: invoices){
                StringBuilder line = new StringBuilder();
                for(Field field:invoice.getClass().getDeclaredFields()){
                    //firstly set each field to be accessible
                    field.setAccessible(true);
                    //then extract custom annotation - FieldFormat (if present)
                    FieldFormat annotation = field.getAnnotation(FieldFormat.class);

                    Object value = field.get(invoice); //***

                    //then checking annotation if present
                    if(annotation!=null){
                        if(value instanceof String){
                            //annotation = field.getAnnotation(FieldFormat.class) **
                            TextFormat tf = annotation.text_format();
                            if(tf == TextFormat.CAPITALIZE){
                                value = capitalize((String)value);
                            }
                            else if(tf == TextFormat.LOWERCASE){
                                value = ((String)value).toLowerCase();
                            }
                            //else, leave it as it is
                        }
                        else if (value instanceof Double){
                            CurrencyFormat cf = annotation.currency_format();
                            value = formatCurrency((Double)value, cf);
                        }
                    }
                    //appending field value to the line
                    line.append(value).append(",");
                }
                //writing new line
                writer.write(line.substring(0, line.length()-1)+"\n");
            }
        }
        catch(IOException | IllegalAccessException e){
            throw new RuntimeException(e);
        }
    }

    private static String capitalize(String input) {
        String[] words = input.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(word.substring(0, 1).toUpperCase()).append(word.substring(1).toLowerCase()).append(" ");
        }
        return result.toString().trim();
    }

    private static String formatCurrency(Double value, CurrencyFormat format) {
        switch (format) {
            case USD:
                return "$" + value;
            case EURO:
                return "€" + value;
            case INR:
                return "₹" + value;
            default:
                return value.toString();
        }
    }
}
