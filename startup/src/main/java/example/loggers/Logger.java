package example.loggers;

import org.slf4j.LoggerFactory;

public class Logger {
    private org.slf4j.Logger logger = LoggerFactory.getLogger(Logger.class);
    
    private String prefix;

    public Logger() {
        prefix = "[LOGGER] ";
    }

    public void info(String message) {
        logger.info(prefix + message);
    }
    
    
}
