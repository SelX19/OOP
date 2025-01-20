package week15_mid_prep.InvoiceManagement;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InvoiceProcessor {

    List<Invoice> invoices;

    public InvoiceProcessor(String fileName){
        this.invoices = loadInvoices(fileName);
    }

    public static List<Invoice> loadInvoices(String fileName){

        List<Invoice> invoices = new ArrayList<>();

        try{
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            List<String> lines = reader.lines().collect(Collectors.toList());

            for(int i=1; i<lines.size(); i++){

                String[] parts = lines.get(i).split(";");

                if(parts[0]=="" || parts[1]=="" || parts[5]==""){
                    throw new InvalidInvoiceException("Missing required field", new ClassCastException());
                }

                invoices.add(
                        new Invoice.InvoiceBuilder()
                                .setInvoiceDate(new SimpleDateFormat("MM/dd/yyyy").parse(parts[0]))
                                .setInvoiceNumber(parts[1])
                                .setQtr(Integer.parseInt(parts[2]))
                                .setYear(Integer.parseInt(parts[3]))
                                .setCustomerName(parts[4])
                                .setTotalAmount(Double.parseDouble(parts[5]))
                                .setTaxAmount(Double.parseDouble(parts[6]))
                                .setNetAmount(Double.parseDouble(parts[7]))
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
        return invoices;

    }
}
