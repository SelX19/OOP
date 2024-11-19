package week6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Methods {
    //task1:
    public static int smallest(int[]array){
        int smallest = array[0];
        for(int i=0; i<array.length; i++){
            if(array[i]<smallest){
                smallest = array[i];
            }
        }
        return smallest;
    }

    //task2:
    public static int indexOfSmallest(int[] array){
        int smallest = array[0];
        int smallestIndex = 0;
        for(int i=0; i<array.length; i++){
            if(array[i]<smallest){
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }


    //task3:
    public static int indexOfTheSmallestStartingFrom (int[] array, int index){
        int smallest = array[index];
        int smallest_index = index;
        for(int i=index; i<array.length; i++){
            if(array[i]<smallest){
                smallest_index = i;
            }
        }
        return smallest_index;
    }

    //task4:
    public static void swap(int[] array, int index1, int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void main(String [] args){
        //task1:
        int[] values = {6, 5, 8, 6, 11};
        System.out.println("smallest: " + smallest(values));

        //task2:
        System.out.println("Index of smallest: " + indexOfSmallest(values));

        //task3:
        int[] values3 = {-1, 6, 9, 8, 12};
        System.out.println(indexOfTheSmallestStartingFrom(values, 1));
        System.out.println(indexOfTheSmallestStartingFrom(values, 2));
        System.out.println(indexOfTheSmallestStartingFrom(values, 4));

        //task4:
        int[] values4 = {3, 2, 5, 4, 8};
        System.out.println(Arrays.toString(values4));
        swap(values4, 1, 0);
        System.out.println(Arrays.toString(values4));
        swap(values4, 0, 3);
        System.out.println(Arrays.toString(values4));

        //task5:
        int[] array = {-3, 2, 3, 4, 7, 8, 12};
        Scanner reader = new Scanner(System.in);
        System.out.println("Values of the array: " + Arrays.toString(array));
        System.out.println();
        System.out.println("Enter searched number: ");
        String searchedValue = reader.nextLine();
        System.out.println();
        boolean result = BinarySearch.search(array, Integer.parseInt(searchedValue));
        String in_not_in;
        if(result){
            in_not_in = "in";
        }
        else{
            in_not_in = "not in";
        }
        System.out.println("Value " + searchedValue + " is " + in_not_in + " the array: " + Arrays.toString(array));

    }
}
