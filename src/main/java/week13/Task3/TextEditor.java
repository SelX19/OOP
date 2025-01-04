package week13.Task3;

public class TextEditor {

    private TextFormatter formatter;

    //setting formatter dynamically
    public void setFormatter(TextFormatter formatter){
        this.formatter=formatter;
    }

    //use current formatter to format text
    public String formatText(String text){
        if(formatter==null){
            throw new IllegalStateException("TextFormatter is not set!");
        }
        return formatter.formatText(text);
    }

}
