package week13.Task3;

public class Main {
    public static void main(String[] args) {
        // Creating a TextEditor instance
        TextEditor editor = new TextEditor();

        // Using UpperCaseFormatter - via using TextEditor and its method setFormatter, etc.
        editor.setFormatter(new UpperCaseFormatter());
        System.out.println(editor.formatText("hello world"));

        // Using LowerCaseFormatter
        editor.setFormatter(new LowerCaseFormatter());
        System.out.println(editor.formatText("HELLO WORLD"));

        // Using CamelCaseFormatter
        editor.setFormatter(new CamelCaseFormatter());
        System.out.println(editor.formatText("hello world from java"));
    }
}
