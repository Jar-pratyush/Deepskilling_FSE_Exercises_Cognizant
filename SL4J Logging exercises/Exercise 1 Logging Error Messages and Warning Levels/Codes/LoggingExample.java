import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//Demonstrating professional logging levels instead of standard print statements.
public class LoggingExample {

    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {
        logger.error("This is an error message");
        logger.warn("This is a warning message");
    }
}