package week13.Task3;

public class CamelCaseFormatter implements TextFormatter{
    @Override
    public String formatText(String text){
        StringBuilder result = new StringBuilder(); //to enable appending of characters
        boolean toUpperCase = true; //initially set to true, since the first character shall be capital

        for(char c: text.toCharArray()){
            if(Character.isWhitespace(c)){
                toUpperCase=true; // indicating the following character shall be converted to capital letter
            }
            else{
                result.append(toUpperCase ? Character.toUpperCase(c) : Character.toLowerCase(c)); //depending on the flag, converting the characters to lower/upper case, and joining them all together into one array of characters
                toUpperCase=false;
            }
        }

        return result.toString(); //converting array of characters into string
    }
}
