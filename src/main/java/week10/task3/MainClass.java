package week10.task3;

import java.util.List;

public class MainClass {
    public static void main(String[]args){
        Events event = new Events();
        //adding events with randomly assigned date, type, id into the list
        event.generateEventsFile("This year's events", 20);

        System.out.println("\nEvents from the file:");
        event.printEventsFromFile("This year's events");

        System.out.println("\nEvents read into a list:");
        List<String> events = event.readEventsFromFile("This year's events");
        for(String eventRecord:events){
            System.out.println(eventRecord);
        }

    }
}
