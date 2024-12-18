package week10.task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Start {
    public static void main(String[]args){
        List<Integer> grades = new ArrayList<>(Arrays.asList(6,8,10,9,7,8,6,8));
        Student student1 = new Student("Alma", "FHX34567", grades);

        GradeAnalyzer gradeAnalyzer = new GradeAnalyzer(student1);

        // Use reflection to access and print field names and values
        var fields = student1.getClass().getDeclaredFields();
        for(var field: fields){
            field.setAccessible(true);
            try{
                System.out.printf("Field:%s, Value:%s\n", field.getName(), field.get(student1));
            }
            catch(IllegalAccessException e){
                System.out.printf("Cannot access field:%s\n", field.getName());
            }
        }

        InvokeMethods(student1);
        InvokeMethods(gradeAnalyzer);

    }

    // defining method to use reflection to iterate through methods of both classes
    //invoke only those that start with 'calculate' or 'print'
    //If the method has a non-void return type, print its result.
    //For methods with a void return type, indicate that the method was invoked.

    public static void InvokeMethods(Object obj){
        Class<?> klasa = obj.getClass();

        var methods = klasa.getDeclaredMethods();
        for(var method:methods){
            if(method.getName().startsWith("calculate") || method.getName().startsWith("print")){
                try{
                    method.setAccessible(true);
                    var result = method.invoke(obj);
                    if(method.getReturnType()!= void.class){
                        System.out.printf("Result: %s\n",result);
                    }
                    else {
                        System.out.println("Method invoked successfully.");
                    }
                }
                catch(Exception e) {
                    System.out.printf("Errror invoking method: %s\n", method.getName());
                }
            }
        }
    }

    //or by using regex:
   //Pattern pattern = Pattern.compile("^(calculate|print).*");
    /* for (var method : methods) {
            if (pattern.matcher(method.getName()).matches()) {
            ....
     */
}
