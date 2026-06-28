// Singleton Pattern 
class Logger {
    private static Logger instance;
    private Logger() {
        System.out.println("Logger instance created");
    }
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }   
    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}
public class SingletonPattern {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        logger1.log("First log message");
        Logger logger2 = Logger.getInstance();
        logger2.log("Second log message");
        if (logger1 == logger2) {
            System.out.println("Both instances are the same - Singleton works!");
        } else {
            System.out.println("Instances are different - Singleton failed!");
        }
        System.out.println("Logger1 hash: " + logger1.hashCode());
        System.out.println("Logger2 hash: " + logger2.hashCode());
    }
}
