public class Logger {
    // Volatile variable makes sure changes are visible across different threads instantly
    private static volatile Logger instance;

    // Private constructor so nobody can use 'new Logger()' from outside
    private Logger() {
    }

    // Double-checked locking method to get the single instance safely
    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("[LOG]: " + message);
    }
}