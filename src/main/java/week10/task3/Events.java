package week10.task3;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Events {
    private static final String[] EVENT_TYPES = {"Login", "Logout", "Purchase", "ViewPage", "Error"};
    private static final Random RANDOM = new Random();

    public void generateEventsFile(String fileName, int NumOfRecords){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
            for(int i=0; i<NumOfRecords; i++){
                //each record has:
                String timeStamp = generateRandomTimeStamp();
                String eventType = EVENT_TYPES[RANDOM.nextInt(EVENT_TYPES.length)];
                int userID = RANDOM.nextInt(100);

                //write record to the file
                writer.write(String.format("%s | Event Type: %s | User Id: %d ", timeStamp, eventType, userID));
                writer.newLine();
            }
            System.out.println("File generated successfully: " + fileName);
        }
        catch(IOException e){
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    private String generateRandomTimeStamp(){
        long currentTimeMillis = System.currentTimeMillis();
        long randomOffsetTimeMillis = RANDOM.nextInt(360*24*60*60*1000);//random number in millis in the last year range
        Date randomDate = new Date(currentTimeMillis-randomOffsetTimeMillis);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(randomDate);
    }

    public void printEventsFromFile(String fileName){
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String line;
            while((line=reader.readLine())!=null){
                System.out.println(line);
            }
        }
        catch(IOException e){
            System.err.println("Errror reading from the file" + e.getMessage());
        }
    }

    public List<String> readEventsFromFile(String fileName){
        List<String> events = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader((new FileReader(fileName)))){
            String line;
            while((line=reader.readLine())!=null){
                events.add(line);
            }
        }
        catch(IOException e){
            System.err.println("Errror reading from the file" + e.getMessage());
        }
        return events;
    }
}
