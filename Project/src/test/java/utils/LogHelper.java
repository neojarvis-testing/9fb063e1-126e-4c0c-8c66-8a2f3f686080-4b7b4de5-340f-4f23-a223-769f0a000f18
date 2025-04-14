

package utils;
 
import java.text.SimpleDateFormat;
import java.util.Date;
 
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
 
public class LogHelper {
 
    private static final Logger logger = Logger.getLogger(LogHelper.class);
 
 
 
    static {
        try {
            // Set up a file appender with a timestamp in the filename
            String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
            String logFileName = "logs/logfile_" + timestamp + ".log";
           
            FileAppender fileAppender = new FileAppender(new PatternLayout("%d{ISO8601} %-5p %c - %m%n"), logFileName, true);
            logger.addAppender(fileAppender);
        } catch (Exception e) {
            logger.error("Failed to initialize logger file appender", e);
        }
    }
    
 
    public static void info(String message) {
        logger.info(message);
    }
 
    
 
    public static void error(String message) {
        logger.error(message);
    }

 
}



 