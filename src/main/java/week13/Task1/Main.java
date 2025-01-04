package week13.Task1;

public class Main {

    public static void main(String[]args){
        Logger logger = Logger.getInstance();

        logger.log("Performing initialization tasks...");
        logger.logInfo("App started.");
        logger.logWarning("Low memory detected.");

        try {
            int result = 10 / 0; // Simulating an error
        } catch (ArithmeticException e) {
            logger.logError("An error occurred: Division by zero.");
        }

        logger.logInfo("Application running smoothly.");
        logger.log("Performing shutdown tasks...");
        logger.logInfo("Application terminated.");

    }
}
