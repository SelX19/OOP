package week6;

//task5:

public class BinarySearch {
    public static boolean search(int[] array, int searchedValue){
        for(int i=0; i<array.length; i++){
            if(array[i]==searchedValue){
                return true;
            }
        }
        return false;
    }
}
