public class LoggerTest {
    public static void main(String[] args) {
        // Grab two references to see if they end up being identical
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("Testing the first logger reference.");
        logger2.log("Testing the second logger reference.");

        // Checking if both variables point to the exact same spot in memory
        if (logger1 == logger2) {
            System.out.println("SUCCESS: Both references point to the exact same Logger instance.");
        } else {
            System.out.println("FAILURE: Different instances were created!");
        }
    }
}